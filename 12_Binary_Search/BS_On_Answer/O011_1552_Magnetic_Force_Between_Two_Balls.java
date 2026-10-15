package Binary_Search.BS_On_Answer;

import java.util.Arrays;

public class O011_1552_Magnetic_Force_Between_Two_Balls {

    public static int maxDistance(int[] position, int m) {
        // Distances only make sense between neighbours in order, so sort first
        Arrays.sort(position);

        // Search range for the answer, which is a FORCE (distance):
        // left  = 1 (positions are distinct integers, so the smallest gap is at least 1)
        // right = distance between the two end baskets (balls can't be farther apart than this)
        int left = 1, right = position[position.length - 1] - position[0];

        // Binary search for the LARGEST minimum force that works (stops when left == right)
        while (left < right) {
            // mid = the minimum force we are testing: "can every pair of balls be >= mid apart?"
            // Round up so that 'left = mid' always makes progress (no infinite loop)
            int mid = left + (right - left + 1) / 2;

            if (canPlace(position, mid, m)) {
                // All m balls fit with gaps >= mid, so mid works; try a larger force
                left = mid;
            } else {
                // Can't fit m balls with gaps >= mid, so mid is too large
                right = mid - 1;
            }
        }

        // left == right is the largest possible minimum force
        return left;
    }

    // Returns true if m balls can be placed so every neighbouring pair is at least 'force' apart
    private static boolean canPlace(int[] position, int force, int m) {
        int balls = 1;               // place the first ball in the first basket
        int lastPos = position[0];   // position of the most recently placed ball

        for (int i = 1; i < position.length; i++) {
            // Greedy: place the next ball at the earliest basket that is far enough from the last one
            if (position[i] - lastPos >= force) {
                balls++;
                lastPos = position[i];
            }
        }

        // Valid only if we managed to place all m balls
        return balls >= m;
    }

    public static void main(String[] args) {
        // Each test: position[], m, expected answer
        int[][] positions = {
                {1, 2, 3, 4, 7},                    // Example 1: balls at 1, 4, 7
                {5, 4, 3, 2, 1, 1000000000},        // Example 2: balls at 1 and 10^9
                {1, 2, 3, 4, 5, 6}                  // Extra: m = n, every basket used
        };
        int[] ms = {3, 2, 6};
        int[] expected = {3, 999999999, 1};

        for (int i = 0; i < positions.length; i++) {
            int actual = maxDistance(positions[i], ms[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}
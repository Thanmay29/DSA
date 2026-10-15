package Binary_Search.BS_On_Answer;

public class O08_1231_Divide_Chocolate {

    public static int maximizeSweetness(int[] sweetness, int K) {
        // Search range for "the sweetness of the piece I eat":
        // left  = 1 (every chunk is at least 1)
        // right = total / (K+1) (the smallest piece can't beat the average piece)
        int left = 1, total = 0;

        for (int s : sweetness) {
            total += s;
        }

        int right = total / (K + 1);

        // Binary search for the LARGEST minimum sweetness that works (stops when left == right)
        while (left < right) {
            // Round up so that 'left = mid' always makes progress (no infinite loop)
            int mid = left + (right - left + 1) / 2;

            if (canDivide(sweetness, mid, K + 1)) {
                // Every piece can be >= mid, so mid works; try for an even sweeter minimum
                left = mid;
            } else {
                // Can't get enough pieces of sweetness >= mid, so mid is too high
                right = mid - 1;
            }
        }

        // left == right is the maximum possible sweetness of the smallest piece
        return left;
    }

    // Returns true if we can cut the bar into at least 'pieces' pieces, each with sweetness >= minSweet
    public static boolean canDivide(int[] sweetness, int minSweet, int pieces) {
        int sum = 0;    // sweetness of the piece currently being built
        int count = 0;  // number of valid pieces completed so far

        for (int s : sweetness) {
            sum += s;

            if (sum >= minSweet) {
                // This piece is sweet enough: cut here and start a new piece
                count++;
                sum = 0;
            }
        }

        // Leftover chunks (sum < minSweet) get merged into the last piece, so they don't hurt
        return count >= pieces;
    }

    public static void main(String[] args) {
        // Each test: sweetness[], K, expected answer
        int[][] sweetness = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},  // Example 1
                {5, 6, 7, 8, 9, 1, 2, 3, 4},  // Example 2
                {1, 2, 2, 1, 2, 2, 1, 2, 2},  // Example 3
                {7}                           // Extra: K = 0, I keep the whole bar
        };
        int[] ks = {5, 8, 2, 0};
        int[] expected = {6, 1, 5, 7};

        for (int i = 0; i < sweetness.length; i++) {
            int actual = maximizeSweetness(sweetness[i], ks[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}
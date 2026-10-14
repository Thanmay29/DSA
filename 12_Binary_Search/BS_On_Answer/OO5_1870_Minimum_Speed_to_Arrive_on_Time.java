package Binary_Search.BS_On_Answer;

public class OO5_1870_Minimum_Speed_to_Arrive_on_Time {

    public static int minSpeedOnTime(int[] dist, double hour) {
        // The first n-1 trains each cost at least 1 full hour (we wait for the next whole hour),
        // and the last train needs some positive time. So if hour <= n-1, it's impossible.
        if (dist.length - 1 >= hour) return -1;

        // Search range for the speed: smallest possible is 1, the problem guarantees answer <= 10^7
        int left = 1, right = 10_000_000;

        // Binary search for the smallest speed that works (stops when left == right)
        while (left < right) {
            // Middle speed to test; written this way to avoid integer overflow
            int mid = left + (right - left) / 2;

            if (canReach(dist, mid, hour)) {
                // mid works, but a smaller speed might also work, so keep mid and search the left half
                right = mid;
            } else {
                // mid is too slow, so the answer must be faster; discard mid and search the right half
                left = mid + 1;
            }
        }

        // left == right is the smallest speed that lets us arrive on time
        return left;
    }

    // Returns true if travelling at speed k gets us there within h hours
    public static boolean canReach(int[] dist, int k, double h) {
        double time = 0; // total journey time at speed k

        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                // Last train: no waiting afterwards, so add the exact fractional time
                time += ((double) dist[i] / k);
            } else {
                // Other trains: wait until the next whole hour, so round the ride time up
                time += Math.ceil((double) dist[i] / k);
            }
        }

        // Speed k is valid only if the total time fits within the limit
        return time <= h;
    }

    public static void main(String[] args) {
        // Each test: dist[], hour, expected answer
        int[][] dists = {
                {1, 3, 2},      // Example 1
                {1, 3, 2},      // Example 2
                {1, 3, 2},      // Example 3
                {1, 1, 100000}  // Extra: forces the max speed 10^7
        };
        double[] hours = {6, 2.7, 1.9, 2.01};
        int[] expected = {1, 3, -1, 10_000_000};

        for (int i = 0; i < dists.length; i++) {
            int actual = minSpeedOnTime(dists[i], hours[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}
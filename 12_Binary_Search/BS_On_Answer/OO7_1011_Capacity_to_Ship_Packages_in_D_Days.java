package Binary_Search.BS_On_Answer;

public class OO7_1011_Capacity_to_Ship_Packages_in_D_Days {

    public static int shipWithinDays(int[] weights, int days) {
        // Search range for the ship capacity:
        // left  = heaviest single package (capacity below this can never carry it)
        // right = sum of all weights (ship everything in 1 day)
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        // Binary search for the smallest capacity that works (stops when left == right)
        while (left < right) {
            // Capacity to test; written this way to avoid integer overflow
            int mid = left + (right - left) / 2;

            if (canShip(weights, mid, days)) {
                // mid works, but a smaller capacity might also work, so search the left half
                right = mid;
            } else {
                // mid is too small (needs more than 'days' days), so search the right half
                left = mid + 1;
            }
        }

        // left == right is the smallest capacity that ships everything within 'days'
        return left;
    }

    // Returns true if a ship of capacity 'max' can carry all packages within 'days' days
    public static boolean canShip(int[] weights, int max, int days) {
        int sum = 0;  // weight loaded on the current day
        int day = 1;  // days used so far (we start on day 1)

        for (int w : weights) {
            if (sum + w > max) {
                // This package doesn't fit today, so start a new day with it
                sum = w;
                day++;
            } else {
                // Fits in today's load
                sum += w;
            }
        }

        // Valid only if the number of days used is within the limit
        return day <= days;
    }

    public static void main(String[] args) {
        // Each test: weights[], days, expected answer
        int[][] weights = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},  // Example 1
                {3, 2, 2, 4, 1, 4},               // Example 2
                {1, 2, 3, 1, 1},                  // Example 3
                {10}                              // Extra: single package
        };
        int[] days = {5, 3, 4, 1};
        int[] expected = {15, 6, 3, 10};

        for (int i = 0; i < weights.length; i++) {
            int actual = shipWithinDays(weights[i], days[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}
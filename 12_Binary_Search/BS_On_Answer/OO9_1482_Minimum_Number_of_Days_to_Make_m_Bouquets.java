package Binary_Search.BS_On_Answer;

public class OO9_1482_Minimum_Number_of_Days_to_Make_m_Bouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        // Total flowers needed = m bouquets * k flowers each.
        // Use long because m * k can overflow int.
        long need = (long) m * k;

        // Not enough flowers in the garden, so no amount of waiting helps
        if (need > bloomDay.length) return -1;

        // Search range for the answer, which is a DAY NUMBER:
        // left  = earliest day any flower blooms (nothing can be made before this)
        // right = latest day any flower blooms (by then every flower is open)
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        // Binary search for the smallest day that works (stops when left == right)
        while (left < right) {
            // mid = the DAY we are testing: "what if I wait mid days?"
            // It is a guess for the answer, not an index into the array.
            // Written this way to avoid integer overflow.
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                // Waiting mid days is enough, but an earlier day might also work, so search the left half
                right = mid;
            } else {
                // mid days is too early (not enough bouquets), so we must wait longer
                left = mid + 1;
            }
        }

        // left == right is the earliest day on which m bouquets can be made
        return left;
    }

    // Returns true if, after 'day' days, we can make at least m bouquets of k adjacent flowers
    private static boolean canMake(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;  // bouquets completed so far
        int adjacent = 0;  // length of the current run of consecutive bloomed flowers

        for (int bloom : bloomDay) {
            // 'bloom' is the day this flower opens; 'day' is the day we are testing.
            // bloom <= day means the flower is already open by that day.
            if (bloom <= day) {
                adjacent++;  // one more bloomed flower in the current run

                if (adjacent == k) {
                    bouquets++;     // run is long enough: make a bouquet
                    adjacent = 0;   // reset, start counting a fresh group
                }
            } else {
                // Flower is still a bud, which breaks adjacency, so the run starts over
                adjacent = 0;
            }
        }

        // Valid only if we made enough bouquets
        return bouquets >= m;
    }

    public static void main(String[] args) {
        // Each test: bloomDay[], m, k, expected answer
        int[][] bloomDays = {
                {1, 10, 3, 10, 2},                 // Example 1
                {1, 10, 3, 10, 2},                 // Example 2: needs 6 flowers, only 5
                {7, 7, 7, 7, 12, 7, 7},            // Example 3: the bud at index 4 breaks adjacency
                {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}    // Extra: 4 bouquets of 2
        };
        int[] ms = {3, 3, 2, 4};
        int[] ks = {1, 2, 3, 2};
        int[] expected = {3, -1, 12, 9};

        for (int i = 0; i < bloomDays.length; i++) {
            int actual = minDays(bloomDays[i], ms[i], ks[i]);
            String status = (actual == expected[i]) ? "PASS" : "FAIL";
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + " -> " + status);
        }
    }
}
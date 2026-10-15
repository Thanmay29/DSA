package Binary_Search.BS_On_Answer;

public class O04_1283_Find_the_Smallest_Divisor_Given_a_Threshold {

    // Idea: binary search on the ANSWER (the divisor), not on the array.
    // A bigger divisor gives a smaller sum, so the feasibility check is monotonic:
    //   small divisor -> sum too big (not feasible)
    //   large divisor -> sum <= threshold (feasible)
    // We want the first (smallest) feasible divisor.
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;      // smallest possible divisor (must be positive)
        int high = 0;     // largest useful divisor = max element

        // With divisor = max(nums), every element gives 1, so sum = nums.length.
        // The problem guarantees an answer exists, so high is always feasible.
        for (int n : nums) {
            high = Math.max(high, n);
        }

        while (low < high) {
            // Lower mid, safe from overflow. Needed because we do high = mid below.
            int mid = low + (high - low) / 2;

            if (sumOfCeilDivisions(nums, mid) <= threshold) {
                // mid works, but a smaller divisor might also work.
                // Keep mid in the range (it could be the answer).
                high = mid;
            } else {
                // Sum is too large, so mid and everything below it is too small.
                low = mid + 1;
            }
        }

        // low == high: the smallest divisor that keeps the sum <= threshold.
        return low;
    }

    // Returns sum of ceil(num / d) for all elements.
    // (n + d - 1) / d is integer ceiling division (no floating point needed).
    // long is used so the sum can't overflow int when d is small.
    private long sumOfCeilDivisions(int[] nums, int d) {
        long sum = 0;
        for (int n : nums) {
            sum += (n + d - 1) / d;
        }
        return sum;
    }

    // Quick test
    public static void main(String[] args) {
        O04_1283_Find_the_Smallest_Divisor_Given_a_Threshold sol =
                new O04_1283_Find_the_Smallest_Divisor_Given_a_Threshold();

        System.out.println(sol.smallestDivisor(new int[]{1, 2, 5, 9}, 6));      // 5
        System.out.println(sol.smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5)); // 44
    }

    // Time:  O(n * log(max(nums)))
    // Space: O(1)
}
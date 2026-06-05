package Stack.Implimentation_Problems_Important;

import java.util.ArrayDeque;
import java.util.Deque;

public class O01_239_Sliding_Window_Maximum {

    /*
     * Problem:
     * Given an integer array nums and an integer k,
     * return the maximum value in every sliding window of size k.
     *
     * Approach:
     * Use a MONOTONIC DECREASING DEQUE (store indices, not values)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Result array size = total windows
        int[] result = new int[n - k + 1];

        // Deque to store indices of elements
        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            /* ---------------------------------------------
             * STEP 1: Remove indices that are OUTSIDE window
             * Window range = [i - k + 1, i]
             * If index <= i - k → it is outside
             * --------------------------------------------- */
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();  // remove outdated index
            }

            /* ------------------------------------------------
             * STEP 2: Maintain decreasing order in deque
             * Remove all smaller elements from the back
             * because they can never be maximum
             * ------------------------------------------------ */
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            /* ---------------------------------------------
             * STEP 3: Add current index to deque
             * --------------------------------------------- */
            deque.offerLast(i);

            /* ---------------------------------------------
             * STEP 4: Window formed (i >= k - 1)
             * Front of deque contains index of max element
             * --------------------------------------------- */
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = maxSlidingWindow(nums, k);

        // Print result
        for (int val : ans) {
            System.out.print(val + " ");
        }
        // Expected Output: 3 3 5 5 6 7
    }
}

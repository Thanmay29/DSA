package Sliding_Window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class O09_239_Sliding_Window_Maximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indexes out of current window
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            // Remove indexes of all elements smaller than current one
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // Add current index
            q.offerLast(i);

            // Store the max value when the first window is completed
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        int[] nums2 = {1};
        int k2 = 1;

        System.out.println("Output 1: " + Arrays.toString(maxSlidingWindow(nums1, k1))); // [3, 3, 5, 5, 6, 7]
        System.out.println("Output 2: " + Arrays.toString(maxSlidingWindow(nums2, k2))); // [1]
    }
}

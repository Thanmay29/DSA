package Stack.Monotonic_Stack;
import java.util.Stack;


//A ramp is a pair of indices (i, j) such that i < j and nums[i] <= nums[j].
//Return the maximum width j - i among all such ramps.

public class O10_962_Maximum_Width_Ramp {

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int maxWidth = 0;

        // Step 1: Build a decreasing stack of indices
        // These indices are potential starting points for ramps
        for (int i = 0; i < nums.length; i++) {
            // Only push if current value is smaller than value at top of stack
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        // Step 2: Traverse from the end of array and try to pop valid ramps
        for (int j = nums.length - 1; j >= 0; j--) {
            // If current value can form a ramp with top of stack
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        int[] nums1 = {6, 0, 8, 2, 1, 5};
        System.out.println("Max Width Ramp: " + maxWidthRamp(nums1)); // Output: 4

        int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println("Max Width Ramp: " + maxWidthRamp(nums2)); // Output: 7

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Max Width Ramp: " + maxWidthRamp(nums3)); // Output: 4
    }
}

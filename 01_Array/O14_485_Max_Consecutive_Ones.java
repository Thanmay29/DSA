package Array;

public class O14_485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        O14_485_Max_Consecutive_Ones solution = new O14_485_Max_Consecutive_Ones();
        int[] nums = {1, 1, 0, 1, 1, 1}; // Example input
        //output = 3 because of 3 1's
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count); // Ensure last sequence of 1s is counted
    }
}

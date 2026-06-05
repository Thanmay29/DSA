package Array;

public class O15_136_Single_Number {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2}; // Example input
        int result = singleNumber(nums);
        System.out.println("Single number: " + result); // Output: Single number: 4
    }

    public static int singleNumber(int[] nums) {
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i]; // XOR operation to cancel out duplicate numbers
        }

        return num;
    }
}

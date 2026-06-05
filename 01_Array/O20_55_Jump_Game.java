package Array;

public class O20_55_Jump_Game {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums){
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we can't reach index i, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update maxReach
            if (maxReach >= nums.length - 1) {
                return true; // If we can reach the last index, return true
            }
        }
        return false; // Default case (should never be reached)
    }
}

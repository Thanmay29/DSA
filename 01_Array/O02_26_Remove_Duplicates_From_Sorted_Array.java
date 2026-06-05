package Array;

public class O02_26_Remove_Duplicates_From_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);

        System.out.print("Modified nums: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nNumber of unique elements: " + k);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static int brute(int[] nums){
        int[] temp = new int[nums.length];
        int n = nums.length;
        int k = 0;

        for(int i=0; i<n; i++){
            boolean isDup = false;

            for(int j=0; j<n; j++){
                if(nums[i] == temp[j]){
                    isDup = true;
                    break;
                }
            }

            if(!isDup){
                temp[k] = nums[i];
                k++;
            }
        }

        for(int i=0; i<k; i++){
            nums[i] = temp[i];
        }

        return k;
    }
}

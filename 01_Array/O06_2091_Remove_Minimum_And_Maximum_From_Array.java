package Array;

//Return the minimum number of deletions
// it would take to remove both
// the minimum and maximum element from the array.
public class O06_2091_Remove_Minimum_And_Maximum_From_Array {
    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        System.out.println(sol(nums));
    }

    public static int sol(int[] nums){
        int n = nums.length;
        if(nums.length<=1) return 1;

        int minIdx = 0;
        int maxIdx = 0;

        for(int i=1; i<n; i++){
            if(nums[i]<nums[minIdx]){
                minIdx = i;//5
            }
        }

        for(int i=1; i<n; i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;//1
            }
        }

        int left = Math.min(minIdx, maxIdx);//1
        int right = Math.max(minIdx, maxIdx);//5

        //n = 8;

        int op1 = n - left; // remove from end until before index `left`
        //8-1 = 7

        int op2 = right + 1; // remove from index 0 to right
        //5+1 = 6

        int op3 = (left + 1) + (n - right) ; // remove left part up to `left` and right part from `right`
        //(1+1) + (8-5) = 2+3 = 5

        return Math.min(op1, Math.min(op2, op3));//min(7, 6, 5) = 5
        //output = 5
    }
}

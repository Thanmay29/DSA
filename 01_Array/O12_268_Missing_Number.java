package Array;

public class O12_268_Missing_Number {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(findMissingNumber(nums));
    }

    public static int findMissingNumber(int[] nums){
        int sum = 0;
        int currsum = 0;

        for(int i=0; i<=nums.length; i++){
            sum+=i;
        }

        for(int num :nums){
            currsum += num;
        }

        return sum - currsum;
    }
}

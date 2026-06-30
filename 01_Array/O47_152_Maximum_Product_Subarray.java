package Array;

public class O47_152_Maximum_Product_Subarray {
    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};    //Output: 6
            //Explanation: [2,3] has the largest product 6.
        System.out.println(maxProduct(nums));

        int[] nums1 = {-2,0,-1};    //Output: 0
            //Explanation: The result cannot be 2,
            //because [-2,-1] is not a subarray.
            //0 is between them
        System.out.println(maxProduct(nums1));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            prefix *= nums[i];
            suffix *= nums[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));

            if(prefix == 0){
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Store previous max because min uses it
            int prevMax = maxProd;

            maxProd = Math.max(curr, Math.max(curr * maxProd, curr * minProd));
            minProd = Math.min(curr, Math.min(curr * prevMax, curr * minProd));

            result = Math.max(result, maxProd);
        }

        return result;
    }
}

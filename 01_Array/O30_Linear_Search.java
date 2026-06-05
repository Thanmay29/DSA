package Array;

public class O30_Linear_Search {

    static int search(int[] nums, int tar){
        if(nums.length <0) return -1;

        for(int i=0; i<nums.length;i++){
            if(nums[i] == tar){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 3};
        int tar = 3;
        int res = search(nums, tar);
        System.out.println(res);

        // Recursive
        int recRes = recur(nums, tar, 0);
        System.out.println("Recursive result: " + recRes);
    }

    static int recur(int[] nums, int tar, int n){
        if(n>=nums.length) return -1;

        if(nums[n] == tar){
            return n;
        }

        return recur(nums, tar, n+1);
    }
}

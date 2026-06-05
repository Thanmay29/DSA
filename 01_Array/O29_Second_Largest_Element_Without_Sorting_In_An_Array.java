package Array;

public class O29_Second_Largest_Element_Without_Sorting_In_An_Array {

    private static int first = Integer.MIN_VALUE;
    private static int sec = Integer.MIN_VALUE;

    static int find(int[] nums){
        if(nums.length<2) return -1;

        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for(int n : nums){
            if(n>first){
                sec = first;
                first = n;
            }else if(n>sec && n!=first){
                sec = n;
            }
        }
        return (sec == Integer.MIN_VALUE) ? -1 : sec;
    }

    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 6, 5};
        System.out.println(find(nums));

//        Recursion
        recurr(nums, nums.length-1);
        System.out.println(sec);
    }

    static void recurr(int[] nums, int idx){
        if(idx<0) return;

        int curr = nums[idx];

        if(curr>first){
            sec = first;
            first = curr;
        }else if(curr > sec && first != curr){
            sec = curr;
        }

        recurr(nums, idx-1);
    }
}

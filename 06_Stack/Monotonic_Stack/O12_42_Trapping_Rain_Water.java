package Stack.Monotonic_Stack;

public class O12_42_Trapping_Rain_Water {
    public static int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1;
        int water = 0;

        while(left<right){
            if(height[left] <= height[right]){
                if(height[left] < leftMax){
                    water+=leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if(height[right] < rightMax){
                    water+=rightMax - height[right];
                }else{
                    rightMax = height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height1));// o/p = 6;

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(trap(height2));// o/p = 9;

    }
}

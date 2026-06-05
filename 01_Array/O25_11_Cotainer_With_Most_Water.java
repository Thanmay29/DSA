package Array;

public class O25_11_Cotainer_With_Most_Water {
    public static void main(String[] args) {
        //Input: height = [1,8,6,2,5,4,8,3,7]
        //Output: 49
        //Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
        // In this case, the max area of water (blue section) the container can contain is 49.

        //Example 2:
        //Input: height = [1,1]
        //Output: 1

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int area = 0;

        while(left<right){
            int h = Math.min(height[left], height[right]);
            int width = right - left;

            area = Math.max(area, width*h);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return area;
    }
}

package DP;

public class O15_845_Lonest_Mountain_In_Array {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 4, 7, 3, 2, 5};

        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(mountainArray(arr));
    }

    public static int mountainArray(int[] arr){
        int n = arr.length, maxLength = 0;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) { // Peak found
                int left = i, right = i;

                // Expand left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Length of the mountain
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}

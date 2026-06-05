package Binary_Search.BS_On_1D_Array;

import java.util.Arrays;

public class O07_Count_Occurrences_in_a_Sorted_Array {
    public static int countOccurrences(int[] arr, int target) {
        int first = floor(arr, target);
        if (first == -1) return 0;

        int last = ceil(arr, target);

        return last - first + 1;
    }

    public static int floor(int[] arr, int tar){
        int left = 0, right = arr.length-1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == tar){
                ans = mid;
                right = mid - 1;
            }else if(arr[mid] < tar){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int ceil(int[] arr, int tar){
        int left = 0, right = arr.length-1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == tar){
                ans = mid;
                left = mid + 1;
            }else if(arr[mid] < tar){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }

    static void main() {
        System.out.println(countOccurrences(new int[]{0, 0, 1, 1, 1, 2, 3}, 1)); //op : 3
        System.out.println(countOccurrences(new int[]{5, 5, 5, 5, 5, 5}, 5)); //op : 6
    }
}

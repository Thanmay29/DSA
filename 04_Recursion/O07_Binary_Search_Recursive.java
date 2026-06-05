package Recursion;

public class O07_Binary_Search_Recursive {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if(low>high) return -1;

        int mid = low + (high-low)/2;

        if(target == arr[mid]){
            return mid;
        }else if(target < arr[mid]){
            return binarySearch(arr, low, mid-1, target);
        }else{
            return binarySearch(arr, mid+1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
    }
}

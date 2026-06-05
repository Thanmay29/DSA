package Sorting_techniques;

import java.util.Arrays;

public class Insertion_Sort {

//Best Case (sorted): O(n)
//Average & Worst Case: O(n²)
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n; i++){

            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6 ,2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package Sorting_techniques;

import java.util.Arrays;

//Time Complexity: O(n²)
public class Selection_Sort {

    public static void sort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int min = i;

            for(int j=i+1; j<n; j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6 ,2, 1};
        sort(arr);
        for(int n : arr){
            System.out.print(n+" ");
        }

        System.out.println(Arrays.toString(arr));
    }
}

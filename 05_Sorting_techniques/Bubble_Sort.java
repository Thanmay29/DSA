package Sorting_techniques;

import java.util.Arrays;

//Worst & Avg – O(n²),
//Best – O(n) (if already sorted)
public class Bubble_Sort {

    public static void sort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            boolean swapped = false;

            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }

            }
            if(!swapped) break;
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

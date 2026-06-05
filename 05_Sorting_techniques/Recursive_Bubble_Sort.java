package Sorting_techniques;

import java.util.Arrays;

public class Recursive_Bubble_Sort {

//    Time-Complexity
//    Worst Case: O(n^2)
//Best Case: O(n^2) (even if the array is already sorted, this basic version doesn't check that)
//Average Case: O(n^2)

//    Auxiliary Space (recursive stack): O(n)

        // Recursive function to perform bubble sort
        static void bubbleSort(int[] arr, int n) {
            // Base case
            if (n == 1) return;

            // One pass of bubble sort: push the largest to the end
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            // Largest element is fixed, recur for the remaining array
            bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6 ,2, 1};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}

package Sorting_techniques;

import java.util.Arrays;

public class Recursive_Insertion_Sort {

//📊 Time Complexity:
//Worst Case: O(n²) – when the array is in reverse order
//Best Case: O(n) – when the array is already sorted
//Average Case: O(n²).
//
//🧠 Space Complexity:
//Auxiliary Space: O(n) due to recursive call stack

// Recursive function to sort array[0..n-1]
    static void insertionSortRecursive(int[] arr, int n) {
        // Base case: if array size is 1 or less
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSortRecursive(arr, n - 1);

        // Insert last element at its correct position
        int last = arr[n - 1];
        int j = n - 2;

        // Move elements greater than last to one position ahead
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6 ,2, 1};
        int n = arr.length;
        insertionSortRecursive(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}

package Sorting_techniques;

import java.util.Arrays;


//Quick Sort is a divide-and-conquer algorithm. The idea is to:
        //Pick a pivot element (commonly the last, first, or random).
        //Partition the array so that:
        //All elements smaller than the pivot come before it.
        //All elements greater than the pivot come after it.
        //Recursively apply the same logic to the left and right subarrays.
public class Quick_Sort {

//Time Complexity
//Best Case	- O(n log n)
//Average Case	- O(n log n)
//Worst Case	- O(n²) (if array is already sorted and no pivot optimization)

//    🧠 Space Complexity:
//O(log n) – for the recursion stack (in best/avg case)
//O(n) – in worst case due to deep recursion
// QuickSort function
        static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                // Find pivot index after partitioning
                int pivotIndex = partition(arr, low, high);

                // Recursively sort elements before and after partition
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }

    // Partition function
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return the pivot index
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6 ,2, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

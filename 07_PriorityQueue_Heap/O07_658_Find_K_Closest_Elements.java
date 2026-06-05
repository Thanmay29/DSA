package PriorityQueue_Heap;

import java.util.*;

public class O07_658_Find_K_Closest_Elements {

    // Brute Force Approach
    public static List<Integer> bruteForce(int[] arr, int k, int x) {
        // Create a list of elements with their distance to x
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Sort by distance to x, if tie by value
        Collections.sort(list, (a, b) -> {
            int diff = Math.abs(a - x) - Math.abs(b - x);
            if (diff == 0) {
                return a - b;
            }
            return diff;
        });

        // Get first k elements
        List<Integer> result = list.subList(0, k);

        // Sort the result in ascending order
        Collections.sort(result);
        return result;
    }



    // Optimal Approach: Binary Search + Two pointers O(log n + k)
    public static List<Integer> optimal(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;// Ensure arr[mid + k] is in bounds

        // Binary search for the smallest left such that
        // subarray arr[left ... left+k-1] is closest to x

        // Compare distances of edge elements to x
        //You're comparing distance from x to the first element of window [mid ... mid+k-1]
        //vs
        //distance from x to the last element of window [mid+1 ... mid+k].
        //
        //If the last element is closer, then shift window right.
        //
        //If the first is closer or equally close, then we stay or move left (prefer smaller elements in tie).
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                // Move right because right subarray is closer
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Collect the k closest elements starting at left
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4, x1 = 3;
        System.out.println("Brute force: " + bruteForce(arr1, k1, x1));  // Output: [1, 2, 3, 4]
        System.out.println("Optimal: " + optimal(arr1, k1, x1));        // Output: [1, 2, 3, 4]

        int[] arr2 = {1, 1, 2, 3, 4, 5};
        int k2 = 4, x2 = -1;
        System.out.println("Brute force: " + bruteForce(arr2, k2, x2));  // Output: [1, 1, 2, 3]
        System.out.println("Optimal: " + optimal(arr2, k2, x2));        // Output: [1, 1, 2, 3]
    }
}

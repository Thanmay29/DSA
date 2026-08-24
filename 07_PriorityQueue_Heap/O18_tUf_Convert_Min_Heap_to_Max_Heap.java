package PriorityQueue_Heap;

public class O18_tUf_Convert_Min_Heap_to_Max_Heap {

    // Standard build-heap: start from the last non-leaf node and sift down
    // to the root, using max-heap comparison. Works in O(n) time.
    static int[] convertMinToMaxHeap(int[] nums) {
        int n = nums.length;

        // last non-leaf node is at index (n/2 - 1)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }
        return nums;
    }

    private static void maxHeapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) largest = left;
        if (right < n && nums[right] > nums[largest]) largest = right;

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            maxHeapify(nums, n, largest); // recurse down the affected subtree
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 21, 23};
        System.out.println(java.util.Arrays.toString(convertMinToMaxHeap(nums1)));
        // possible output: [30, 21, 23, 10, 20]

        int[] nums2 = {-5, -4, -3, -2, -1};
        System.out.println(java.util.Arrays.toString(convertMinToMaxHeap(nums2)));
        // possible output: [-1, -2, -3, -4, -5]
    }
}
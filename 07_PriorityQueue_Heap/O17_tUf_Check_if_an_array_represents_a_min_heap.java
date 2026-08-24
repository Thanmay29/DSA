package PriorityQueue_Heap;

//n = 5
//loop condition: i <= (n/2) - 1  →  i <= (5/2) - 1  →  i <= 1
//So loop runs for i = 0 and i = 1 (indices 2, 3, 4 are leaves — skipped)

//left  = 2*0 + 1 = 1  → nums[1] = 20
//right = 2*0 + 2 = 2  → nums[2] = 30

//Check: left < n (1 < 5) ✓ and nums[0] > nums[left]?  → 10 > 20? → false, no violation
//Check: right < n (2 < 5) ✓ and nums[0] > nums[right]? → 10 > 30? → false, no violation
public class O17_tUf_Check_if_an_array_represents_a_min_heap {

    // Checks whether the given array represents a valid binary min-heap.
    // Approach: only non-leaf nodes (index 0 to n/2 - 1) need to be checked
    // against their children. Leaf nodes trivially satisfy the heap property.
    // Time: O(n), Space: O(1)
    static boolean isMinHeap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= (n / 2) - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && nums[i] > nums[left]) return false;
            if (right < n && nums[i] > nums[right]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: valid min-heap -> true
        int[] nums1 = {10, 20, 30, 21, 23};
        System.out.println(isMinHeap(nums1)); // expected: true

        // Test case 2: invalid, 20 has child 15 -> false
        int[] nums2 = {10, 20, 30, 25, 15};
        System.out.println(isMinHeap(nums2)); // expected: false

        // Test case 3: given in problem -> true
        int[] nums3 = {1, 2, 1, 3};
        System.out.println(isMinHeap(nums3)); // expected: true

        // Test case 4: single element -> trivially true
        int[] nums4 = {5};
        System.out.println(isMinHeap(nums4)); // expected: true

        // Test case 5: violation deeper in tree -> false
        int[] nums5 = {1, 2, 3, 4, 5, 0, 7};
        System.out.println(isMinHeap(nums5)); // expected: false (0 < 3, its parent)

        // Test case 6: two elements, valid -> true
        int[] nums6 = {2, 5};
        System.out.println(isMinHeap(nums6)); // expected: true

        // Test case 7: two elements, invalid -> false
        int[] nums7 = {5, 2};
        System.out.println(isMinHeap(nums7)); // expected: false
    }
}
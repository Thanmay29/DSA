package Linked_List;


////Given the head of a linked list, rotate the list to the right by k places.

public class O18_61_Rotate_List {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: empty list or single element or no rotation
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count the length of the list
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Step 2: Make the list circular
        curr.next = head;

        // Step 3: Normalize k (in case k > len)
        // If k >= len, your logic will break or return incorrect output.
        //
        //For example, rotating a list of 5 elements by k = 10 is the same as rotating by k = 0.
        k = k % len;
        if (k == 0) {
            curr.next = null;  // break the circle
            return head;
        }

        // Step 4: Find the new tail (len - k steps from head)
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Optional utility method to build a list from array (for testing)
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Optional utility method to print list (for testing)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        int k = 2;

        O18_61_Rotate_List solution = new O18_61_Rotate_List();
        ListNode rotated = solution.rotateRight(head, k);

        printList(rotated); // Expected output: 4 -> 5 -> 1 -> 2 -> 3
    }
}

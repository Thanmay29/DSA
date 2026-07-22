package Linked_List;

public class O21_Reverse_DLL_InPlace {

    // =========================================================
    // DOUBLY LINKED LIST NODE
    // =========================================================
    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    // =========================================================
    // APPROACH 1: REVERSE DLL BY CHANGING LINKS
    // =========================================================
    // For every node:
    //
    // Before:
    // prev <- curr -> next
    //
    // After swapping:
    // next <- curr -> prev
    //
    // We swap:
    // curr.prev <-> curr.next
    //
    // Then move to:
    // curr.prev
    //
    // Why curr.prev?
    // Because after swapping, curr.prev contains the
    // ORIGINAL curr.next node.
    //
    // Time: O(N)
    // Space: O(1)
    //
    // This is the BEST approach.
    public static ListNode reverseDLL(ListNode head) {

        // Empty list or one node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {

            // Save original prev
            temp = curr.prev;

            // Swap prev and next
            curr.prev = curr.next;
            curr.next = temp;

            // Move to original next node
            // After swapping, original next is now curr.prev
            curr = curr.prev;
        }

        // temp is at the old head's prev
        // The new head is temp.prev
        return temp.prev;
    }


    // =========================================================
    // APPROACH 2: USING AN EXTRA ARRAY
    // =========================================================
    // Store all node values in an array.
    // Then write them back in reverse order.
    //
    // Time: O(N)
    // Space: O(N)
    //
    // NOTE:
    // This changes node values instead of changing links.
    // So this is NOT a true in-place DLL reversal.
    //
    // It is included only to understand an alternative approach.
    public static ListNode reverseUsingArray(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Count nodes
        int size = 0;
        ListNode curr = head;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // Store values
        int[] values = new int[size];

        curr = head;
        int index = 0;

        while (curr != null) {
            values[index++] = curr.val;
            curr = curr.next;
        }

        // Write values in reverse order
        curr = head;

        for (int i = size - 1; i >= 0; i--) {
            curr.val = values[i];
            curr = curr.next;
        }

        return head;
    }


    // =========================================================
    // CREATE DOUBLY LINKED LIST
    // =========================================================
    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {

            ListNode newNode = new ListNode(arr[i]);

            // Connect both directions
            curr.next = newNode;
            newNode.prev = curr;

            curr = newNode;
        }

        return head;
    }


    // =========================================================
    // PRINT DLL FORWARD
    // =========================================================
    public static void printForward(ListNode head) {

        ListNode curr = head;

        while (curr != null) {

            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" <-> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }


    // =========================================================
    // PRINT DLL BACKWARD
    // =========================================================
    public static void printBackward(ListNode head) {

        if (head == null) {
            return;
        }

        // Go to tail
        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        // Traverse backward using prev
        while (curr != null) {

            System.out.print(curr.val);

            if (curr.prev != null) {
                System.out.print(" <-> ");
            }

            curr = curr.prev;
        }

        System.out.println();
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};


        // =====================================================
        // APPROACH 1: IN-PLACE POINTER REVERSAL
        // =====================================================

        ListNode head1 = createList(arr);

        System.out.println("Approach 1: In-Place Pointer Reversal");

        System.out.print("Before:  ");
        printForward(head1);

        head1 = reverseDLL(head1);

        System.out.print("After:   ");
        printForward(head1);

        System.out.print("Backward:");
        printBackward(head1);


        System.out.println();


        // =====================================================
        // APPROACH 2: USING ARRAY
        // =====================================================

        ListNode head2 = createList(arr);

        System.out.println("Approach 2: Using Array");

        System.out.print("Before:  ");
        printForward(head2);

        head2 = reverseUsingArray(head2);

        System.out.print("After:   ");
        printForward(head2);
    }
}
package Linked_List;

public class O27_Delete_All_Occurence_Of_A_Key {

    /*
    ============================================================
    QUESTION
    ============================================================

    Given a doubly linked list and a target value,
    delete all occurrences of the target value.

    Example:

    Input:
    1 <-> 2 <-> 3 <-> 2 <-> 4

    Target = 2

    Output:
    1 <-> 3 <-> 4


    APPROACH:
    1. Create a dummy node before the head.
    2. Use curr to track the last valid node.
    3. Use next to traverse the original linked list.
    4. If next.val == target:
       Skip the node.
    5. Otherwise:
       Connect curr and next.
    6. Since this is a DLL, update both:
       curr.next
       next.prev
    7. Remove the dummy connection from the final head.


    Time Complexity: O(N)
    Space Complexity: O(1)
    */


    // =========================================================
    // NODE
    // =========================================================
    static class ListNode {

        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }


    // =========================================================
    // DELETE ALL OCCURRENCES
    // =========================================================
    public static ListNode deleteAllOccurrences(
            ListNode head, int target) {

        // Dummy node before the actual head
        ListNode dummy = new ListNode(0);

        // curr represents the last valid node
        ListNode curr = dummy;

        // next is used to traverse the list
        ListNode next = head;

        while (next != null) {

            // -------------------------------------------------
            // CASE 1: Current node is NOT the target
            // -------------------------------------------------
            if (next.val != target) {

                // Connect curr -> next
                curr.next = next;

                // Connect next -> curr
                // Important for doubly linked list
                next.prev = curr;

                // Move curr forward
                curr = next;

                // Move next forward
                next = next.next;
            }

            // -------------------------------------------------
            // CASE 2: Current node IS the target
            // -------------------------------------------------
            else {

                /*
                Target node is skipped.

                Example:

                1 <-> 2 <-> 3

                Target = 2

                We skip 2 and continue checking from 3.
                */

                next = next.next;
            }
        }

        // Remove any remaining nodes after the last valid node
        curr.next = null;

        // Get actual head
        ListNode newHead = dummy.next;

        // Actual head should not point to dummy
        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }


    // =========================================================
    // CREATE DOUBLY LINKED LIST
    // =========================================================
    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        // Create head
        ListNode head = new ListNode(arr[0]);

        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {

            // Create new node
            ListNode newNode = new ListNode(arr[i]);

            // Connect curr -> newNode
            curr.next = newNode;

            // Connect newNode -> curr
            newNode.prev = curr;

            // Move curr forward
            curr = newNode;
        }

        return head;
    }


    // =========================================================
    // PRINT FORWARD
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
    // PRINT BACKWARD
    // =========================================================
    public static void printBackward(ListNode head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        // Go to the last node
        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        // Traverse backwards
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

        // =====================================================
        // TEST CASE 1
        // =====================================================
        // Input:
        // 1 <-> 2 <-> 3 <-> 2 <-> 4
        //
        // Target = 2
        //
        // Output:
        // 1 <-> 3 <-> 4

        int[] arr1 = {1, 2, 3, 2, 4};

        ListNode head1 = createList(arr1);

        System.out.println("Test Case 1");

        System.out.print("Before: ");
        printForward(head1);

        head1 = deleteAllOccurrences(head1, 2);

        System.out.print("After:  ");
        printForward(head1);

        System.out.print("Reverse: ");
        printBackward(head1);


        // =====================================================
        // TEST CASE 2
        // =====================================================
        // Target is at the head
        //
        // Input:
        // 2 <-> 1 <-> 3
        //
        // Target = 2
        //
        // Output:
        // 1 <-> 3

        int[] arr2 = {2, 1, 3};

        ListNode head2 = createList(arr2);

        System.out.println("\nTest Case 2");

        System.out.print("Before: ");
        printForward(head2);

        head2 = deleteAllOccurrences(head2, 2);

        System.out.print("After:  ");
        printForward(head2);


        // =====================================================
        // TEST CASE 3
        // =====================================================
        // Target is at the tail
        //
        // Input:
        // 1 <-> 2 <-> 3
        //
        // Target = 3
        //
        // Output:
        // 1 <-> 2

        int[] arr3 = {1, 2, 3};

        ListNode head3 = createList(arr3);

        System.out.println("\nTest Case 3");

        System.out.print("Before: ");
        printForward(head3);

        head3 = deleteAllOccurrences(head3, 3);

        System.out.print("After:  ");
        printForward(head3);


        // =====================================================
        // TEST CASE 4
        // =====================================================
        // Every node is the target
        //
        // Input:
        // 2 <-> 2 <-> 2
        //
        // Target = 2
        //
        // Output:
        // Empty List

        int[] arr4 = {2, 2, 2};

        ListNode head4 = createList(arr4);

        System.out.println("\nTest Case 4");

        System.out.print("Before: ");
        printForward(head4);

        head4 = deleteAllOccurrences(head4, 2);

        System.out.print("After:  ");
        printForward(head4);


        // =====================================================
        // TEST CASE 5
        // =====================================================
        // Target does not exist
        //
        // Input:
        // 1 <-> 3 <-> 5
        //
        // Target = 2
        //
        // Output:
        // 1 <-> 3 <-> 5

        int[] arr5 = {1, 3, 5};

        ListNode head5 = createList(arr5);

        System.out.println("\nTest Case 5");

        System.out.print("Before: ");
        printForward(head5);

        head5 = deleteAllOccurrences(head5, 2);

        System.out.print("After:  ");
        printForward(head5);
    }
}
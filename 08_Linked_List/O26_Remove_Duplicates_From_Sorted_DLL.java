package Linked_List;

public class O26_Remove_Duplicates_From_Sorted_DLL {

    // =========================================================
    // QUESTION
    // =========================================================
    /*
    Given a SORTED doubly linked list, remove all duplicate nodes
    and return the head of the modified list.

    Example:

    Input:
    1 <-> 1 <-> 2 <-> 2 <-> 3

    Output:
    1 <-> 2 <-> 3


    Because the linked list is SORTED, duplicate values are
    always next to each other.

    We use two pointers:

    curr -> last unique node
    next -> node currently being checked


    If:
    curr.val == next.val

    Then next is a duplicate.
    Skip it by moving next forward.


    If:
    curr.val != next.val

    Then next is a unique node.
    Connect curr and next.


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
    // REMOVE DUPLICATES
    // =========================================================
    public static ListNode removeDuplicates(ListNode head) {

        // Empty list or only one node
        // cannot contain duplicates
        if (head == null || head.next == null) {
            return head;
        }

        // curr points to the last unique node
        ListNode curr = head;

        // next points to the node currently being checked
        ListNode next = head.next;

        while (next != null) {

            // -------------------------------------------------
            // CASE 1: UNIQUE VALUE
            // -------------------------------------------------
            if (curr.val != next.val) {

                // Connect curr -> next
                curr.next = next;

                // Connect next -> curr
                next.prev = curr;

                // Move curr to the new unique node
                curr = next;

                // Move next forward
                next = next.next;
            }

            // -------------------------------------------------
            // CASE 2: DUPLICATE VALUE
            // -------------------------------------------------
            else {

                // Skip the duplicate node
                next = next.next;
            }
        }

        // curr is the last unique node.
        // Remove any remaining duplicate nodes
        // from the final linked list.
        curr.next = null;

        return head;
    }


    // =========================================================
    // CREATE DOUBLY LINKED LIST
    // =========================================================
    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        // Create first node
        ListNode head = new ListNode(arr[0]);

        ListNode curr = head;

        // Create remaining nodes
        for (int i = 1; i < arr.length; i++) {

            ListNode newNode = new ListNode(arr[i]);

            // Connect forward
            curr.next = newNode;

            // Connect backward
            newNode.prev = curr;

            // Move curr forward
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

        // Move to the last node
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
        // 1 <-> 1 <-> 2 <-> 2 <-> 3
        //
        // Output:
        // 1 <-> 2 <-> 3

        int[] arr1 = {1, 1, 2, 2, 3};

        ListNode head1 = createList(arr1);

        System.out.println("Test Case 1");

        System.out.print("Before: ");
        printForward(head1);

        head1 = removeDuplicates(head1);

        System.out.print("After:  ");
        printForward(head1);

        System.out.print("Reverse: ");
        printBackward(head1);


        // =====================================================
        // TEST CASE 2
        // =====================================================
        // Input:
        // 1 <-> 1 <-> 1 <-> 2
        //
        // Output:
        // 1 <-> 2

        int[] arr2 = {1, 1, 1, 2};

        ListNode head2 = createList(arr2);

        System.out.println("\nTest Case 2");

        System.out.print("Before: ");
        printForward(head2);

        head2 = removeDuplicates(head2);

        System.out.print("After:  ");
        printForward(head2);


        // =====================================================
        // TEST CASE 3
        // =====================================================
        // Input:
        // 1 <-> 2 <-> 3
        //
        // No duplicates

        int[] arr3 = {1, 2, 3};

        ListNode head3 = createList(arr3);

        System.out.println("\nTest Case 3");

        System.out.print("Before: ");
        printForward(head3);

        head3 = removeDuplicates(head3);

        System.out.print("After:  ");
        printForward(head3);


        // =====================================================
        // TEST CASE 4
        // =====================================================
        // Input:
        // 1 <-> 1 <-> 1
        //
        // Output:
        // 1

        int[] arr4 = {1, 1, 1};

        ListNode head4 = createList(arr4);

        System.out.println("\nTest Case 4");

        System.out.print("Before: ");
        printForward(head4);

        head4 = removeDuplicates(head4);

        System.out.print("After:  ");
        printForward(head4);


        // =====================================================
        // TEST CASE 5
        // =====================================================
        // Input:
        // 1 <-> 2 <-> 2 <-> 3 <-> 3 <-> 3 <-> 4
        //
        // Output:
        // 1 <-> 2 <-> 3 <-> 4

        int[] arr5 = {1, 2, 2, 3, 3, 3, 4};

        ListNode head5 = createList(arr5);

        System.out.println("\nTest Case 5");

        System.out.print("Before: ");
        printForward(head5);

        head5 = removeDuplicates(head5);

        System.out.print("After:  ");
        printForward(head5);
    }
}
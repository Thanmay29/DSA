package Linked_List;

public class O29_148_Sort_LL {

    /*
    ============================================================
    QUESTION
    ============================================================

    Given the head of a singly linked list,
    sort the linked list in ascending order.

    Example:

    Input:
    4 -> 2 -> 1 -> 3

    Output:
    1 -> 2 -> 3 -> 4


    ============================================================
    APPROACH: MERGE SORT
    ============================================================

    We divide the linked list into two halves,
    recursively sort both halves,
    and then merge the sorted halves.

    Steps:

    1. Find the middle using slow and fast pointers.
    2. Split the linked list into two halves.
    3. Recursively sort the first half.
    4. Recursively sort the second half.
    5. Merge the two sorted lists.


    Example:

    4 -> 2 -> 1 -> 3

    Split:

    4 -> 2       1 -> 3

    Sort:

    2 -> 4       1 -> 3

    Merge:

    1 -> 2 -> 3 -> 4


    Time Complexity: O(N log N)

    Space Complexity: O(log N)
    Because of recursive function calls.

    Note:
    We do not create new ListNodes while sorting.
    We only change existing links.
    */


    // =========================================================
    // NODE
    // =========================================================

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    // =========================================================
    // SORT LINKED LIST
    // =========================================================

    public static ListNode sortList(ListNode head) {

        // If list is empty or has only one node,
        // it is already sorted.
        if (head == null || head.next == null) {
            return head;
        }


        // =====================================================
        // STEP 1: FIND THE MIDDLE
        // =====================================================

        ListNode slow = head;
        ListNode fast = head;

        /*
        Slow moves one step.
        Fast moves two steps.

        Example:

        4 -> 2 -> 1 -> 3

        After traversal:

        slow
          ↓
        4 -> 2 -> 1 -> 3

        slow points to 2.

        So we split:

        4 -> 2

        1 -> 3
        */

        while (fast.next != null &&
                fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }


        // =====================================================
        // STEP 2: SPLIT THE LIST
        // =====================================================

        // Second half starts after slow
        ListNode secondHalf = slow.next;

        // Break the connection
        // between first and second half
        slow.next = null;


        // =====================================================
        // STEP 3: RECURSIVELY SORT BOTH HALVES
        // =====================================================

        ListNode firstSorted = sortList(head);

        ListNode secondSorted = sortList(secondHalf);


        // =====================================================
        // STEP 4: MERGE SORTED HALVES
        // =====================================================

        return merge(firstSorted, secondSorted);
    }


    // =========================================================
    // MERGE TWO SORTED LINKED LISTS
    // =========================================================

    public static ListNode merge(
            ListNode first,
            ListNode second) {

        // Dummy node makes merging easier
        ListNode dummy = new ListNode(0);

        // curr tracks the last node of merged list
        ListNode curr = dummy;


        // Compare both lists
        while (first != null &&
                second != null) {

            // If first node is smaller
            if (first.val <= second.val) {

                // Add first node
                curr.next = first;

                // Move first forward
                first = first.next;

            } else {

                // Add second node
                curr.next = second;

                // Move second forward
                second = second.next;
            }

            // Move merged list pointer
            curr = curr.next;
        }


        // If first list still has nodes,
        // attach remaining nodes.
        if (first != null) {
            curr.next = first;
        }


        // If second list still has nodes,
        // attach remaining nodes.
        if (second != null) {
            curr.next = second;
        }


        // Return actual head.
        // Dummy node is not part of result.
        return dummy.next;
    }


    // =========================================================
    // CREATE LINKED LIST
    // =========================================================

    public static ListNode createList(int[] arr) {

        // Empty array
        if (arr.length == 0) {
            return null;
        }

        // Create head
        ListNode head = new ListNode(arr[0]);

        ListNode curr = head;

        // Create remaining nodes
        for (int i = 1; i < arr.length; i++) {

            ListNode newNode =
                    new ListNode(arr[i]);

            // Connect current node
            // to new node
            curr.next = newNode;

            // Move forward
            curr = newNode;
        }

        return head;
    }


    // =========================================================
    // PRINT LINKED LIST
    // =========================================================

    public static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {

            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
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
        // 4 -> 2 -> 1 -> 3

        int[] arr1 = {4, 2, 1, 3};

        ListNode head1 =
                createList(arr1);

        System.out.println("Test Case 1");

        System.out.print("Before: ");
        printList(head1);

        // Sort linked list
        head1 = sortList(head1);

        System.out.print("After:  ");
        printList(head1);


        // =====================================================
        // TEST CASE 2
        // =====================================================

        // Input:
        // -1 -> 5 -> 3 -> 4 -> 0

        int[] arr2 = {-1, 5, 3, 4, 0};

        ListNode head2 =
                createList(arr2);

        System.out.println("\nTest Case 2");

        System.out.print("Before: ");
        printList(head2);

        // Sort linked list
        head2 = sortList(head2);

        System.out.print("After:  ");
        printList(head2);


        // =====================================================
        // TEST CASE 3
        // =====================================================

        // Empty linked list

        int[] arr3 = {};

        ListNode head3 =
                createList(arr3);

        System.out.println("\nTest Case 3");

        System.out.print("Before: ");
        printList(head3);

        // Sort linked list
        head3 = sortList(head3);

        System.out.print("After:  ");

        if (head3 == null) {
            System.out.println("Empty List");
        } else {
            printList(head3);
        }
    }
}
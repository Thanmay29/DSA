package Linked_List;

import java.util.ArrayList;

public class O23_Palindrome_LL {

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
    // REVERSE SECOND HALF ⭐ BEST
    // =========================================================
    /*
    Idea:

    1. Find the middle using slow and fast pointers.
    2. Reverse the second half.
    3. Compare first half and reversed second half.

    Example:

    Original:

    1 -> 2 -> 2 -> 1

    First half:

    1 -> 2

    Second half:

    2 -> 1

    Reverse second half:

    1 -> 2

    Compare:

    1 == 1
    2 == 2

    Palindrome.

    Time:  O(N)
    Space: O(1)
    */
    public static boolean isPalindromeUsingReverse(ListNode head) {

        // Empty list or one node is always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // -----------------------------------------------------
        // STEP 1: FIND THE MIDDLE
        // -----------------------------------------------------
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;
        }

        /*
        Example:

        1 -> 2 -> 2 -> 1
                  ^
                 slow

        slow is now at the beginning of the second half.
        */


        // -----------------------------------------------------
        // STEP 2: REVERSE SECOND HALF
        // -----------------------------------------------------
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {

            // Save next node before breaking the link
            ListNode next = curr.next;

            // Reverse current node's pointer
            curr.next = prev;

            // Move prev forward
            prev = curr;

            // Move curr forward
            curr = next;
        }

        /*
        Before:

        1 -> 2 -> 2 -> 1 -> null

        After reversing second half:

        First half:

        1 -> 2

        Second half:

        1 -> 2

        head           prev
         |              |
         v              v
        1 -> 2          1 -> 2
        */


        // -----------------------------------------------------
        // STEP 3: COMPARE BOTH HALVES
        // -----------------------------------------------------
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            // If values are different,
            // the linked list is not a palindrome
            if (first.val != second.val) {
                return false;
            }

            // Move both pointers
            first = first.next;
            second = second.next;
        }

        // All values matched
        return true;
    }


    // =========================================================
    // CREATE LINKED LIST
    // =========================================================
    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {

            curr.next = new ListNode(arr[i]);

            curr = curr.next;
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
        // 1 -> 2 -> 2 -> 1
        // Palindrome = true

        int[] arr1 = {1, 2, 2, 1};

        ListNode head1 = createList(arr1);

        System.out.println("Test Case 1");
        System.out.print("List: ");
        printList(head1);

        System.out.println(
                "Reverse Approach: "
                        + isPalindromeUsingReverse(head1)
        );


        // =====================================================
        // TEST CASE 2
        // =====================================================
        // 1 -> 2 -> 3
        // Palindrome = false

        int[] arr2 = {1, 2, 3};

        ListNode head2 = createList(arr2);

        System.out.println("\nTest Case 2");
        System.out.print("List: ");
        printList(head2);

        System.out.println(
                "Reverse Approach: "
                        + isPalindromeUsingReverse(head2)
        );


        // =====================================================
        // TEST CASE 3
        // =====================================================
        // 1 -> 2 -> 3 -> 2 -> 1
        // Palindrome = true

        int[] arr3 = {1, 2, 3, 2, 1};

        ListNode head3 = createList(arr3);

        System.out.println("\nTest Case 3");
        System.out.print("List: ");
        printList(head3);

        System.out.println(
                "Reverse Approach: "
                        + isPalindromeUsingReverse(head3)
        );


        // =====================================================
        // TEST CASE 4
        // =====================================================
        // 1 -> 2 -> 3 -> 4
        // Palindrome = false

        int[] arr4 = {1, 2, 3, 4};

        ListNode head4 = createList(arr4);

        System.out.println("\nTest Case 4");
        System.out.print("List: ");
        printList(head4);

        System.out.println(
                "Reverse Approach: "
                        + isPalindromeUsingReverse(head4)
        );
    }
}
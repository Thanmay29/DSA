package Linked_List;

import java.util.HashSet;

public class O22_Length_of_Loop_LL {

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
    // APPROACH 1; FLOYD'S CYCLE DETECTION ⭐ BEST
    // =========================================================
    /*
    Idea:

    1. slow moves 1 step.
    2. fast moves 2 steps.
    3. If there is no loop:
       fast will eventually become null.

    4. If there is a loop:
       slow and fast will eventually meet.

    5. Once they meet:
       Start from slow.next.
       Keep moving until we reach slow again.
       Count the number of nodes.

    Time: O(N)
    Space: O(1)
    */
    public static int findLengthUsingFloyd(ListNode head) {

        // Slow pointer moves one step
        ListNode slow = head;

        // Fast pointer moves two steps
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {

            // Move slow by 1
            slow = slow.next;

            // Move fast by 2
            fast = fast.next.next;

            // Both pointers meet
            // This confirms that a cycle exists
            if (slow == fast) {

                // Start counting from next node
                // because the meeting node itself is counted as 1
                int length = 1;

                ListNode curr = slow.next;

                // Continue until we reach meeting node again
                while (curr != slow) {

                    length++;

                    curr = curr.next;
                }

                return length;
            }
        }

        // No cycle exists
        return 0;
    }


    // =========================================================
    // CREATE NORMAL LINKED LIST
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
    // CREATE LINKED LIST WITH LOOP
    // =========================================================
    /*
    loopPosition:
    0 means last node points to node 0
    1 means last node points to node 1
    2 means last node points to node 2
    etc.

    Example:

    arr = [1, 2, 3, 4, 5]
    loopPosition = 1

    Result:

    1 -> 2 -> 3 -> 4 -> 5
         ^              |
         |______________|

    Loop length = 4
    */
    public static ListNode createListWithLoop(
            int[] arr, int loopPosition) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);

        ListNode curr = head;

        // Node where loop should start
        ListNode loopStart = null;

        // If loop starts at first node
        if (loopPosition == 0) {
            loopStart = head;
        }

        for (int i = 1; i < arr.length; i++) {

            curr.next = new ListNode(arr[i]);

            curr = curr.next;

            // Save the node where loop starts
            if (i == loopPosition) {
                loopStart = curr;
            }
        }

        // Connect last node to loop starting node
        if (loopStart != null) {
            curr.next = loopStart;
        }

        return head;
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        // =====================================================
        // TEST CASE 1
        // =====================================================
        // 1 -> 2 -> 3 -> 4 -> 5
        //      ^              |
        //      |______________|
        //
        // Loop: 2 -> 3 -> 4 -> 5
        // Length = 4

        int[] arr1 = {1, 2, 3, 4, 5};

        ListNode head1 = createListWithLoop(arr1, 1);

        System.out.println("Test Case 1");
        System.out.println(
                "Floyd Approach: "
                        + findLengthUsingFloyd(head1)
        );


        // =====================================================
        // TEST CASE 2
        // =====================================================
        // 1 -> 2 -> 3 -> 4
        //           ^         |
        //           |_________|
        //
        // Loop: 3 -> 4
        // Length = 2

        int[] arr2 = {1, 2, 3, 4};

        ListNode head2 = createListWithLoop(arr2, 2);

        System.out.println("\nTest Case 2");

        System.out.println(
                "Floyd Approach: "
                        + findLengthUsingFloyd(head2)
        );


        // =====================================================
        // TEST CASE 3
        // =====================================================
        // 1 -> 2 -> 3 -> 4 -> null
        //
        // No loop
        // Answer = 0

        int[] arr3 = {1, 2, 3, 4};

        ListNode head3 = createList(arr3);

        System.out.println("\nTest Case 3");

        System.out.println(
                "Floyd Approach: "
                        + findLengthUsingFloyd(head3)
        );


        // =====================================================
        // TEST CASE 4
        // =====================================================
        // 1 -> 2 -> 3 -> 4
        // ^              |
        // |______________|
        //
        // Entire list is a loop
        // Length = 4

        int[] arr4 = {1, 2, 3, 4};

        ListNode head4 = createListWithLoop(arr4, 0);

        System.out.println("\nTest Case 4");

        System.out.println(
                "Floyd Approach: "
                        + findLengthUsingFloyd(head4)
        );
    }
}
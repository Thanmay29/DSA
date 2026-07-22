package Linked_List;

public class O24_Sort012 {

    // Node definition
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 1};

        // -------------------------------
        // Approach 1: Counting
        // -------------------------------
        ListNode head1 = createList(arr);

        System.out.println("Approach 1: Counting");

        System.out.print("Before: ");
        printList(head1);

        head1 = sortByCounting(head1);

        System.out.print("After:  ");
        printList(head1);


        System.out.println();


        // -------------------------------
        // Approach 2: Rearrange Links
        // -------------------------------
        ListNode head2 = createList(arr);

        System.out.println("Approach 2: Rearrange Links");

        System.out.print("Before: ");
        printList(head2);

        head2 = sortByLinks(head2);

        System.out.print("After:  ");
        printList(head2);
    }

    // =========================================================
    // APPROACH 1: COUNT 0s, 1s and 2s
    // =========================================================
    // Idea:
    // 1. Traverse the list and count 0, 1 and 2.
    // 2. Traverse again and overwrite node values.
    //
    // Time: O(N)
    // Space: O(1)
    //
    // NOTE:
    // This changes the DATA/VALUES inside nodes.
    // It does NOT change the links between nodes.
    // So this is NOT the ideal approach for this question.
    public static ListNode sortByCounting(ListNode head) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        ListNode curr = head;

        // Count 0s, 1s and 2s
        while (curr != null) {

            if (curr.val == 0) {
                count0++;
            } else if (curr.val == 1) {
                count1++;
            } else {
                count2++;
            }

            curr = curr.next;
        }

        // Put 0s into the list
        curr = head;

        while (count0 > 0) {
            curr.val = 0;
            curr = curr.next;
            count0--;
        }

        // Put 1s into the list
        while (count1 > 0) {
            curr.val = 1;
            curr = curr.next;
            count1--;
        }

        // Put 2s into the list
        while (count2 > 0) {
            curr.val = 2;
            curr = curr.next;
            count2--;
        }

        return head;
    }


    // =========================================================
    // APPROACH 2: THREE SEPARATE LINKED LISTS
    // =========================================================
    // Idea:
    // Create three dummy nodes:
    //
    // zeroHead -> list containing 0s
    // oneHead  -> list containing 1s
    // twoHead  -> list containing 2s
    //
    // Traverse the original list and move each node
    // into its corresponding list by changing next pointers.
    //
    // Finally:
    //
    // 0-list -> 1-list -> 2-list
    //
    // Time: O(N)
    // Space: O(1) auxiliary space
    //
    // This is the BEST approach for this question because
    // we rearrange the links instead of changing node values.
    public static ListNode sortByLinks(ListNode head) {

        // Handle empty list
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy nodes
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Tails of the three lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode curr = head;

        while (curr != null) {

            // Save the next node from original list
            ListNode next = curr.next;

            // Detach curr from original list
            curr.next = null;

            // Put curr into correct list
            if (curr.val == 0) {

                zero.next = curr;
                zero = curr;

            } else if (curr.val == 1) {

                one.next = curr;
                one = curr;

            } else {

                two.next = curr;
                two = curr;
            }

            // Move to next node of original list
            curr = next;
        }

        // Connect 0-list to 1-list
        zero.next = oneHead.next;

        // Connect 1-list to 2-list
        one.next = twoHead.next;

        // Return first actual node
        return zeroHead.next;
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
}
package Linked_List;

public class O25_Add_One_to_A_Number_Represented_In_LL {

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
    // ADD ONE TO NUMBER
    // =========================================================
    /*
    Question:
    A number is represented using a singly linked list.

    Example:
    1 -> 2 -> 9

    This represents the number 129.

    Add 1:

    129 + 1 = 130

    Output:
    1 -> 3 -> 0


    Approach:
    1. Reverse the linked list so that we can start
       adding from the last digit.

    2. Add 1 to the first digit.

    3. If the sum is 10, store 0 and carry 1.

    4. Continue adding the carry to the next digit.

    5. Reverse the list again to restore the
       original number direction.


    Time: O(N)
    Space: O(1)
    */
    public static ListNode addOne(ListNode head) {

        // If list is empty, the number is 0.
        // 0 + 1 = 1
        if (head == null) {
            return new ListNode(1);
        }


        // -----------------------------------------------------
        // STEP 1: REVERSE THE LINKED LIST
        // -----------------------------------------------------
        /*
        Before:

        1 -> 2 -> 9

        After:

        9 -> 2 -> 1

        Now we can start adding from the last digit.
        */
        head = reverse(head);


        // -----------------------------------------------------
        // STEP 2: ADD 1
        // -----------------------------------------------------
        int carry = 1;

        ListNode curr = head;

        while (curr != null && carry > 0) {

            // Add carry to current digit
            int sum = curr.val + carry;

            // Store the digit part
            curr.val = sum % 10;

            // Store the carry part
            carry = sum / 10;


            // -------------------------------------------------
            // If this is the last node and carry still exists
            // -------------------------------------------------
            /*
            Example:

            9 -> 9 -> 9

            After reverse:

            9 -> 9 -> 9

            First 9 + 1 = 10
            Store 0, carry = 1

            Second 9 + 1 = 10
            Store 0, carry = 1

            Third 9 + 1 = 10
            Store 0, carry = 1

            We need one extra node:

            0 -> 0 -> 0 -> 1
            */
            if (curr.next == null && carry > 0) {

                curr.next = new ListNode(carry);

                // Carry is now handled
                carry = 0;

                break;
            }

            // Move to the next digit
            curr = curr.next;
        }


        // -----------------------------------------------------
        // STEP 3: REVERSE AGAIN
        // -----------------------------------------------------
        /*
        Example:

        After addition:

        0 -> 3 -> 1

        Reverse:

        1 -> 3 -> 0
        */
        head = reverse(head);

        return head;
    }


    // =========================================================
    // REVERSE LINKED LIST
    // =========================================================
    public static ListNode reverse(ListNode head) {

        ListNode curr = head;

        ListNode prev = null;

        while (curr != null) {

            // Save next node
            // because we are going to change curr.next
            ListNode next = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move prev forward
            prev = curr;

            // Move curr forward
            curr = next;
        }

        // prev becomes the new head
        return prev;
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

        // -----------------------------------------------------
        // TEST CASE 1
        // -----------------------------------------------------
        // 1 -> 2 -> 9
        //
        // 129 + 1 = 130

        int[] arr1 = {1, 2, 9};

        ListNode head1 = createList(arr1);

        System.out.println("Test Case 1");

        System.out.print("Before: ");
        printList(head1);

        head1 = addOne(head1);

        System.out.print("After:  ");
        printList(head1);


        // -----------------------------------------------------
        // TEST CASE 2
        // -----------------------------------------------------
        // 9 -> 9 -> 9
        //
        // 999 + 1 = 1000

        int[] arr2 = {9, 9, 9};

        ListNode head2 = createList(arr2);

        System.out.println("\nTest Case 2");

        System.out.print("Before: ");
        printList(head2);

        head2 = addOne(head2);

        System.out.print("After:  ");
        printList(head2);


        // -----------------------------------------------------
        // TEST CASE 3
        // -----------------------------------------------------
        // 1 -> 2 -> 3
        //
        // 123 + 1 = 124

        int[] arr3 = {1, 2, 3};

        ListNode head3 = createList(arr3);

        System.out.println("\nTest Case 3");

        System.out.print("Before: ");
        printList(head3);

        head3 = addOne(head3);

        System.out.print("After:  ");
        printList(head3);


        // -----------------------------------------------------
        // TEST CASE 4
        // -----------------------------------------------------
        // 9
        //
        // 9 + 1 = 10

        int[] arr4 = {9};

        ListNode head4 = createList(arr4);

        System.out.println("\nTest Case 4");

        System.out.print("Before: ");
        printList(head4);

        head4 = addOne(head4);

        System.out.print("After:  ");
        printList(head4);
    }
}
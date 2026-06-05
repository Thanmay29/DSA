package Linked_List;

public class O10_2_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy head to simplify list building
        ListNode curr = dummy;            // Pointer to build the result list
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;  // Value from l1, 0 if l1 is exhausted
            int val2 = (l2 != null) ? l2.val : 0;  // Value from l2, 0 if l2 is exhausted

            int sum = val1 + val2 + carry;        // Total sum at this digit
            carry = sum / 10;                     // Update carry for next digit

            // ⚠️ Missing line in your code
            curr.next = new ListNode(sum % 10);   // Add current digit to result
            curr = curr.next;                     // Move the result pointer

            // Move input list pointers
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // Return the real head (after dummy)
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create first list: 2 -> 4 -> 3  (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second list: 5 -> 6 -> 4  (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        O10_2_Add_Two_Numbers solution = new O10_2_Add_Two_Numbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the resulting list: expected output is 7 -> 0 -> 8 (represents 807)
        printList(result);
    }
}

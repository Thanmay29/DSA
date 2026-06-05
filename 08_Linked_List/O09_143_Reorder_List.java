package Linked_List;

// Definition for singly-linked list node.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int val) { this.val = val; }
//}

public class O09_143_Reorder_List {

    public void reorderList(ListNode head){
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode second = reverse(slow.next);
        slow.next = null; // break the list into two halves

        // Step 3: Merge the two halves alternately
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    // Proper reverse function
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        O09_143_Reorder_List obj = new O09_143_Reorder_List();
        obj.reorderList(head);

        // Print reordered list: 1 -> 5 -> 2 -> 4 -> 3
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

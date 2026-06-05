package Linked_List;

// Definition for singly-linked list
//class ListNode {
//    int val;
//    ListNode next;
//
//    // Constructors
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class O08_876_Middle_Of_The_LL {

    // Method to return the middle node of the linked list
    public ListNode middleNode(ListNode head) {
        // If list is empty, return null
        if (head == null) return null;

        // Initialize two pointers, both starting at head
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by 2 steps and slow by 1 step each iteration
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow by 1 node
            fast = fast.next.next;    // move fast by 2 nodes
        }

        // When fast reaches end, slow is at the middle
        return slow;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        O08_876_Middle_Of_The_LL obj = new O08_876_Middle_Of_The_LL();
        ListNode middle = obj.middleNode(head);

        // Print every node from the middle to the end
        System.out.println("Middle Node value: "+ middle.val);
        System.out.print("Nodes from the middle to end: ");
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
    }
}

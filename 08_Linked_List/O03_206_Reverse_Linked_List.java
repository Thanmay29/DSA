package Linked_List;

public class O03_206_Reverse_Linked_List {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode nxtNode = curr.next; // save next node
            curr.next = prev;             // reverse link
            prev = curr;                  // move prev forward
            curr = nxtNode;               // move curr forward
        }
        return prev;
    }

    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        O03_206_Reverse_Linked_List obj = new O03_206_Reverse_Linked_List();

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        obj.printList(head);

        // Reverse the list
        ListNode reversed = obj.reverseList(head);

        System.out.println("Reversed List:");
        obj.printList(reversed);
    }
}

package Linked_List;




public class O01_2095_Delete_The_Middle_Node_Of_A_Linked_List {
    public static void main(String[] args) {


        // Example 1: [1,3,4,7,1,2,6] → [1,3,4,1,2,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        printList(deleteMiddle(head)); // Output: [1,3,4,1,2,6]

    }

    public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head, fast = head, prev= null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
}

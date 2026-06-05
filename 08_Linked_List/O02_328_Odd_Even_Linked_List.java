package Linked_List;



public class O02_328_Odd_Even_Linked_List {
    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5] → [1,3,5,2,4]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(oddEvenList(head)); // Output: 1 3 5 2 4
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        //Original List:  1 → 2 → 3 → 4 → 5 → NULL
        //Indexes:        0   1   2   3   4
        //Odd List:       1 → 3 → 5
        //Even List:      2 → 4
        while(even != null && even.next != null){
            odd.next = even.next;  // odd.next (1.next) now points to 3
            odd = odd.next;        // Move odd to 3
            even.next = odd.next;  // even.next (2.next) now points to 4
            even = even.next;      // Move even to 4
        }
        odd.next = evenHead;
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

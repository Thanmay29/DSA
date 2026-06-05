package Linked_List;

public class O20_92_Reverse_LL_II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1; i<left; i++){
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for(int i=0; i<right-left; i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        O20_92_Reverse_LL_II obj = new O20_92_Reverse_LL_II();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = obj.reverseBetween(head, 2, 4);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

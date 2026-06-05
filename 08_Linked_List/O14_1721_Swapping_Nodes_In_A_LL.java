package Linked_List;

public class O14_1721_Swapping_Nodes_In_A_LL {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;

        for(int i=1; i<k; i++){
            fast = fast.next;
        }

        ListNode sec = fast;
        ListNode first = head;

        while(fast.next!=null){
            fast = fast.next;
            first = first.next;
        }

        int temp = sec.val;
        sec.val = first.val;
        first.val = temp;

        return head;
    }

    // Helper method to build a linked list from an array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int k = 2;

        ListNode head = buildList(input);

        O14_1721_Swapping_Nodes_In_A_LL solution = new O14_1721_Swapping_Nodes_In_A_LL();
        ListNode result = solution.swapNodes(head, k);

        System.out.print("Modified List: ");
        printList(result); // Expected: 1 -> 4 -> 3 -> 2 -> 5
    }
}

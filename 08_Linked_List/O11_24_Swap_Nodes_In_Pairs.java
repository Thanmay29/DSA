package Linked_List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class O11_24_Swap_Nodes_In_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode sec = head.next;

            prev.next = sec;
            first.next = sec.next;
            sec.next = first;

            prev = first;
            head = first.next;
        }

        return dummy.next;
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
        O11_24_Swap_Nodes_In_Pairs obj = new O11_24_Swap_Nodes_In_Pairs();

        int[] input = {1, 2, 3, 4}; // Example input
        ListNode head = buildList(input);

        System.out.print("Original list: ");
        printList(head);

        ListNode swapped = obj.swapPairs(head);

        System.out.print("Swapped list: ");
        printList(swapped);
    }
}

package Linked_List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class O13_2181_Merge_Nodes_In_Between_Zeros {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int sum = 0;
        head = head.next;

        while(head != null){
            if(head.val == 0){
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
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
        int[] input = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode head = buildList(input);

        O13_2181_Merge_Nodes_In_Between_Zeros solution = new O13_2181_Merge_Nodes_In_Between_Zeros();
        ListNode result = solution.mergeNodes(head);

        System.out.print("Modified List: ");
        printList(result); // Expected: 4 -> 11
    }
}

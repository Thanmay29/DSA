package Linked_List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class O12_82_Remove_Duplicates_From_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null) {
            // Check for duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip nodes with same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after duplicates
                prev.next = head.next;
            } else {
                // Move prev forward if no duplicate
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    // Helper to build a linked list from an array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        O12_82_Remove_Duplicates_From_Sorted_List_II obj = new O12_82_Remove_Duplicates_From_Sorted_List_II();

        int[] input = {1, 2, 3, 3, 4, 4, 5}; // Change as needed
        ListNode head = buildList(input);

        System.out.print("Original List: ");
        printList(head);

        ListNode result = obj.deleteDuplicates(head);

        System.out.print("List After Removing Duplicates: ");
        printList(result);
    }
}

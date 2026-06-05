package Linked_List;


//deletes a node in a linked list
//without access to the head,
//assuming the node is not the tail:
public class O17_237_Delete_Node_In_A_LL {

    public void deleteNode(ListNode node) {
        if(node==null || node.next==null) return;

        // Copy the next node's value into this node
        node.val = node.next.val;
        // Skip over the next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // Example: head = [4, 5, 1, 9], delete node with value 5
        ListNode head = buildList(new int[]{4, 5, 1, 9});
        ListNode nodeToDelete = head.next; // Node with value 5

        new O17_237_Delete_Node_In_A_LL().deleteNode(nodeToDelete);
        printList(head); // Expected Output: 4 -> 1 -> 9
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}

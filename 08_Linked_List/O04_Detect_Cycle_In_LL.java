package Linked_List;

public class O04_Detect_Cycle_In_LL {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move one step
            fast = fast.next.next;      // move two steps

            if (slow == fast) {
                return true;            // cycle detected
            }
        }
        return false;                   // no cycle
    }

    public static void main(String[] args) {
        // Sample test
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // creates a cycle

        System.out.println("Has cycle: " + hasCycle(node1)); // Output: true
    }
}

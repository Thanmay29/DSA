package Linked_List;


//Given the head of a linked list,
//return the node where the cycle begins.
//If there is no cycle, return null.


//sol

//Use two pointers (slow and fast) to detect a cycle:
//slow moves one step at a time.
//fast moves two steps at a time.
//If they meet, a cycle exists.
//Reset one pointer to the head.
//Move both one step at a time until they meet again.
//That meeting point is the start of the cycle.

public class O19_142_Linked_List_Cycle_II {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move by 1
            fast = fast.next.next;     // move by 2

            if (slow == fast) { // Cycle detected
                // Step 2: Move slow to head, keep fast at meeting point
                slow = head;

                // Step 3: Move both one step at a time to find start of cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // Start of cycle
            }
        }

        return null; // No cycle
    }

    public static void main(String[] args) {
        // Creating list: 3 -> 2 -> 0 -> -4
        //                       ^         |
        //                       |_________|
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // creates a cycle

        ListNode cycleStart = detectCycle(node1);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

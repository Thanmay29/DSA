package Linked_List;

public class O07_160_Intersection_Of_Two_Linked_List {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // either intersection node or null
    }

    public static void main(String[] args) {
        // Shared part: 8 -> 4 -> 5
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // List A: 4 -> 1 -> [8 -> 4 -> 5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // List B: 5 -> 6 -> 1 -> [8 -> 4 -> 5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        // Find intersection
        ListNode result = getIntersectionNode(headA, headB);

        // Print result
        if (result != null) {
            System.out.println("Intersected at '" + result.val + "'");
        } else {
            System.out.println("No intersection");
        }
    }
}

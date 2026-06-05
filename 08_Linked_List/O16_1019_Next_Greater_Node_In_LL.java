package Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int val) { this.val = val; }
//}

public class O16_1019_Next_Greater_Node_In_LL {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        // Step 1: Convert linked list to list
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>(); // Stack stores indices

        // Step 2: Monotonic stack to find next greater element
        for (int i = 0; i < list.size(); i++) {
            while (!st.isEmpty() && list.get(i) > list.get(st.peek())) {
                int idx = st.pop();
                res[idx] = list.get(i);
            }
            st.push(i);
        }

        return res;
    }

    // Optional: build helper to test
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 4, 3, 5}; // Expected output: [7, 0, 5, 5, 0]
        ListNode head = buildList(input);

        O16_1019_Next_Greater_Node_In_LL solution = new O16_1019_Next_Greater_Node_In_LL();
        int[] result = solution.nextLargerNodes(head);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

package Linked_List;

import java.util.HashMap;
import java.util.Map;

public class O15_1171_Remove_Zero_Sum_Consecutive_Nodes_From_LL {

    public ListNode removeZeroSumSublists(ListNode head) {
        // Dummy node to handle head removal
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;

        // First pass: store last occurrence of each prefix sum
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
        }

        // Second pass: remove zero-sum sublists
        prefixSum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
        }

        return dummy.next;
    }

    public static ListNode buildList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int i : arr){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

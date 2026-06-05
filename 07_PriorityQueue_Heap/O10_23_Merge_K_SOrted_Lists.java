package PriorityQueue_Heap;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Logic:

//Add first nodes of each list to a min-heap.
//
//Extract smallest node from the heap.
//
//Add it to the result list.
//
//If that node has a next, insert it into the heap.
//
//Repeat until the heap is empty.
public class O10_23_Merge_K_SOrted_Lists {

    // Function to merge k sorted linked lists
    public static ListNode merge(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;

        // Min-heap to always fetch the node with the smallest value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        // Dummy node to start building the result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Process the heap until it's empty
        while(!pq.isEmpty()){
            // Get the smallest node
            ListNode smallest = pq.poll();
            curr.next = smallest; // Append it to result
            curr = curr.next;

            // If there’s more nodes in that list, add the next node to the heap
            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }

        return dummy.next; // Head of the merged list
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int num : arr){
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example input: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        ListNode merged = merge(lists);
        System.out.print("Merged List: ");
        printList(merged);
    }
}

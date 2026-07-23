package Linked_List;

import java.util.ArrayList;
import java.util.List;

public class O28_Find_Pairs_with_Given_Sum_in_Doubly_LL {

    /*
    ============================================================
    QUESTION
    ============================================================

    Given the head of a SORTED doubly linked list of distinct
    integers and a target value, find all pairs whose sum
    is equal to the target.

    Each pair should be returned as:

    [a, b]

    where:

    a + b == target

    Example:

    Input:
    1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9

    Target = 7

    Valid pairs:

    1 + 6 = 7
    2 + 5 = 7

    Output:

    [[1, 6], [2, 5]]


    ============================================================
    APPROACH: TWO POINTERS
    ============================================================

    Because the doubly linked list is SORTED:

    left  -> starts from the first node
    right -> starts from the last node


    If:

    left.val + right.val == target

        Pair found.
        Store the pair.
        Move both pointers.


    If:

    left.val + right.val < target

        Sum is too small.
        Move left forward to increase the sum.


    If:

    left.val + right.val > target

        Sum is too large.
        Move right backward to decrease the sum.


    Example:

    2 <-> 3 <-> 5 <-> 9

    Target = 12


    Step 1:

    2 + 9 = 11

    11 < 12

    Move left forward.


    Step 2:

    3 + 9 = 12

    Pair found:

    [3, 9]


    Time Complexity: O(N)
    Space Complexity: O(1)
    Excluding the output list.
    */


    // =========================================================
    // NODE
    // =========================================================
    static class ListNode {

        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }


    // =========================================================
    // FIND PAIRS WITH GIVEN SUM
    // =========================================================
    public static List<List<Integer>> findPairsWithGivenSum(
            ListNode head, int target) {

        // Store all valid pairs
        List<List<Integer>> res = new ArrayList<>();

        // If linked list is empty,
        // return empty result
        if (head == null) {
            return res;
        }

        // -----------------------------------------------------
        // LEFT POINTER
        // -----------------------------------------------------
        // Starts from the first node
        ListNode left = head;

        // -----------------------------------------------------
        // RIGHT POINTER
        // -----------------------------------------------------
        // Initially starts from head.
        // We will move it to the last node.
        ListNode right = head;

        // Move right pointer to the last node
        while (right.next != null) {
            right = right.next;
        }


        // -----------------------------------------------------
        // TWO POINTER APPROACH
        // -----------------------------------------------------
        while (left != null
                && right != null
                && left != right
                && left.prev != right) {

            // Calculate sum
            int sum = left.val + right.val;


            // -------------------------------------------------
            // CASE 1: SUM == TARGET
            // -------------------------------------------------
            if (sum == target) {

                // Create a new pair
                List<Integer> pair = new ArrayList<>();

                // Add smaller value first
                pair.add(left.val);

                // Add larger value second
                pair.add(right.val);

                // Add pair to result
                res.add(pair);

                // Move both pointers
                left = left.next;
                right = right.prev;
            }


            // -------------------------------------------------
            // CASE 2: SUM < TARGET
            // -------------------------------------------------
            else if (sum < target) {

                /*
                Sum is too small.

                Since the list is sorted,
                moving left forward gives a larger value.

                Example:

                2 + 9 = 11

                Target = 12

                Move left:

                3 + 9 = 12
                */

                left = left.next;
            }


            // -------------------------------------------------
            // CASE 3: SUM > TARGET
            // -------------------------------------------------
            else {

                /*
                Sum is too large.

                Since the list is sorted,
                moving right backward gives a smaller value.

                Example:

                5 + 9 = 14

                Target = 12

                Move right backward.
                */

                right = right.prev;
            }
        }

        return res;
    }


    // =========================================================
    // CREATE DOUBLY LINKED LIST
    // =========================================================
    public static ListNode createList(int[] arr) {

        // Empty array
        if (arr.length == 0) {
            return null;
        }

        // Create first node
        ListNode head = new ListNode(arr[0]);

        ListNode curr = head;

        // Create remaining nodes
        for (int i = 1; i < arr.length; i++) {

            ListNode newNode = new ListNode(arr[i]);

            // Forward connection
            curr.next = newNode;

            // Backward connection
            newNode.prev = curr;

            // Move curr forward
            curr = newNode;
        }

        return head;
    }


    // =========================================================
    // PRINT DOUBLY LINKED LIST
    // =========================================================
    public static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {

            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" <-> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }


    // =========================================================
    // PRINT PAIRS
    // =========================================================
    public static void printPairs(
            List<List<Integer>> pairs) {

        System.out.print("[");

        for (int i = 0; i < pairs.size(); i++) {

            System.out.print(pairs.get(i));

            if (i < pairs.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        // =====================================================
        // TEST CASE 1
        // =====================================================
        // Input:
        // 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
        //
        // Target = 7
        //
        // Output:
        // [[1, 6], [2, 5]]

        int[] arr1 = {1, 2, 4, 5, 6, 8, 9};

        ListNode head1 = createList(arr1);

        int target1 = 7;

        System.out.println("Test Case 1");

        System.out.print("List: ");
        printList(head1);

        System.out.println("Target: " + target1);

        List<List<Integer>> result1 =
                findPairsWithGivenSum(head1, target1);

        System.out.print("Pairs: ");
        printPairs(result1);


        // =====================================================
        // TEST CASE 2
        // =====================================================
        // Input:
        // 1 <-> 5 <-> 6
        //
        // Target = 6
        //
        // Output:
        // [[1, 5]]

        int[] arr2 = {1, 5, 6};

        ListNode head2 = createList(arr2);

        int target2 = 6;

        System.out.println("\nTest Case 2");

        System.out.print("List: ");
        printList(head2);

        System.out.println("Target: " + target2);

        List<List<Integer>> result2 =
                findPairsWithGivenSum(head2, target2);

        System.out.print("Pairs: ");
        printPairs(result2);


        // =====================================================
        // TEST CASE 3
        // =====================================================
        // Input:
        // 2 <-> 3 <-> 5 <-> 9
        //
        // Target = 12
        //
        // Output:
        // [[3, 9]]

        int[] arr3 = {2, 3, 5, 9};

        ListNode head3 = createList(arr3);

        int target3 = 12;

        System.out.println("\nTest Case 3");

        System.out.print("List: ");
        printList(head3);

        System.out.println("Target: " + target3);

        List<List<Integer>> result3 =
                findPairsWithGivenSum(head3, target3);

        System.out.print("Pairs: ");
        printPairs(result3);


        // =====================================================
        // TEST CASE 4
        // =====================================================
        // No valid pair
        //
        // Input:
        // 1 <-> 2 <-> 3
        //
        // Target = 10
        //
        // Output:
        // []

        int[] arr4 = {1, 2, 3};

        ListNode head4 = createList(arr4);

        int target4 = 10;

        System.out.println("\nTest Case 4");

        System.out.print("List: ");
        printList(head4);

        System.out.println("Target: " + target4);

        List<List<Integer>> result4 =
                findPairsWithGivenSum(head4, target4);

        System.out.print("Pairs: ");
        printPairs(result4);
    }
}
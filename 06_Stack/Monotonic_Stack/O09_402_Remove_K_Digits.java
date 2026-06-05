package Stack.Monotonic_Stack;
import java.util.*;

public class O09_402_Remove_K_Digits {

    public String removeKdigits(String num, int k) {
        // Use a Deque (double-ended queue) as a stack to store digits
        Deque<Character> stack = new ArrayDeque<>();

        // Traverse through each digit in the input string
        for (char digit : num.toCharArray()) {

            // Remove digits from the end of the stack if:
            // - Stack is not empty
            // - Still have digits to remove (k > 0)
            // - The current digit is smaller than the last digit in stack
            // This helps in forming the smallest possible number
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast(); // Remove the larger digit
                k--; // Decrease the number of digits to remove
            }

            // Add the current digit to the stack
            stack.offerLast(digit);
        }

        // If there are still digits left to remove, remove them from the end
        // (these are the largest remaining digits)
        while (k-- > 0) {
            stack.pollLast();
        }

        // Build the result from the digits in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst()); // Add digits in original order
        }

        // Remove leading zeros from the result
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // If result is empty after removing leading zeros, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        O09_402_Remove_K_Digits solver = new O09_402_Remove_K_Digits();

        // Test examples
        System.out.println(solver.removeKdigits("1432219", 3)); // Output: "1219"
        System.out.println(solver.removeKdigits("10200", 1));    // Output: "200"
        System.out.println(solver.removeKdigits("10", 2));       // Output: "0"
        System.out.println(solver.removeKdigits("12345", 3)); // Output: "12"
    }
}

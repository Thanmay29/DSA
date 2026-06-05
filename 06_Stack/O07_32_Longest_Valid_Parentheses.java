package Stack;

import java.util.Stack;

public class O07_32_Longest_Valid_Parentheses {

    // Method to find the length of the longest valid (well-formed) parentheses substring
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;

        // Push -1 initially as a base index to handle edge cases
        st.push(-1);

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of '('
                st.push(i);
            } else {
                // Pop the last index (ideally for '(')
                st.pop();

                if (st.isEmpty()) {
                    // If stack is empty, push current index as base for next valid substring
                    st.push(i);
                } else {
                    // If not empty, calculate length from current index to the index on top of the stack
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }

    // Main method to test the function
    public static void main(String[] args) {
        O07_32_Longest_Valid_Parentheses obj = new O07_32_Longest_Valid_Parentheses();

        // Test cases
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = ")()((";
        String s4 = "";

        System.out.println("Input: " + s1 + " → Output: " + obj.longestValidParentheses(s1));   // Output: 2
        System.out.println("Input: " + s2 + " → Output: " + obj.longestValidParentheses(s2));   // Output: 4
        System.out.println("Input: " + s3 + " → Output: " + obj.longestValidParentheses(s3));   // Output: 2
        System.out.println("Input: \"" + s4 + "\" → Output: " + obj.longestValidParentheses(s4)); // Output: 0
    }
}

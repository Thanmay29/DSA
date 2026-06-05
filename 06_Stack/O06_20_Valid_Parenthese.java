package Stack;

import java.util.Stack;

public class O06_20_Valid_Parenthese {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); // Stack to keep track of opening brackets

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current char is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // If current char is a closing bracket, stack must not be empty
                if (st.isEmpty()) return false; // No matching opening bracket

                // Pop the top element from stack (last opening bracket)
                char top = st.pop();

                // Check if the popped opening bracket matches the current closing bracket
                // If not matching, return false
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // After processing all characters, if stack is empty, all brackets matched correctly
        // If not empty, some opening brackets were not closed
        return st.isEmpty();
    }

    public static void main(String[] args) {
        O06_20_Valid_Parenthese obj = new O06_20_Valid_Parenthese();
        System.out.println(obj.isValid("()"));        // true
        System.out.println(obj.isValid("()[]{}"));    // true
        System.out.println(obj.isValid("(]"));        // false
        System.out.println(obj.isValid("([])"));      // true
        System.out.println(obj.isValid("([)]"));      // false
        System.out.println(obj.isValid("("));         // false
    }
}

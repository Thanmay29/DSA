package Stack;

import java.util.Stack;

public class O04_227_Basic_Calculator_II {

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>(); // Stack to store numbers and intermediate results

        int num = 0;        // Current number being built from the string
        char sign = '+';    // Tracks the last seen operator; initialized to '+' to handle the first number
        int n = s.length(); // Length of the input string

        // Traverse through each character in the string
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If the character is a digit, build the number (handles multi-digit numbers)
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // If the character is an operator or we are at the end of the string
            // We process the previous sign and number
            if((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if(sign == '+') {
                    st.push(num); // Push the number as it is
                } else if(sign == '-') {
                    st.push(-num); // Push the negative of the number
                } else if(sign == '*') {
                    st.push(st.pop() * num); // Pop the previous number and multiply
                } else if(sign == '/') {
                    st.push(st.pop() / num); // Pop the previous number and divide (integer division)
                }

                // Update the sign to the current operator
                sign = c;

                // Reset num to 0 for the next number
                num = 0;
            }
        }

        int res = 0;

        // Add up all the numbers in the stack to get the final result
        for(int val : st) {
            res += val;
        }

        return res;
    }

    public static void main(String[] args) {
        O04_227_Basic_Calculator_II calc = new O04_227_Basic_Calculator_II();

        // Test cases
        System.out.println(calc.calculate("3+2*2"));     // Output: 7
        System.out.println(calc.calculate(" 3/2 "));     // Output: 1
        System.out.println(calc.calculate(" 3+5 / 2 ")); // Output: 5
    }
}

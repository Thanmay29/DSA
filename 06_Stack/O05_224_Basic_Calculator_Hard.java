package Stack;

import java.util.Stack;

public class O05_224_Basic_Calculator_Hard {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0; // Cumulative result
        int number = 0; // Current number being formed from digits
        int sign = 1;   // Current sign: 1 means '+', -1 means '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If current character is a digit, build the number
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            // If current character is '+' or '-', process the previous number and update the sign
            else if (c == '+') {
                result += sign * number; // Add previous number with its sign
                number = 0;              // Reset number for the next one
                sign = 1;                // Set sign for the next number
            }
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            // If '(' is found, push current result and sign onto the stack
            // We'll compute the expression inside parentheses separately
            else if (c == '(') {
                stack.push(result); // Save outer result
                stack.push(sign);   // Save outer sign
                result = 0;         // Reset result for inner expression
                sign = 1;           // Default sign for inner expression
            }

            // If ')' is found, complete the current inner expression
            // and combine with the result from before the '('
            else if (c == ')') {
                result += sign * number; // First complete the current number
                number = 0;

                result *= stack.pop();   // Apply the sign before the '('
                result += stack.pop();   // Add it to the result before the '('
            }

            // Ignore spaces
        }

        // In case any number is left at the end (e.g. "2 + 3")
        result += sign * number;

        return result;
    }

    public static void main(String[] args) {
        O05_224_Basic_Calculator_Hard calc = new O05_224_Basic_Calculator_Hard();

        System.out.println(calc.calculate("1 + 1"));                // Output: 2
        System.out.println(calc.calculate(" 2-1 + 2 "));            // Output: 3
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));  // Output: 23
        System.out.println(calc.calculate("-(2+3)"));               // Output: -5
    }
}

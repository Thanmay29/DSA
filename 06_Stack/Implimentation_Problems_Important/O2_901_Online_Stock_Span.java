package Stack.Implimentation_Problems_Important;

import java.util.Stack;

/**
 * Leetcode 901 - Online Stock Span
 *
 * 📌 Problem:
 * Design an algorithm that collects daily price quotes for a stock and
 * returns the span of that stock's price for the current day.
 *
 * Span = number of consecutive days (including today) t
 * he price was less than or equal to today’s price.
 *
 * 🧠 Example:
 * Input: [100, 80, 60, 70, 60, 75, 85]
 * Output: [1, 1, 1, 2, 1, 4, 6]
 *
 * Explanation:
 * - 75 → last 4 days prices <= 75 → span = 4
 * - 85 → last 6 days prices <= 85 → span = 6
 *
 * 🧪 Constraints:
 * - 1 <= price <= 10^5
 * - At most 10^4 calls to next()
 *
 * ✅ Efficient Approach:
 * Use a monotonic decreasing stack that stores pairs of [price, span].
 * When current price >= top of stack, pop and accumulate spans.
 */

public class O2_901_Online_Stock_Span {

    // StockSpanner class to encapsulate logic
    static class StockSpanner {
        // Stack to store pairs: [price, span]
        private Stack<int[]> stack;

        // Constructor to initialize stack
        public StockSpanner() {
            stack = new Stack<>();
        }

        // next(int price): returns the span for today's price
        public int next(int price) {
            // Start with span = 1 for the current day
            int span = 1;

            // While stack is not empty and top price <= current price
            // we pop and add its span to current span
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1]; // accumulate span
            }

            // Push current price and its span to the stack
            stack.push(new int[]{price, span});

            // Return the final computed span
            return span;
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        // Example input prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Call next for each price and print the result
        for (int price : prices) {
            int span = stockSpanner.next(price);
            System.out.println("Price: " + price + " → Span: " + span);
        }
    }
}

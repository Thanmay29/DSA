package Stack;

public class O08_1963_Minimum_Number_Of_Swaps_To_Make_The_String_Balanced {

    /**
     * Returns the minimum number of swaps required to make the input string balanced.
     * The string contains equal numbers of '[' and ']' and has even length.
     *
     * @param s input string consisting of '[' and ']'
     * @return minimum number of swaps to balance the string
     */
    public int minSwap(String s) {
        int balance = 0;        // Current balance of brackets
        // +1 for '[', -1 for ']'
        int maxImbalance = 0;   // Maximum depth of imbalance (negative balance)

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;      // Opening bracket increases balance
            } else {
                balance--;      // Closing bracket decreases balance

                // If balance goes negative, it means more closing brackets seen than opening ones
                if (balance < 0) {
                    // Track the worst imbalance (largest negative balance)
                    maxImbalance = Math.max(maxImbalance, -balance);
                }
            }
        }

        // Each swap fixes two misplaced brackets, so
        // minimum swaps = ceil(maxImbalance / 2)
        return (maxImbalance + 1) / 2;
    }

    public static void main(String[] args) {
        O08_1963_Minimum_Number_Of_Swaps_To_Make_The_String_Balanced obj = new O08_1963_Minimum_Number_Of_Swaps_To_Make_The_String_Balanced();

        String s1 = "][][";
        System.out.println("Minimum swaps for \"" + s1 + "\": " + obj.minSwap(s1));  // Output: 1

        String s2 = "]]][[[";
        System.out.println("Minimum swaps for \"" + s2 + "\": " + obj.minSwap(s2));  // Output: 2

        String s3 = "[]";
        System.out.println("Minimum swaps for \"" + s3 + "\": " + obj.minSwap(s3));  // Output: 0
    }
}

package Strings;

public class O26_8_String_To_Integer_atoi {

    public static void main(String[] args) {
        // Example test cases
        testMyAtoi("42");            // Expected: 42
        testMyAtoi("   -042");       // Expected: -42
        testMyAtoi("1337c0d3");      // Expected: 1337
        testMyAtoi("0-1");           // Expected: 0
        testMyAtoi("words and 987"); // Expected: 0
    }

    private static void testMyAtoi(String s) {
        int result = myAtoi(s);
        System.out.println("Input: \"" + s + "\" → Output: " + result);
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int i = 0, sign = 1;
        int res = 0;  // use int, handle overflow mathematically

        // Step 1: Skip all leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        // Step 2: Check for sign
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to number
        while(i < n && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i) - '0';

            // Step 4: Handle overflow
            if(res > (Integer.MAX_VALUE - num) / 10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + num;
            i++;
        }

        return res * sign;
    }
}

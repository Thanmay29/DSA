package Recursion;

public class O09_8_String_to_Integer_atoi {

    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // Step 1: skip leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;

        if (i == n) return 0;

        // Step 2: sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: read digits with overflow guard
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;

            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > (long) Integer.MAX_VALUE + 1) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * res);
    }

    public static void main(String[] args) {
        O09_8_String_to_Integer_atoi sol = new O09_8_String_to_Integer_atoi();

        System.out.println(sol.myAtoi("42"));                 // 42
        System.out.println(sol.myAtoi("   -042"));             // -42
        System.out.println(sol.myAtoi("1337c0d3"));            // 1337
        System.out.println(sol.myAtoi("0-1"));                 // 0
        System.out.println(sol.myAtoi("words and 987"));       // 0
        System.out.println(sol.myAtoi("-2147483649"));         // -2147483648 (clamped)
        System.out.println(sol.myAtoi("-2147483648"));         // -2147483648 (exact boundary)
        System.out.println(sol.myAtoi("2147483648"));          // 2147483647 (clamped)
    }
}
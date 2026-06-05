package Strings;

public class O04_07_Reverse_Integer {
    public static void main(String[] args) {
        //Example 1:
        //
        //Input: x = 123
        //Output: 321
        //Example 2:
        //
        //Input: x = -123
        //Output: -321
        //Example 3:
        //
        //Input: x = 120
        //Output: 21

        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int num = x % 10;

            // Overflow check before updating res
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }

            res = res * 10 + num;
            x /= 10;
        }

        return res;
    }

}

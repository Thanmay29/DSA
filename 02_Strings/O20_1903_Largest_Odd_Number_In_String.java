package Strings;

import static java.lang.Integer.parseInt;

public class O20_1903_Largest_Odd_Number_In_String {
    public static void main(String[] args) {
        String num1 = "52"; // output : "5"
        System.out.println(largestOddNumber(num1));

        String num2 = "4206"; //output = ""
        System.out.println(largestOddNumber(num2));

        String num3 = "35427"; //output = "35427"
        System.out.println(largestOddNumber(num3));
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {  // traverse from end of num
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);  // return prefix ending at odd digit
            }
        }
        return "";  // if there's no odd
    }
}

package Strings;

public class O11_1071_Greates_Common_Divisor_Of_Strings {
    public static void main(String[] args) {

        //Example 1:
        //Input: str1 = "ABCABC", str2 = "ABC"
        //Output: "ABC"

        //Example 2:
        //Input: str1 = "ABABAB", str2 = "ABAB"
        //Output: "AB"

        //Example 3:
        //Input: str1 = "LEET", str2 = "CODE"
        //Output: ""
        String str1 = "ABCABC", str2 = "ABC";

        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        // If concatenation results are different, there's no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of lengths of str1 and str2
        int gcdLen = gcd(str1.length(), str2.length());

        // Return substring of length gcdLen from str1
        return str1.substring(0, gcdLen);
    }

    // Function to find GCD using Euclidean algorithm
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

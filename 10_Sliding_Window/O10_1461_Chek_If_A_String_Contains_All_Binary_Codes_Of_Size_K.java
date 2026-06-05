package Sliding_Window;

import java.util.HashSet;

public class O10_1461_Chek_If_A_String_Contains_All_Binary_Codes_Of_Size_K {

    // Function to check if the input string `s` contains all possible binary codes of length `k`
    public static boolean hasAllCodes(String s, int k) {
        // If the string is shorter than k, it's impossible to have any k-length substrings
        if (s.length() < k) return false;

        // Set to store unique binary substrings of length k found in the input string
        HashSet<String> seen = new HashSet<>();

        // Loop through the string with a sliding window of size k
        for (int i = 0; i <= s.length() - k; i++) {
            // Extract substring of length k starting from index i
            String sub = s.substring(i, i + k);
            // Add the substring to the set (duplicates will be ignored)
            seen.add(sub);
        }

        // Total number of binary codes of length k is 2^k
        // We return true if the number of unique substrings seen equals 2^k
        return seen.size() == (1 << k); // (1 << k) is the same as 2 to the power of k
    }

    public static void main(String[] args) {
        String s1 = "00110110";
        int k1 = 2;
        System.out.println("Test 1: " + hasAllCodes(s1, k1)); // Expected: true
        //Input: s = "00110110", k = 2
        //Output: true
        //Explanation: The binary codes of length 2 are "00", "01", "10" and "11".
        //They can be all found as substrings at indices 0, 1, 3 and 2 respectively.

        String s2 = "0110";
        int k2 = 1;
        System.out.println("Test 2: " + hasAllCodes(s2, k2)); // Expected: true
        //Input: s = "0110", k = 1
        //Output: true
        //Explanation: The binary codes of length 1 are "0" and "1",
        //it is clear that both exist as a substring.

        String s3 = "0110";
        int k3 = 2;
        System.out.println("Test 3: " + hasAllCodes(s3, k3)); // Expected: false
        // Input: s = "0110", k = 2
        //Output: false
        //Explanation: The binary code "00" is of length 2 and does not exist in the array.

        String s4 = "0000000001011100";
        int k4 = 4;
        System.out.println("Test 4: " + hasAllCodes(s4, k4)); // Expected: false
    }
}

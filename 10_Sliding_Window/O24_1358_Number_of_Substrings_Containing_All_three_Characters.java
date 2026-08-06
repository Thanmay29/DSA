package Sliding_Window;

public class O24_1358_Number_of_Substrings_Containing_All_three_Characters {

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;

            // Shrink window from left while it still contains all 3 chars
            //('a', 'b', 'c')
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Every substring starting from 'left' to end of string
                // (i.e., s.length() - right) is valid
                result += s.length() - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        O24_1358_Number_of_Substrings_Containing_All_three_Characters sol =
                new O24_1358_Number_of_Substrings_Containing_All_three_Characters();

        System.out.println(sol.numberOfSubstrings("abcabc")); // 10
        System.out.println(sol.numberOfSubstrings("aaacb"));  // 3
        System.out.println(sol.numberOfSubstrings("abc"));    // 1
    }
}
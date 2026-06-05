package Strings;

public class O02_151_Reverse_Words_In_A_String {
    public static void main(String[] args) {
        System.out.println(reverseWords(" the sky is blue ")); // Output: "blue is sky the"
    }

    public static String reverseWords(String s) {
        // Step 1: Trim the input to remove leading and trailing spaces
        System.out.println(s);
        s = s.trim();
        System.out.println(s);

        // Step 2: Split the string by one or more spaces using "\\s+" regex
        String[] words = s.split("\\s+");

        // Step 3: Use StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Step 4: Iterate through the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]); // Append the word

            if (i > 0) {
                result.append(" "); // Append space only if it's not the last word
            }
        }

        // Step 5: Convert StringBuilder to a string and return
        return result.toString();
    }
}

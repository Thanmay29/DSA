package Strings;

public class O16_String_Is_A_Rotation_Of_Another {
        public static boolean isRotation(String s1, String s2) {
            // Check if both strings are of equal length and not null
            if (s1 == null || s2 == null || s1.length() != s2.length()) {
                return false;
            }
            // Concatenate s1 with itself and check if s2 is a substring of the result
            String concatenated = s1 + s1;
            return concatenated.contains(s2);
        }

        public static void main(String[] args) {
            String s1 = "ABCD";
            String s2 = "CDAB";
            System.out.println(isRotation(s1, s2)); // Output: true
        }
}

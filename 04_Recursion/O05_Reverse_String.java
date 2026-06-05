package Recursion;

// Reverse a String
//Pattern: Post-order recursion

public class O05_Reverse_String {

    public static void reverse(String s, int idx){
        if(idx == s.length()) return;

        reverse(s, idx+1);
        System.out.println(s.charAt(idx));
    }

    static void main() {
        String str = "abc";
        reverse(str, 0);
    }
}

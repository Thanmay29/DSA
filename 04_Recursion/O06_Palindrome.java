package Recursion;

public class O06_Palindrome {

    public static boolean pal(String s, int left, int right){
        if(left>=right) return true;

        if(s.charAt(left) != s.charAt(right)) return false;

        return pal(s, left+1, right-1);
    }
    static void main() {
        String s = "abba";
        System.out.println(pal(s, 0, s.length()-1));
    }
}

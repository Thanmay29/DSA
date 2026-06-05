package Strings;

public class O23_796_Rotate_String {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab"; //true
        System.out.println(rotateString(s, goal));

        String s1 = "abcde", goal1 = "abced"; //false
        System.out.println(rotateString(s1, goal1));
    }

    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
}

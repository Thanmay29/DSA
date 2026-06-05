package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class O01_03_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(sol(s));
    }

    public static int sol(String s){
        int len = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len = Math.max(len, right-left+1);
        }

        return len;
    }
}

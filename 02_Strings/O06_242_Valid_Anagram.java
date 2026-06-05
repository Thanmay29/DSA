package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Phaser;

public class O06_242_Valid_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)) return false;
            map.put(c, map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);
        }

        return map.isEmpty();
    }

    public static boolean isAnagram1(String s, String t){
        char[] ss = s.toCharArray();
        char[] tt =  t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        if(Arrays.equals(ss,tt)){
            return true;
        }else{
            return false;
        }
    }
}

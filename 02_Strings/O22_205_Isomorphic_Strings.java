package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class O22_205_Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "egg", t = "add"; //true
        System.out.println(isIsomorphic(s, t));

        String  s1 = "foo", t1 = "bar";
        System.out.println(isIsomorphic(s1, t1));

        String  s2 = "paper", t3 = "title";
        System.out.println(isIsomorphic(s2, t3));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(map.containsKey(sChar)){
                if(map.get(sChar) != tChar){
                    return false;
                }
            }else{
                if(set.contains(tChar)){
                    return false;
                }

                map.put(sChar, tChar);
                set.add(tChar);
            }
        }
        return true;
    }
}

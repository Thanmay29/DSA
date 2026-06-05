package Strings;

import java.util.HashMap;

public class O05_387_First_Unique_Character_String {
    public static void main(String[] args) {

        //Example 1:
        //Input: s = "leetcode"
        //Output: 0
        //Explanation:
        //The character 'l' at index 0 is the first character that does not occur at any other index.

        //Example 2:
        //Input: s = "loveleetcode"
        //Output: 2

        //Example 3:
        //Input: s = "aabb"
        //Output: -1
        String s = "leetcode";

        System.out.println(firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}

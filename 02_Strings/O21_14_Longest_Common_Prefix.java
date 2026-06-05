package Strings;

import java.util.Arrays;

public class O21_14_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] str1 = {"flower","flow","flight"}; //Output: "fl"
        System.out.println(longestCommonPrefix(str1));

        String[] str2 = {"dog","racecar","car"};  //Output: ""
        System.out.println(longestCommonPrefix(str2));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs[0].length(); i++){
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)){
                break;
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }
}

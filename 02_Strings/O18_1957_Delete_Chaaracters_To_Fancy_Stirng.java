package Strings;


//Example 1:
//
//Input: s = "leeetcode"
//Output: "leetcode"
//Explanation:
//Remove an 'e' from the first group of 'e's to create "leetcode".
//No three consecutive characters are equal, so return "leetcode".

//Example 2:
//
//Input: s = "aaabaaaa"
//Output: "aabaa"
//Explanation:
//Remove an 'a' from the first group of 'a's to create "aabaaaa".
//Remove two 'a's from the second group of 'a's to create "aabaa".
//No three consecutive characters are equal, so return "aabaa".
public class O18_1957_Delete_Chaaracters_To_Fancy_Stirng {

    public static String optimal(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i)){
                count++;
            }else{
                count = 1;
            }

            if(count<3){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "leeetcode";
        System.out.println(optimal(str));
    }
}

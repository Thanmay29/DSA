package Strings;

public class O29_1047_Remove_All_Adjacent_Duplicates_In_String {
    static void main() {
        String s = "abbaca";

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            int len = sb.length();

            if(len>0 && sb.charAt(len-1) == ch){
                sb.deleteCharAt(len-1);
            }else{
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}

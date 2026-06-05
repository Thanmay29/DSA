package Stack;
import java.util.Stack;

public class O01_2390_Removing_Stars_From_A_String {
    public static void main(String[] args) {

        //Input: s = "leet**cod*e"
        //Output: "lecoe"
        //Explanation: Performing the removals from left to right:
        //- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
        //- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
        //- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
        //There are no more stars, so we return "lecoe".
        //Example 2:
        //
        //Input: s = "erase*****"
        //Output: ""
        //Explanation: The entire string is removed, so we return an empty string.
        String s = "leet**cod*e";

        System.out.println("Brute o(n * n)");
        System.out.println(brute(s));

        System.out.println("Optimal using StringBuilder");
        System.out.println(removeStars(s));

        System.out.println("optimal using stack + String Builder");

        //Using stack
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='*'){
                if(!st.empty()){
                    st.pop();
                }
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }

        System.out.println(sb.toString());
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }


    public static String brute(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while(sb.length()>i){
            if(sb.charAt(i) == '*'){
                if(i>0){
                    sb.deleteCharAt(i-1);
                    i--;
                }
                sb.deleteCharAt(i);
                i--;
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}

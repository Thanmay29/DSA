package Strings;

public class O19_1021_Remove_Outermost_Parenthesees {

//    ✅ How it works:
//    Maintain a balance counter for opened parentheses.
//    Only append ( if balance > 0 (so we skip the outermost opening).
//    Only append ) if balance > 0 after decrementing (so we skip the outermost closing).
//    This way, every primitive string has its outer layer removed.

//    Example Run:
//    Input: (()())(())
//    Primitive: (()()) → after removal → ()()
//    Primitive: (()) → after removal → ()
//    Final Answer: ()()() ✅
    public static String removeOuterParentheses(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                if(balance>0){
                    sb.append(c);
                }
                balance++;
            }else{
                balance--;
                if(balance>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println("Input: " + s1 + " -> Output: " + removeOuterParentheses(s1));
        System.out.println("Input: " + s2 + " -> Output: " + removeOuterParentheses(s2));
        System.out.println("Input: " + s3 + " -> Output: " + removeOuterParentheses(s3));
    }
}

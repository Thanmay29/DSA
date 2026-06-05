package Strings;

//return the count to add to make the parentheses equal
//minimum number of parentheses needed to make the input string valid (balanced).

public class O15_921_Valid_Parentheses {
    public static void main(String[] args) {
        String par = "(()))())(";

        System.out.println(validParentheses(par));
    }

    public static int validParentheses(String s){
        int l=0, r=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                l++;
            }else if(s.charAt(i)==')'){
                if(l>0){
                    l--;
                }else{
                    r++;
                }
            }
        }

        return l+r;
    }
}

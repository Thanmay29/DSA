package Stack;
import java.util.Stack;

public class O03_394_Decode_String {

    public static String optimal(String s){
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String currStr = "";
        int k = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10 + (ch-'0');
            }else if(ch == '['){
                num.push(k);
                k = 0;
                str.push(currStr);
                currStr = "";
            }else if(ch == ']'){
                String prevS = str.pop();
                int prevI = num.pop();
                currStr = prevS + currStr.repeat(prevI);
            }else{
                currStr+=ch;
            }
        }

        return currStr;
    }

    public static void main(String[] args) {
        O03_394_Decode_String obj = new O03_394_Decode_String();
        System.out.println("Optimal using stack: ");
        System.out.println(obj.optimal("3[a2[c]]")); // Output: accaccacc

        System.out.println("Brute using recurssion: ");
        System.out.println(brute("3[a2[c]]"));
    }

    public static String brute(String s) {
        return decode(s, 0)[0];
    }

    private static String[] decode(String s, int index) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                String[] decoded = decode(s, index + 1);
                String temp = decoded[0];
                index = Integer.parseInt(decoded[1]);
                result.append(temp.repeat(num));
                num = 0;
            } else if (ch == ']') {
                return new String[] { result.toString(), String.valueOf(index) };
            } else {
                result.append(ch);
            }
            index++;
        }

        return new String[] { result.toString(), String.valueOf(index) };
    }
}

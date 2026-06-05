package Strings;


//Example 1:
//
//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
public class O03_344_Reverse_String {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;

        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

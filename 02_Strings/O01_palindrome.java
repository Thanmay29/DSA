package Strings;

public class O01_palindrome {
    public static void main(String[] args) {
        String input = "aha";
        System.out.println(pal(input));
    }
    public static boolean pal(String input){
        int n = input.length();

        for(int i=0; i<n/2; i++){
            if(input.charAt(i) != input.charAt(n-i-1)){
                return false;
            }
        }
        return true;

    }
}

package DP;

//This problem is not dp it is a different approach (recursion)
public class O29_5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "ababad";

        //Recursion(optimal)
        System.out.println(recur(s));

        //brute(0(n3))//not optimal
        System.out.println(brute(s));
    }

    public static String recur(String s){
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

//----------------------------------------------------------------------------------------------
            //Brute approach

    public static String brute(String s){
        if (s == null || s.length() < 1) return "";

        int len=0, maxLen=0, start=0, n=s.length();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPal(s, i, j)){
                    len = j-i+1;
                    if(len>maxLen){
                        maxLen=len;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }

    public static boolean isPal(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

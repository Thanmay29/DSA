package Sliding_Window;

public class O13_567_Permutation_In_String {

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }

        int size = s1.length();

        for(int i=0; i<size; i++){
            window[s2.charAt(i) - 'a']++;
        }

        if(matches(s1Count, window)) return true;

        for(int i=size; i<s2.length(); i++){
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i-size)-'a']--;

            if(matches(s1Count, window)) return true;
        }
        return false;
    }

    public static boolean matches(int[] a, int[] b){
        for(int i=0; i<26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("adc", "dcda"));    // true
    }
}

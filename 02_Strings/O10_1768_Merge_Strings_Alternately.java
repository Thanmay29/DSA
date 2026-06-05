package Strings;

public class O10_1768_Merge_Strings_Alternately {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }
    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while(i<len1 || j<len2){
            if(i<len1){
                sb.append(word1.charAt(i));
                i++;
            }

            if(j<len2){
                sb.append(word2.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }
}

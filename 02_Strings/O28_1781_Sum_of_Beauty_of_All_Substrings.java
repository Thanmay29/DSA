package Strings;

public class O28_1781_Sum_of_Beauty_of_All_Substrings {
    public static void main(String[] args) {
        //For example, the beauty of "abaacc" is 3 - 1 = 2.

        String s1 = "aabcb"; // o/p 5
        System.out.println(beautySum(s1));
            //Explanation: The substrings with non-zero beauty are
            //["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

        String s2 = "aabcbaa"; // o/p 17
        System.out.println(beautySum(s2));
    }

    public static int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency for substring starting at i

            for (int j = i; j < n; j++) {
                // include character s[j]
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // find max and min freq among characters present (freq > 0)
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                // add beauty
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}

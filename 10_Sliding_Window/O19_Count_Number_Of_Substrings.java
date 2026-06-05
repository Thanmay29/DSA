package Sliding_Window;

import java.util.HashMap;

public class O19_Count_Number_Of_Substrings {
    public static void main(String[] args) {
        String  s1 = "pqpqs"; //Output: 7
        int k1 = 2;
        System.out.println(countSubstrings(s1, k1));
        //Explanation:  All substrings with exactly 2 distinct characters:
        //"pq", "pqp", "pqpq", "qp", "qpq", "pqs", "qs"


        String s2 = "aabcba"; //Output: 5
        int k2 = 3;
        System.out.println(countSubstrings(s2, k2));
    }

    public static int countSubstrings(String s, int k){
        return atMost(s, k) - atMost(s, k-1);
    }

    public static int atMost(String s, int k){
        int n = s.length();
        int count = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right=0; right<n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0)-1);
                if(map.get(leftChar)==0) map.remove(leftChar);
                left++;
            }

            count += right-left+1;
        }
        return count;
    }
}

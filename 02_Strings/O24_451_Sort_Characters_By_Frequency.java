package Strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class O24_451_Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String s1 = "tree"; //output "eert"
        System.out.println(frequencySort(s1));

        String s2 = "cccaaa";// Output: "aaaccc"
        System.out.println(frequencySort(s2));
            // Both 'c' and 'a' appear three times,
            //so both "cccaaa" and "aaaccc" are valid answers.
            //Note that "cacaca" is incorrect, as the same characters must be together.

        String s3 = "Aabb";// Output: "bbAa"
        System.out.println(frequencySort(s3));
            //Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
            //Note that 'A' and 'a' are treated as two different characters.
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char c = pq.poll();
            int freq = map.get(c);

            for(int i=0; i<freq; i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

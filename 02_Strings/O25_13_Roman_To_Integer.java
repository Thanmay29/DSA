package Strings;

import java.util.HashMap;

public class O25_13_Roman_To_Integer {
    public static void main(String[] args) {
        String s1 = "III";// Output: 3
        System.out.println(romanToInt(s1));

        String s2 = "LVIII";// Output: 58
        System.out.println(romanToInt(s2));

        String s3 = "MCMXCIV";// Output: 1994
        System.out.println(romanToInt(s3));
    }

    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            int curr = map.get(s.charAt(i));

            if(i<n-1 && curr<map.get(s.charAt(i+1))){
                sum-=curr;
            }else{
                sum+=curr;
            }
        }
        return sum;
    }
}

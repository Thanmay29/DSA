package Prefix_Sum_Suffix_Kadane;

public class O01_1732_Find_The_Height_Altitude {
    public static void main(String[] args) {
        int[] gains = {-5,1,5,0,-7};

        System.out.println(largestAltitude(gains));
    }

    public static int largestAltitude(int[] gain) {
        int currAlt = 0,maxAlt=0;

        for(int n : gain){
            currAlt+=n;
            maxAlt = Math.max(maxAlt, currAlt);
        }

        return maxAlt;
    }
}

package Recursion;

// Count Digits in a Number
//Pattern: Reduce problem size

public class O04_Count_Digits_In_A_Number {

    public static int countDigits(int n){
        if(n==0) return 1;

        return count(n);
    }

    public static int count(int n){
        if(n==0) return 0;

        return 1 + count(n/10);
    }
    static void main() {
        int n = 10;
        System.out.println(countDigits(n));
    }
}

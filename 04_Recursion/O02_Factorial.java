package Recursion;

//2. Factorial of a Number
//Pattern: Linear recursion

public class O02_Factorial {

    public static int fact(int n){
        if(n==0 || n==1) return 1;

        return n * fact(n-1);
    }
    static void main() {
        int n = 5;
        System.out.println(fact(n));
    }
}

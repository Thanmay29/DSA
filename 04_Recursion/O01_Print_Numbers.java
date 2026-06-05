package Recursion;

//. Print Numbers
//Print 1 to N
//Print N to 1
// Pattern: Basic recursion + base case

public class O01_Print_Numbers {

    public static void recurr(int n){
        if(n==0){
            return;
        }
        recurr(n-1);
        System.out.println(n);
    }
    static void main() {
        int n = 10;
        recurr(n);
    }
}

package Recursion;

//3. Sum of First N Natural Numbers
//Pattern: Accumulation recursion

public class O03_Sum_Of_First_N_Natural_Number {

    public static int sum(int n){
        if (n == 0) {          // base case
            return 0;
        }

        return n + sum(n - 1); // accumulation
    }

    static void main() {
        int n = 10;
        System.out.println(sum(n));
    }
}

package Recursion;

public class O10_50_PowXN {

    public static double pox(double x, int n){
        // Cast n (int) to a long BEFORE negating it.
        // Why: if n == Integer.MIN_VALUE (-2147483648), doing -n on an int
        // overflows because the positive value 2147483648 doesn't fit in an int.
        // Casting to long first gives us room to safely negate it.
        long N = n;

        if(N<0){
            // x^(-n) = (1/x)^n, so if the exponent is negative,
            // invert the base and make the exponent positive instead.
            x=1/x;
            N = -N;
        }

        // Delegate to the recursive helper, now guaranteed N >= 0.
        return Pow(x, N);
    }

    public static double Pow(double x, long n){
        // Base case: anything to the power 0 is 1.
        // This is what eventually stops the recursion.
        if(n==0) return 1.00;

        // Recursive case: compute x^(n/2) first.
        // Integer division floors the result (e.g. 7/2 = 3),
        // so this shrinks the problem to roughly half its size each call.
        double half = Pow(x, n/2);

        if(n%2==0){
            // n is even: x^n = x^(n/2) * x^(n/2)
            return half*half;
        }else{
            // n is odd: n/2 (integer division) lost the remainder 1,
            // so half only represents x^((n-1)/2).
            // Multiply by one extra x to make up the difference.
            return half*half*x;
        }
    }

    // ---- Test cases ----
    public static void main(String[] args) {
        // Basic positive exponent
        System.out.println("2^10 = " + pox(2.0, 10));       // expected 1024.0

        // Odd exponent (exercises the "else" branch)
        System.out.println("2^5 = " + pox(2.0, 5));          // expected 32.0

        // Negative exponent (exercises the x = 1/x branch)
        System.out.println("2^-2 = " + pox(2.0, -2));        // expected 0.25

        // Exponent 0 (immediate base case)
        System.out.println("5^0 = " + pox(5.0, 0));          // expected 1.0

        // Negative base with even exponent -> positive result
        System.out.println("(-2)^3 = " + pox(-2.0, 3));      // expected -8.0

        // Fractional base
        System.out.println("0.5^0 = " + pox(0.5, 0));        // expected 1.0

        // Edge case: Integer.MIN_VALUE exponent
        // This is the classic trap -- negating it directly as an int would overflow.
        System.out.println("1.00001^(-2147483648) = " + pox(1.00001, Integer.MIN_VALUE));
    }
}
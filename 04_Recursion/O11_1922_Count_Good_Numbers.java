package Recursion;

public class O11_1922_Count_Good_Numbers {

    private static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        // Even indices (0, 2, 4, ...) get 5 choices each: {0,2,4,6,8}
        long evenCount = (n + 1) / 2;
        // Odd indices (1, 3, 5, ...) get 4 choices each: {2,3,5,7}
        long oddCount = n / 2;

        // Total = 5^evenCount * 4^oddCount, all mod 1e9+7
        long result = modPow(5, evenCount) * modPow(4, oddCount) % MOD;
        return (int) result;
    }

    // Same fast-power recursion as Pow(x, n), but every multiplication
    // is taken mod MOD so the numbers never blow past long range.
    private static long modPow(long base, long exp) {
        if (exp == 0) return 1L;

        long half = modPow(base, exp / 2);
        long halfSquared = (half * half) % MOD;

        if (exp % 2 == 0) {
            return halfSquared;
        } else {
            return (halfSquared * (base % MOD)) % MOD;
        }
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));   // expected 5
        System.out.println(countGoodNumbers(4));   // expected 400
        System.out.println(countGoodNumbers(50));  // expected 564908303
        System.out.println(countGoodNumbers(1000000000000000L)); // stress test, n = 10^15
    }
}
package Binary_Search.BS_On_Answer;

public class O03_875_Koko_eats_Banana {

    static void main() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Expected: 4

        // extra test cases
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));  // Expected: 30
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));  // Expected: 23
        System.out.println(minEatingSpeed(new int[]{1000000000}, 2));         // Expected: 500000000
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) high = Math.max(high, pile);

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hoursNeeded(piles, mid) <= h) {
                ans = mid;       // mid works, try smaller speed
                high = mid - 1;
            } else {
                low = mid + 1;   // too slow, need faster speed
            }
        }

        return ans;
    }

    static long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // ceil(pile / k)
        }
        return hours;
    }
}
package Binary_Search.BS_On_Answer;

public class O06_774_Minimize_Max_Distance_to_Gas_Station {

    public static double minMaxDist(int[] stations, int k) {
        // Smallest possible max gap is 0 (in theory); we search over real numbers, not integers
        double left = 0, right = 0;

        // Largest possible answer = the biggest existing gap (adding 0 stations leaves it unchanged)
        for (int i = 0; i < stations.length - 1; i++) {
            right = Math.max(right, stations[i + 1] - stations[i]);
        }

        // Precision: stop once the search window is narrower than this
        double e = 1e-6;

        // Keep halving the window until it is tiny (doubles can't use left < right like ints)
        while (right - left > e) {
            // Candidate "maximum allowed gap" to test
            double mid = left + (right - left) / 2;

            if (stationGap(stations, mid, k)) {
                // Using <= k new stations keeps every gap <= mid, so mid works; try a smaller max gap
                right = mid;
            } else {
                // Needs more than k stations, so mid is too small; try a larger max gap
                left = mid;
            }
        }

        // right is the smallest max gap (within 1e-6) that is achievable with k stations
        return right;
    }

    // Returns true if every gap can be reduced to <= gap using at most k new stations
    public static boolean stationGap(int[] stations, double gap, int k) {
        int req = 0; // total new stations needed for this max gap

        for (int i = 0; i < stations.length - 1; i++) {
            // Current distance between two neighbouring stations
            int init = stations[i + 1] - stations[i];

            // Splitting init into pieces of size <= gap needs ceil(init/gap) pieces,
            // which means ceil(init/gap) - 1 new stations in between
            req += (int) Math.ceil(init / gap) - 1;

            // Early exit: already used more than k stations, so this gap is impossible
            if (req > k) return false;
        }

        // Within budget, so this max gap is achievable
        return req <= k;
    }

    public static void main(String[] args) {
        // Each test: stations[], k, expected answer
        int[][] stations = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},                // all gaps are 1
                {3, 6, 12, 19, 33, 44, 67, 72, 76, 84, 87},     // uneven gaps, biggest is 23
                {1, 10}                                         // single gap of 9
        };
        int[] ks = {9, 2, 1};
        double[] expected = {0.5, 11.5, 4.5};

        for (int i = 0; i < stations.length; i++) {
            double actual = minMaxDist(stations[i], ks[i]);
            // Doubles: compare with a tolerance, not ==
            String status = (Math.abs(actual - expected[i]) < 1e-5) ? "PASS" : "FAIL";
            System.out.printf("Test %d: expected=%.2f, actual=%.4f -> %s%n",
                    i + 1, expected[i], actual, status);
        }
    }
}
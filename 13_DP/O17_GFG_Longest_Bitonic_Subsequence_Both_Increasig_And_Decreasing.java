package DP;

public class O17_GFG_Longest_Bitonic_Subsequence_Both_Increasig_And_Decreasing {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 7, 9, 6};

        //Tabulation
        System.out.println(tab(arr));
    }

    //Tabulation
    public static int tab(int[] arr){
        int n = arr.length;
        if (n < 3) return 0; // A valid bitonic sequence needs at least 3 elements

        int[] lis = new int[n]; // Longest Increasing Subsequence (LIS)
        int[] lds = new int[n]; // Longest Decreasing Subsequence (LDS)

        // Step 1: Compute LIS for each index
        for (int i = 0; i < n; i++) {
            lis[i] = 1; // Every element is a subsequence of length 1
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Step 2: Compute LDS for each index (Reverse LIS)
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1; // Every element is a subsequence of length 1
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Step 3: Compute max bitonic subsequence length
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Ensure it has both increasing & decreasing parts
                maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
            }
        }

        return maxLength;
    }
}

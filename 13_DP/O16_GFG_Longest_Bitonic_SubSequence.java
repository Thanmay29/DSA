package DP;

public class O16_GFG_Longest_Bitonic_SubSequence {
    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 5, 7};

        //Tabulation
        tab(arr);
    }

    //Tabulation
    public static void tab(int[] arr){
        int n = arr.length;
        if (n < 3) return; // A valid bitonic sequence needs at least 3 elements

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
        int maxLenLIS = 0;
        int maxLenLDS = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Ensure it has both increasing & decreasing parts
                //Increasing
                maxLenLIS = Math.max(maxLenLIS, lis[i]);

                //Decreasing
                maxLenLDS = Math.max(maxLenLDS, lds[i]);

                //both increasing & decreasing parts
                maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
            }
        }

        System.out.println("Increasing : "+maxLenLIS);
        System.out.println("Decreasing : "+maxLenLDS);

        int max = Math.max(maxLenLIS, maxLenLDS);
        System.out.println("maxLen of maxLenLIS and maxLenLDS : "+max);
        System.out.println("LBS : "+maxLength);
    }
}

package Stack.Implimentation_Problems_Important;

Public class O03_Celebrity_Problem {

    public int celebrity(int[][] M) {

        /*
         * Celebrity Problem
         *
         * M[i][j] = 1  -> Person i knows Person j
         * M[i][j] = 0  -> Person i does NOT know Person j
         *
         * A celebrity satisfies:
         * 1. Knows nobody.          (Entire row = 0)
         * 2. Everyone knows them.   (Entire column = 1 except M[i][i])
         *
         * Optimal Approach:
         *
         * STEP 1:
         * Find one possible celebrity by eliminating impossible people.
         *
         * Rule:
         * If candidate knows i,
         *      candidate cannot be celebrity.
         *      candidate = i
         *
         * Else,
         *      i cannot be celebrity.
         *      Keep current candidate.
         *
         * After N-1 comparisons only one candidate remains.
         *
         * STEP 2:
         * Verify candidate.
         *
         * Check candidate's row:
         *      Should contain only 0's.
         *
         * Check candidate's column:
         *      Everyone except candidate should know them.
         */

        int n = M.length;

        // ---------------- STEP 1 : Find Candidate ----------------

        int candidate = 0;

        for (int i = 1; i < n; i++) {

            // Is current candidate knowing person i ?

            if (M[candidate][i] == 1) {

                // YES
                // Candidate knows someone.
                // Candidate cannot be celebrity.

                candidate = i;
            }

            // ELSE
            // Candidate does not know i.
            // Therefore i cannot be celebrity.
            // Keep current candidate.
        }

        // ---------------- STEP 2 : Verify Candidate Row ----------------

        for (int j = 0; j < n; j++) {

            // Is candidate knowing anyone?

            if (M[candidate][j] == 1) {

                // Celebrity should know nobody.

                return -1;
            }
        }

        // ---------------- STEP 3 : Verify Candidate Column ----------------

        for (int i = 0; i < n; i++) {

            // Ignore self.

            if (i == candidate)
                continue;

            // Does every other person know candidate?

            if (M[i][candidate] == 0) {

                // Someone doesn't know candidate.
                // Hence candidate is not celebrity.

                return -1;
            }
        }

        // Candidate passed both conditions.

        return candidate;
    }
}

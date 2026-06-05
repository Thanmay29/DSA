package Array;

//Question:

//Mathew has a collection of magnets, represented by an integer array A of length X.

//Each element of A corresponds to a magnet,
//and the value of each element represents the magnetic strength of that magnet (My, Mz, M3, and so on, up to Mx).

// He needs to divide these magnets into groups, but there is a catch:
// if the difference between the magnetic strengths of any two magnets is less than Y,
// they will stick together and form an inseparable unit.

//our task is to help Mathew find and
// return an integer value representing the maximum number of magnets that can be added in a single group
// while ensuring that the do not form inseparable units due to a magnetic strength difference less than Y.

//Note: There may be multiple groups formed, and the maximum number of magnets in any group should be considered.

//Input Specification:
//input1: An integer X, representing the total number of magnets.
//input2: An integer Y, representing the minimum difference between the magnetic strengths of any two magnets.
//input3: An integer array A, representing the magnetic strength of each magnet.

import java.util.Arrays;

public class O16_Maximum_Group_Size_Of_Non_Sticking_Magnets {
    public static void main(String[] args) {
//        int[] A = {1, 5, 6, 1, 8, 3, 12, 2, 13, 7, 9, 11};
        int[] A = {1, 5, 6, 1, 8, 3, 12, 2, 13, 7, 9, 11};
        int Y = 3;
        int X = A.length;
        System.out.println("Maximum magnets in a single group: " + maxMagnetGroup(A, X, Y));// output = 3;

// Here, it is stated that the difference between the strengths of each magnet within a group must be at least 4.
// The groups can be built as follows:
//• 1, 5, 12 in the first group, which has a group size of 3.
//• 6, 1, and 13 in the second group, which has a group size of 3.
//• 8, 3, and 7 in the third group, which has a group size of 3.
//Out of these groups, the maximüm number of magnets in a single group is 3.
//Therefore, 3 is returned as the output.
    }

    public static int maxMagnetGroup(int[] A,int X,int Y){
        Arrays.sort(A);
        int max = 0;

        for(int i=0; i<X; i++){

            int prev = A[i];
            int count = 1;
            for(int j=i+1; j<X; j++){
                if(A[j] - prev > Y){
                    count++;
                    prev = A[j];
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

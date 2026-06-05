package Array;

import java.util.Arrays;


//rotate the matrix in 90 degree clock wise
public class O19_48_Rotate_Image_By_90_Degree {
    public static void main(String[] args) {
        O19_48_Rotate_Image_By_90_Degree solution = new O19_48_Rotate_Image_By_90_Degree();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        solution.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void rotate(int[][] matrix){
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap elements across diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //After transpose
        //matrix = [[1, 4, 7],
        //          [2, 5, 8],
        //          [3, 6, 9]]


        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

        //After reverse
        //matrix = [[7, 4, 1]
        //          [8, 5, 2]
        //          [9, 6, 3]]
    }
}

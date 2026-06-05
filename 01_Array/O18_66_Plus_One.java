package Array;

import java.util.Arrays;

public class O18_66_Plus_One {
    public static void main(String[] args) {
        int[] digits = {9};
        //output = {1, 2, 4}
        //123 this is digits increment by one
        //123 + 1 = 124
        //return this as an array {1, 2, 4}

        int[] res = plusOne(digits);
        for(int num : res){
            System.out.print(num+" ");
        }
    }

    public static int[] plusOne(int[] digits){
        int n = digits.length;;

        // Traverse from rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increment if less than 9
                return digits;
            }
            digits[i] = 0; // Set to 0 if it's 9 and continue
        }

        //If no early return happens, then newDigits will be returned at the end.

        //If all were 9, create a new array with an extra digit
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}

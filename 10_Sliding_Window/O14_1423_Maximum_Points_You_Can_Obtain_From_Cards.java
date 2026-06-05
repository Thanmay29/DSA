package Sliding_Window;

public class O14_1423_Maximum_Points_You_Can_Obtain_From_Cards {

//    You are given an array cardPoints and an integer k.
//You can pick exactly k cards.
//The picks can only be from the front or the back of the array.
//Goal → maximize the sum of points.

//Example:
//cardPoints = [1,2,3,4,5,6,1], k=3
//Possible picks:
//First 3 → 1+2+3=6
//Last 3 → 6+1+5=12
//Mix → 1 (front) + 6 + 1 (back) = 8, etc.
//Best choice = 12.
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int total = 0;        // Stores current total of selected cards
        int maxTotal = 0;     // Stores the maximum total found

        // Step 1: Take first 'k' cards from the front and calculate the initial total
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        // Initial case: all k cards taken from the front
        maxTotal = total;

        // Step 2: Slide the window - replace front cards with back cards one by one
        for (int i = 1; i <= k; i++) {
            // Remove the last card from the current front selection
            total -= cardPoints[k - i];
            // Add one card from the back
            total += cardPoints[len - i];

            // Update maxTotal if the current combination gives a better total
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int result = maxScore(cardPoints, k);
        System.out.println("Maximum points you can obtain = " + result);  // Output: 12
    }
}

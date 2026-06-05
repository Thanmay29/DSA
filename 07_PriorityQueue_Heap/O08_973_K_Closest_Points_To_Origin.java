package PriorityQueue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class O08_973_K_Closest_Points_To_Origin {

    // Method to return the k closest points to origin
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap (PriorityQueue with custom comparator)
        // Store points based on descending order of distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(distance(b), distance(a)) // Compare by squared distance
        );

        // Add each point to the heap
        for (int[] point : points) {
            maxHeap.add(point);
            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll(); // Closest points
        }

        return result;
    }

    // Helper method to calculate the squared distance from origin (to avoid using sqrt)
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Main method to test functionality
    public static void main(String[] args) {
        O08_973_K_Closest_Points_To_Origin obj = new O08_973_K_Closest_Points_To_Origin();

        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        System.out.println("Closest " + k1 + " point(s): " + Arrays.deepToString(obj.kClosest(points1, k1)));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        System.out.println("Closest " + k2 + " point(s): " + Arrays.deepToString(obj.kClosest(points2, k2)));
    }
}

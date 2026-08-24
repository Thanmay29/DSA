package PriorityQueue_Heap;

import java.util.LinkedList;
import java.util.Queue;

public class O02_933_Number_Of_Recent_Calls {
    private Queue<Integer> requests; // holds timestamps of calls still within the last 3000ms window

    public O02_933_Number_Of_Recent_Calls() {
        requests = new LinkedList<>(); // initialize empty queue when object is created
    }

    public int ping(int t) {
        requests.offer(t); // add the new call's timestamp to the back of the queue

        while (requests.peek() < t - 3000) { // check the oldest timestamp in the queue
            requests.poll(); // if it's older than (t - 3000), it's outside the window, so remove it
        }
        // loop continues until the front of the queue is within [t-3000, t]

        return requests.size(); // remaining queue size = number of calls within the last 3000ms
    }

    public static void main(String[] args) {
        O02_933_Number_Of_Recent_Calls recentCounter = new O02_933_Number_Of_Recent_Calls();
        System.out.println(recentCounter.ping(1));     // queue=[1], window=[-2999,1], size=1 → Output: 1
        System.out.println(recentCounter.ping(100));   // queue=[1,100], window=[-2900,100], size=2 → Output: 2
        System.out.println(recentCounter.ping(3001));  // queue=[1,100,3001], window=[1,3001], 1 stays (1>=1), size=3 → Output: 3
        System.out.println(recentCounter.ping(3002));  // queue=[1,100,3001,3002], window=[2,3002], 1 removed (1<2), size=3 → Output: 3
    }
}
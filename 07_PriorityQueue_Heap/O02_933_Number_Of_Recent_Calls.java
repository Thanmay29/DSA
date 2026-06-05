package PriorityQueue_Heap;

import java.util.LinkedList;
import java.util.Queue;

public class O02_933_Number_Of_Recent_Calls {
private Queue<Integer> requests;
    public O02_933_Number_Of_Recent_Calls() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);

        while(requests.peek() < t-3000){
            requests.poll();
        }

        return requests.size();
    }

    public static void main(String[] args) {
        O02_933_Number_Of_Recent_Calls recentCounter = new O02_933_Number_Of_Recent_Calls();
        System.out.println(recentCounter.ping(1));     // Output: 1
        System.out.println(recentCounter.ping(100));   // Output: 2
        System.out.println(recentCounter.ping(3001));  // Output: 3
        System.out.println(recentCounter.ping(3002));  // Output: 3
    }
}

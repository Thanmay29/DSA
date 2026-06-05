package PriorityQueue_Heap;


////add() or offer() inserts an element.
////
////peek() returns the top without removing it.
////
////poll() returns and removes the top element.
////
////Time Complexity:
////
////Insert: O(log n)
////
////Remove: O(log n)
////
////Peek: O(1)
class MinHeap {
    int[] heap;
    int size;

    public MinHeap(int cap) {
        heap = new int[cap];
        size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public void add(int val) {
        if (size == heap.length) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = val;
        int i = size++;

        // Bubble up
        while (i > 0 && heap[i] < heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int poll() {
        if (size == 0) return -1;

        int min = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }

    public int peek() {
        if (size == 0) return -1;
        return heap[0];
    }

    private void heapify(int i) {
        int smallest = i;
        int l = left(i), r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class O13_MinHeap_Implmentation_Using_Array {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(8);

        System.out.print("Heap: ");
        minHeap.printHeap(); // internal structure

        System.out.println("Peek: " + minHeap.peek()); // 5
        System.out.println("Poll: " + minHeap.poll()); // 5
        minHeap.printHeap(); // Updated heap
    }
}

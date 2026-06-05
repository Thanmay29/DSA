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
class MaxHeap{
    int[] heap;
    int size;

    public MaxHeap(int cap){
        heap = new int[cap];
        size = 0;
    }

    private int parent(int i){return (i-1)/2; }
    private int leftChild (int i){return 2*i+1; }
    private int rightChild(int i){return 2*i+2; }

    public void add(int val){
        if(size== heap.length) throw new RuntimeException("Heap is full");
        heap[size] = val;
        int i = size;
        size++;

        while(i>0 && heap[i]>heap[parent(i)]){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int peek(){
        if(size==0) throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    public int poll(){
        if(size==0) throw new RuntimeException("Heap is empty");
        int val= heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return val;
    }

    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}


public class O14_MaxHeap_Implmentation_Using_Array {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(15);
        maxHeap.add(8);

        System.out.print("Heap: ");
        maxHeap.printHeap(); // Internal structure

        System.out.println("Peek: " + maxHeap.peek()); // 20
        System.out.println("Poll: " + maxHeap.poll()); // 20
        maxHeap.printHeap(); // After removal
    }
}

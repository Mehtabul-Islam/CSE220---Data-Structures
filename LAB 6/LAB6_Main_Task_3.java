import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // 1-based indexing
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int value) {
        if (size >= capacity) return;
        size++;
        heap[size] = value;
        heapifyUp(size);
    }

    private void heapifyUp(int index) {
        while (index > 1) {
            int parentIndex = index / 2;
            if (heap[index] < heap[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    public Integer extractMin() {
        if (isEmpty()) return null;
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        if (size > 1) heapifyDown(1);
        return min;
    }

    private void heapifyDown(int index) {
        while (true) {
            int smallest = index;
            int left = 2 * index;
            int right = 2 * index + 1;
            if (left <= size && heap[left] < heap[smallest]) smallest = left;
            if (right <= size && heap[right] < heap[smallest]) smallest = right;
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Task 3: Static method for out-of-place heapsort.
     */
    public static void outPlaceHeapsort(int[] arr) {
        // 1. Create a Min-Heap instance
        MinHeap sortHeap = new MinHeap(arr.length);

        // 2. Loop through the given array and insert each element
        for (int val : arr) {
            sortHeap.insert(val);
        }

        // 3. Loop until the Min-Heap is empty and put elements in sorted order
        int i = 0;
        while (!sortHeap.isEmpty()) {
            arr[i] = sortHeap.extractMin();
            i++;
        }
    }
}
public class LAB6_Main_Task_3 {
    public static void main(String[] args) {
        int[] data = {50, 10, 40, 20, 30};
        
        System.out.println("Original Array: " + Arrays.toString(data));

        // Perform static heapsort
        MinHeap.outPlaceHeapsort(data);

        System.out.println("Sorted Array (MinHeap): " + Arrays.toString(data));
        // Expected: [10, 20, 30, 40, 50]
    }
}

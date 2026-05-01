import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Helper for Task 4: Initialize heap with m machines having 0 load
    public void initializeWithZeros(int m) {
        for (int i = 0; i < m; i++) {
            this.insert(0);
        }
    }

    public void insert(int value) {
        if (size == heap.length) return;
        heap[size] = value;
        swim(size);
        size++;
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public int extractMin() {
        if (size == 0) return -1;
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);
        return min;
    }

    private void sink(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            sink(smallest);
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int[] getHeapArray() {
        return Arrays.copyOf(heap, size);
    }
}
public class LAB6_Assignment_Task_1 {
    public static int[] distributeTasks(int[] tasks, int m) {
        MinHeap machineHeap = new MinHeap(m);
        
        // 1. Initialize heap with m machines, all set to 0 load
        machineHeap.initializeWithZeros(m);

        // 2. For each task, extract smallest load, update, and re-insert
        for (int taskTime : tasks) {
            int smallestLoad = machineHeap.extractMin();
            int updatedLoad = smallestLoad + taskTime;
            machineHeap.insert(updatedLoad);
        }

        // 3. The final array representation of the heap is the answer
        return machineHeap.getHeapArray();
    }

    public static void main(String[] args) {
        // Sample Input from Image
        int[] tasks = {2, 4, 7, 1, 6};
        int m = 4;

        System.out.println("Input Tasks: " + Arrays.toString(tasks));
        System.out.println("Number of Machines: " + m);

        int[] result = distributeTasks(tasks, m);

        System.out.println("Machine Loads (Final Heap Array): " + Arrays.toString(result));
        // Expected Sample Output: [2, 4, 7, 7]
    }
}

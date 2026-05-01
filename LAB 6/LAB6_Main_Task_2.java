class MaxHeap {
    // Instance variables must be Private as per Task 2 requirements
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // Using 1-based indexing
        this.heap = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return heap[1]; // In a MaxHeap, the largest element is at the root
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }
        size++;
        heap[size] = value;
        heapifyUp(size);
    }

    private void heapifyUp(int index) {
        // Compare with parent and swap if current element is LARGER
        while (index > 1) {
            int parentIndex = index / 2;
            if (heap[index] > heap[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Renamed from extractMin() to extractMax() as per Task 2 requirements
    public Integer extractMax() {
        if (isEmpty()) return null;

        int max = heap[1];
        heap[1] = heap[size];
        size--;

        if (size > 0) {
            heapifyDown(1);
        }
        return max;
    }

    private void heapifyDown(int index) {
        while (true) {
            int largest = index;
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;

            // Compare with children and find the LARGEST among them
            if (leftChild <= size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }
            if (rightChild <= size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
public class LAB6_Main_Task_2 {
    public static void main(String[] args) {
        MaxHeap myMaxHeap = new MaxHeap(10);

        System.out.println("--- Task 2: Max Heap Execution ---");

        int[] values = {10, 20, 5, 30, 15};
        for (int val : values) {
            System.out.println("Inserting: " + val);
            myMaxHeap.insert(val);
        }

        System.out.println("\nLargest element (peek): " + myMaxHeap.peek()); // Expected: 30

        System.out.println("\nExtracting elements (should be in descending order):");
        while (!myMaxHeap.isEmpty()) {
            System.out.print(myMaxHeap.extractMax() + " ");
        }
        // Expected Output: 30 20 15 10 5

        System.out.println("\n\nIs heap empty? " + myMaxHeap.isEmpty());
    }
}

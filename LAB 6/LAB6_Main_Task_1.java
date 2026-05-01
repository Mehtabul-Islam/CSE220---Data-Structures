class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor based on requirements in image_4d099e.png
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 1-based index requires capacity + 1
        this.heap = new int[capacity + 1];
    }

    // Returns True if the heap size is 0
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the smallest element (root) without removing it
    public Integer peek() {
        if (isEmpty()) return null;
        return heap[1]; 
    }

    public void insert(int value) {
        // 1. Check if the heap is full
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }
        // 2. Insert value at the end of the array
        size++;
        heap[size] = value;
        // 3. Restore heap property
        heapifyUp(size);
    }

    private void heapifyUp(int index) {
        // 1. Compare current element with its parent
        // 2. If parent is greater, swap them
        while (index > 1) {
            int parentIndex = index / 2;
            if (heap[index] < heap[parentIndex]) {
                swap(index, parentIndex);
                // 3. Continue until heap property is satisfied or root reached
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public Integer extractMin() {
        // 1. If heap is empty, return null
        if (isEmpty()) return null;

        // 2. Store root value heap[1] to return
        int min = heap[1];
        // 3. Move last element to root position
        heap[1] = heap[size];
        // 4. Decrease size
        size--;

        // 5. Restore heap property using heapifyDown
        if (size > 0) {
            heapifyDown(1);
        }
        // 6. Return stored minimum value
        return min;
    }

    private void heapifyDown(int index) {
        while (true) {
            int smallest = index;
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;

            // 1. Compare current element with its children
            if (leftChild <= size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }
            if (rightChild <= size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            // 2. Swap with smallest child if needed
            if (smallest != index) {
                swap(index, smallest);
                // 3. Continue until property is satisfied or reached leaf
                index = smallest;
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
public class LAB6_Main_Task_1 {
    public static void main(String[] args) {
        // Initialize heap with capacity 10
        MinHeap myHeap = new MinHeap(10);

        System.out.println("--- Task 1: Min Heap Execution ---");
        
        // Testing insert(value)
        int[] valuesToInsert = {20, 15, 30, 5, 10};
        for (int val : valuesToInsert) {
            System.out.println("Inserting: " + val);
            myHeap.insert(val);
        }

        // Testing peek()
        System.out.println("\nSmallest element (peek): " + myHeap.peek()); // Expected: 5

        // Testing extractMin()
        System.out.println("\nExtracting all elements in order:");
        while (!myHeap.isEmpty()) {
            System.out.print(myHeap.extractMin() + " "); 
        }
        // Expected Output: 5 10 15 20 30 
        
        System.out.println("\n\nIs heap empty? " + myHeap.isEmpty());
    }
}

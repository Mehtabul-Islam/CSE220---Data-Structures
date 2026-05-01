import java.util.Arrays;

// 1. Define a class to hold both the task name and its priority
class TaskNode {
    String name;
    int priority;

    public TaskNode(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

// 2. Build a customized Max-Heap for TaskNodes
class CustomMaxHeap {
    private TaskNode[] heap;
    private int size;

    public CustomMaxHeap(int capacity) {
        heap = new TaskNode[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(TaskNode task) {
        if (size == heap.length) return;
        heap[size] = task;
        swim(size);
        size++;
    }

    // Swim compares based on the priority value
    private void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index].priority > heap[parent].priority) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public TaskNode extractMax() {
        if (isEmpty()) return null;
        TaskNode maxTask = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);
        return maxTask; // Returns the whole node, containing name and priority
    }

    // Sink compares based on the priority value
    private void sink(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIdx = index;

        if (left < size && heap[left].priority > heap[maxIdx].priority) {
            maxIdx = left;
        }
        if (right < size && heap[right].priority > heap[maxIdx].priority) {
            maxIdx = right;
        }

        if (maxIdx != index) {
            swap(index, maxIdx);
            sink(maxIdx);
        }
    }

    private void swap(int a, int b) {
        TaskNode temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
public class LAB6_Assignment_Task_3 {
    public static String[] scheduleTasks(String[] taskNames, int[] priorities) {
        int n = taskNames.length;
        
        // Step 1: Create a Custom Max-Heap instance
        CustomMaxHeap priorityQueue = new CustomMaxHeap(n);

        // Step 2: Iterate through both arrays simultaneously and insert
        for (int i = 0; i < n; i++) {
            TaskNode newTask = new TaskNode(taskNames[i], priorities[i]);
            priorityQueue.insert(newTask);
        }

        // Step 3: Extract the maximum repeatedly until heap is empty
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            // Extract the node, and store only its name in the result array
            result[i] = priorityQueue.extractMax().name;
        }

        // Step 4: Return the result array
        return result;
    }

    public static void main(String[] args) {
        // Sample Input from the assignment
        String[] taskNames = {"Email", "Meeting", "Code Review", "Lunch", "Debug"};
        int[] priorities = {2, 5, 3, 1, 4};

        System.out.println("Tasks: " + Arrays.toString(taskNames));
        System.out.println("Priorities: " + Arrays.toString(priorities));

        // Execution
        String[] sortedTasks = scheduleTasks(taskNames, priorities);

        // Output formatting
        System.out.println("\nSample Returned Priorities Array:");
        System.out.println(Arrays.toString(sortedTasks));
        
        // Expected Output: ["Meeting", "Debug", "Code Review", "Email", "Lunch"]
    }
}

class ArrayQueue {
    // Four private instance variables as requested
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize the queue with a specific capacity
    public ArrayQueue(int capacity) {
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Inserts an element at the rear of the queue
    public void enqueue(Object element) {
        // Check if the queue is full (overflow condition)
        if (size == queue.length) {
            System.out.println("queue overflow");
            return;
        }
        
        // Insert the element at the current rear position
        queue[rear] = element;
        
        // Increment rear circularly using modulo
        rear = (rear + 1) % queue.length;
        
        // Increase the size
        size++;
    }

    // Removes and returns the front element of the queue
    public Object dequeue() {
        // Check if the queue is empty (underflow condition)
        if (isEmpty()) {
            System.out.println("queue underflow");
            return null; 
        }
        
        // Retrieve the front element
        Object dequeuedElement = queue[front];
        
        // Optional but good practice: clear the reference
        queue[front] = null;
        
        // Increment front circularly using modulo (fixes the typo in the prompt's description)
        front = (front + 1) % queue.length;
        
        // Decrease the size
        size--;
        
        return dequeuedElement;
    }

    // Returns the front element without removing it
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    // Returns true if the queue contains no elements, otherwise false
    public boolean isEmpty() {
        return size == 0;
    }
}
public class LAB4_Part2_Intro_Task2 {
    public static void main(String[] args) {
        System.out.println("=== Testing ArrayQueue (Circular Array Implementation) ===\n");
        
        // Initialize a queue of size 3
        ArrayQueue myQueue = new ArrayQueue(3);
        
        System.out.println("1. Is queue empty? " + myQueue.isEmpty()); // Expected: true
        
        System.out.println("\n2. Enqueuing 10, 20, 30...");
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        
        System.out.println("3. Is queue empty? " + myQueue.isEmpty()); // Expected: false
        System.out.println("4. Peek front element: " + myQueue.peek());   // Expected: 10
        
        System.out.println("\n5. Enqueuing 40 to trigger overflow...");
        myQueue.enqueue(40); // Expected: queue overflow
        
        System.out.println("\n6. Dequeuing elements...");
        System.out.println("Dequeued: " + myQueue.dequeue()); // Expected: 10
        System.out.println("Dequeued: " + myQueue.dequeue()); // Expected: 20
        
        System.out.println("\n7. Peek current front: " + myQueue.peek()); // Expected: 30
        
        System.out.println("\n8. Testing circular behavior (Enqueueing 40 and 50)...");
        myQueue.enqueue(40); // Should wrap around to index 0
        myQueue.enqueue(50); // Should wrap around to index 1
        System.out.println("Peek current front: " + myQueue.peek()); // Expected: 30
        
        System.out.println("\n9. Emptying the queue completely...");
        System.out.println("Dequeued: " + myQueue.dequeue()); // Expected: 30
        System.out.println("Dequeued: " + myQueue.dequeue()); // Expected: 40
        System.out.println("Dequeued: " + myQueue.dequeue()); // Expected: 50
        
        System.out.println("\n10. Dequeuing from empty queue to trigger underflow...");
        Object result = myQueue.dequeue(); // Expected: queue underflow
        System.out.println("Result returned: " + result); // Expected: null
    }
}

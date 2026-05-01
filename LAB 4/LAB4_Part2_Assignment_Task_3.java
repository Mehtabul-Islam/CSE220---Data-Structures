import java.util.LinkedList;
class Dancer {
    String name;
    char gender;
    int id;

    public Dancer(String name, char gender, int id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String toString() {
        return name + "(" + gender + "-" + id + ")";
    }
}
class LinkedListStack {
    LinkedList<Object> list = new LinkedList<>();

    public void push(Object obj) {
        list.addFirst(obj);
    }

    public Object pop() {
        return list.removeFirst();
    }

    public Object peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
class LinkedListQueue {
    LinkedList<Object> list = new LinkedList<>();

    public void enqueue(Object obj) {
        list.addLast(obj);
    }

    public Object dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class LAB4_Part2_Assignment_Task_3 {
    public static void dance_pair(LinkedListStack dancerStack) {

        LinkedListQueue maleQueue = new LinkedListQueue();
        LinkedListQueue femaleQueue = new LinkedListQueue();
        int pairCount = 1;

        while (!dancerStack.isEmpty()) {

            Dancer first = (Dancer) dancerStack.pop();

            // If only one dancer remains
            if (dancerStack.isEmpty()) {
                if (first.gender == 'M') {
                    if (!femaleQueue.isEmpty()) {
                        Dancer f = (Dancer) femaleQueue.dequeue();
                        System.out.println("#" + (pairCount++) + " " + f + " & " + first);
                    } else {
                        maleQueue.enqueue(first);
                    }
                } else {
                    femaleQueue.enqueue(first);
                }
                break;
            }

            Dancer second = (Dancer) dancerStack.pop();

            // Case 1: opposite genders → immediate pair
            if (first.gender != second.gender) {
                System.out.println("#" + (pairCount++) + " " + first + " & " + second);
            }

            // Case 2: F F
            else if (first.gender == 'F' && second.gender == 'F') {
                femaleQueue.enqueue(first);
                dancerStack.push(second);
            }

            // Case 3: M M
            else if (first.gender == 'M' && second.gender == 'M') {

                if (!femaleQueue.isEmpty()) {
                    Dancer f = (Dancer) femaleQueue.dequeue();
                    System.out.println("#" + (pairCount++) + " " + f + " & " + first);
                } else {
                    maleQueue.enqueue(first);
                }

                dancerStack.push(second);
            }
        }

        // Final pairing
        while (!maleQueue.isEmpty() && !femaleQueue.isEmpty()) {
            Dancer f = (Dancer) femaleQueue.dequeue();
            Dancer m = (Dancer) maleQueue.dequeue();
            System.out.println("#" + (pairCount++) + " " + f + " & " + m);
        }

        // Remaining females
        if (!femaleQueue.isEmpty()) {
            System.out.print("\nUnpaired Female: ");
            while (!femaleQueue.isEmpty()) {
                System.out.print(femaleQueue.dequeue());
                if (!femaleQueue.isEmpty()) System.out.print(", ");
            }
            System.out.println();
        }

        // Remaining males
        if (!maleQueue.isEmpty()) {
            System.out.print("\nUnpaired Male: ");
            while (!maleQueue.isEmpty()) {
                System.out.print(maleQueue.dequeue());
                if (!maleQueue.isEmpty()) System.out.print(", ");
            }
            System.out.println();
        }
    }
}

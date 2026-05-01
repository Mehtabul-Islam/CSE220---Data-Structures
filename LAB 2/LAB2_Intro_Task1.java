class Node {
    Object elem;
    Node next;

    // Constructor that takes one Object parameter
    public Node(Object elem) {
        this.elem = elem;
    }
}
public class LAB2_Intro_Task1 {
    public static void main(String[] args) {
        
        // 1. Create 5 different objects of Node class and assign values
        Node n1 = new Node("Hello");
        Node n2 = new Node(324);
        Node n3 = new Node(8.97);
        Node n4 = new Node("Python");
        Node n5 = new Node("Java");

        // 2. Connect the 5 nodes as shown in the illustration
        n4.next = n5;
        n5.next = n2;
        n2.next = n3;
        n3.next = n1;
        n1.next = n5;

        System.out.println("=== Intro Node Tasks Execution & Error Tracing ===\n");

        // ROW 1 & 2
        System.out.println("Code: System.out.println( n1 );");
        System.out.println("Output: " + n1 + " (Memory reference of n1 node)\n");

        System.out.println("Code: System.out.println( n3.next );");
        System.out.println("Output: " + n3.next + " (Memory reference of n1 node, as n3.next points to it)\n");

        // ROW 3
        System.out.println("Code: System.out.println( n3.next.elem );");
        System.out.println("Output: " + n3.next.elem + "\n");

        // ROW 4
        Node x = n4.next;
        System.out.println("Code: Node x = n4.next;");
        System.out.println("Code: System.out.println( n1.elem + x.elem );");
        System.out.println("-> ERROR: Compile-time error. The '+' operator cannot be applied to 'Object' and 'Object'.");
        System.out.println("-> FIX: Cast the objects to String (since they hold strings) to concatenate.");
        System.out.println("-> Fixed Output: " + (String)n1.elem + (String)x.elem + "\n");

        // ROW 5
        x.next = n3;
        System.out.println("Code: x.next = n3;");
        System.out.println("Code: System.out.println(n2.next.next + n5.next);");
        System.out.println("-> ERROR: Compile-time error. The '+' operator cannot be applied to 'Node' and 'Node'.");
        System.out.println("-> FIX: Concatenate with an empty string to safely print their memory references.");
        System.out.println("-> Fixed Output: " + n2.next.next + " and " + n5.next + "\n");

        // ROW 6
        n5 = null;
        System.out.println("Code: n5 = null;");
        System.out.println("Code: System.out.println( n4.next.elem );");
        System.out.println("Output: " + n4.next.elem + " (n4.next still safely references the 'Java' node object in memory, even if the variable n5 was wiped)\n");

        // ROW 7
        x.next.next = null;
        System.out.println("Code: x.next.next = null;");
        System.out.println("Code: n3.next.elem = 321;");
        System.out.println("-> ERROR: Runtime NullPointerException. 'x' is the Java node, its next is n3. Setting x.next.next = null makes n3.next = null. Accessing .elem on a null reference crashes the program.");
        System.out.println("-> FIX: Instantiate a new Node before assigning an element to it.");
        n3.next = new Node(null); 
        n3.next.elem = 321;
        System.out.println("-> Fixed Code Executed: n3.next = new Node(null); n3.next.elem = 321;\n");

        // ROW 8
        System.out.println("Code: n4.next = 532;");
        System.out.println("-> ERROR: Compile-time Type Mismatch error. Cannot directly convert an 'int' to a 'Node'.");
        System.out.println("-> FIX: Create a new Node instance containing 532.");
        n4.next = new Node(532); 
        System.out.println("Code: System.out.println(n4.next.elem);");
        System.out.println("-> Fixed Output: " + n4.next.elem + "\n");
    }
}


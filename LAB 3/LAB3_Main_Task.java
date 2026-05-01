class Patient {
    int id;
    String name;
    int age;
    String bloodGroup;
    
    // Pointers for Doubly Linked List
    Patient next;
    Patient prev;

    // Constructor for actual patients
    public Patient(int id, String name, int age, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
    }

    // Constructor for the Dummy Head
    public Patient() {
        this.id = -1; // Dummy values
        this.name = "Dummy";
        this.next = this; // Points to itself initially
        this.prev = this; // Points to itself initially
    }
}

// 2. WRM Class (Acts as the Dummy Headed Doubly Circular Linked List)
class WRM {
    Patient dummyHead;

    public WRM() {
        // Initialize the dummy head
        dummyHead = new Patient();
    }

    // a. Register a new patient (Insert at the end / Tail)
    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newPatient = new Patient(id, name, age, bloodgroup);
        
        // Find the current tail (which is dummyHead.prev)
        Patient tail = dummyHead.prev;

        // Wire the new patient into the circular list
        newPatient.next = dummyHead;
        newPatient.prev = tail;
        
        // Update the old tail and the dummy head to point to the new patient
        tail.next = newPatient;
        dummyHead.prev = newPatient;
        
        System.out.println("Success: Patient '" + name + "' registered successfully.");
    }

    // b. Serve a patient (Remove from the front / Head.next)
    public void servePatient() {
        if (dummyHead.next == dummyHead) {
            System.out.println("No patients waiting to be served.");
            return;
        }
        
        // The patient to be served is the first one in line
        Patient serving = dummyHead.next;
        System.out.println("Serving Patient: " + serving.name + " (ID: " + serving.id + ")");

        // Remove the served patient from the list
        dummyHead.next = serving.next;
        serving.next.prev = dummyHead;
    }

    // c. Cancel all appointments
    public void cancelAll() {
        // Reset the dummy head to point to itself
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
        System.out.println("All appointments canceled. The doctor has gone to lunch.");
    }

    // d. Check if the doctor can go home
    public boolean canDoctorGoHome() {
        // Returns true if the list is empty (only the dummy head remains)
        return dummyHead.next == dummyHead;
    }

    // e. Show all waiting patients' IDs
    public void showAllPatient() {
        if (dummyHead.next == dummyHead) {
            System.out.println("Waiting Room is empty.");
            return;
        }
        
        Patient current = dummyHead.next;
        System.out.print("Waiting Patients (IDs): ");
        while (current != dummyHead) {
            System.out.print(current.id + " ");
            current = current.next;
        }
        System.out.println();
    }

    // f. Reverse the patient line
    public void reverseTheLine() {
        if (dummyHead.next == dummyHead || dummyHead.next.next == dummyHead) {
            System.out.println("Not enough patients to reverse the line.");
            return;
        }

        Patient current = dummyHead;
        
        // Traverse the entire circular list and swap next/prev for every node
        do {
            Patient temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            // Move to the next node in the original sequence 
            // (which is now current.prev because we just swapped them)
            current = current.prev;
        } while (current != dummyHead);
        
        System.out.println("Success: The waiting line has been reversed.");
    }
}
public class LAB3_Main_Task {
    public static void main(String[] args) {
        WRM hospitalWRM = new WRM();

        System.out.println("=== Hospital Waiting Room System Started ===\n");

        // Test registering patients
        hospitalWRM.registerPatient(101, "Alice", 25, "O+");
        hospitalWRM.registerPatient(102, "Bob", 30, "A-");
        hospitalWRM.registerPatient(103, "Charlie", 45, "B+");
        hospitalWRM.registerPatient(104, "Diana", 22, "AB+");
        
        System.out.println("\n--- Checking Status ---");
        hospitalWRM.showAllPatient();
        System.out.println("Can doctor go home? " + hospitalWRM.canDoctorGoHome());

        System.out.println("\n--- Serving Patients ---");
        hospitalWRM.servePatient(); // Serves Alice
        hospitalWRM.showAllPatient();

        System.out.println("\n--- Reversing the Line ---");
        hospitalWRM.reverseTheLine();
        hospitalWRM.showAllPatient(); // Should now be Diana -> Charlie -> Bob

        System.out.println("\n--- Serving after Reversal ---");
        hospitalWRM.servePatient(); // Serves Diana

        System.out.println("\n--- Canceling All ---");
        hospitalWRM.cancelAll();
        hospitalWRM.showAllPatient();
        System.out.println("Can doctor go home? " + hospitalWRM.canDoctorGoHome());
    }
}

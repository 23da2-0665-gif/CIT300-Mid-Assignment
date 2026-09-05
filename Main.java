public class Main {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("==========================================");

        // ==============================
        // 1. PATIENT RECORDS - BST
        // ==============================

        System.out.println("\n=== 1. PATIENT RECORDS (BST) ===");

        BST patientBST = new BST();

        Patient patient1 = new Patient(
            103, "Aisha", 25, "0771234567", "Fever"
        );

        Patient patient2 = new Patient(
            101, "Sara", 30, "0777654321", "Asthma"
        );

        Patient patient3 = new Patient(
            105, "Hana", 40, "0712345678", "Diabetes"
        );

        patientBST.insert(patient1);
        patientBST.insert(patient2);
        patientBST.insert(patient3);

        System.out.println("\nAll Patients (Ascending Patient ID):");
        patientBST.displayInOrder();

        System.out.println("\nSearching for Patient ID 103:");
        Patient foundPatient = patientBST.search(103);

        if (foundPatient != null) {
            System.out.println("Patient Found: " + foundPatient.patientName);
        } else {
            System.out.println("Patient Not Found.");
        }

        patientBST.delete(101);

        System.out.println("\nAfter deleting Patient ID 101:");
        patientBST.displayInOrder();


        // ==============================
        // 2. EMERGENCY QUEUE
        // ==============================

        System.out.println("\n=== 2. EMERGENCY PATIENT QUEUE ===");

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.enqueue(patient1);
        emergencyQueue.enqueue(patient2);
        emergencyQueue.enqueue(patient3);

        System.out.println("\nPatients Waiting:");
        emergencyQueue.displayQueue();

        System.out.println("\nCalling next patient:");
        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {
            System.out.println("Now treating: " + nextPatient.patientName);
        }

        System.out.println("\nQueue after dequeue:");
        emergencyQueue.displayQueue();


        // ==============================
        // 3. TREATMENT STACK
        // ==============================

        System.out.println("\n=== 3. TREATMENT HISTORY (STACK) ===");

        TreatmentStack treatmentStack = new TreatmentStack();

        treatmentStack.push(
            "Aisha - Fever - Medication given"
        );

        treatmentStack.push(
            "Sara - Asthma - Inhaler treatment"
        );

        treatmentStack.push(
            "Hana - Diabetes - Insulin treatment"
        );

        System.out.println("\nCompleted Treatments:");
        treatmentStack.displayStack();

        System.out.println("\nRemoving most recent treatment:");
        treatmentStack.pop();

        System.out.println("\nTreatment History after pop:");
        treatmentStack.displayStack();


        // ==============================
        // 4. PATIENT VISIT HISTORY
        // ==============================

        System.out.println("\n=== 4. PATIENT VISIT HISTORY ===");

        VisitHistory visitHistory = new VisitHistory();

        visitHistory.addVisit(
            1,
            "2026-08-20",
            "Dr. Ahmed",
            "Fever",
            "Medication"
        );

        visitHistory.addVisit(
            2,
            "2026-08-25",
            "Dr. Sara",
            "Asthma",
            "Inhaler treatment"
        );

        visitHistory.addVisit(
            3,
            "2026-09-01",
            "Dr. Hana",
            "Diabetes",
            "Insulin treatment"
        );

        System.out.println("\nVisit History:");
        visitHistory.displayVisits();

        System.out.println("\nSearching for Visit ID 2:");
        visitHistory.searchVisit(2);

        System.out.println("\nRemoving Visit ID 1:");
        visitHistory.removeVisit(1);

        System.out.println("\nVisit History after removal:");
        visitHistory.displayVisits();


        // ==============================
        // END
        // ==============================

        System.out.println("\n==========================================");
        System.out.println("       PROGRAM COMPLETED SUCCESSFULLY");
        System.out.println("==========================================");
    }
}
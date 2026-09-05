import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    private Queue<Patient> waitingQueue = new LinkedList<>();

    // Add patient to queue
    public void enqueue(Patient patient) {
        waitingQueue.add(patient);
        System.out.println(patient.patientName + " added to emergency queue.");
    }

    // Remove next patient
    public Patient dequeue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = waitingQueue.poll();
        System.out.println(patient.patientName + " is removed for treatment.");
        return patient;
    }

    // Display waiting patients
    public void displayQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No patients are waiting.");
            return;
        }

        System.out.println("=== Emergency Waiting Queue ===");

        for (Patient patient : waitingQueue) {
            System.out.println(
                "ID: " + patient.patientId +
                " | Name: " + patient.patientName +
                " | Condition: " + patient.medicalCondition
            );
        }
    }
}
public class VisitHistory {

    // Node for the singly linked list
    class VisitNode {
        int visitId;
        String visitDate;
        String doctorName;
        String diagnosis;
        String treatment;
        VisitNode next;

        VisitNode(int visitId, String visitDate, String doctorName,
                  String diagnosis, String treatment) {
            this.visitId = visitId;
            this.visitDate = visitDate;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
            this.next = null;
        }
    }

    private VisitNode head;

    // Add a new visit
    public void addVisit(int visitId, String visitDate, String doctorName,
                         String diagnosis, String treatment) {

        VisitNode newVisit = new VisitNode(
            visitId, visitDate, doctorName, diagnosis, treatment
        );

        if (head == null) {
            head = newVisit;
        } else {
            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newVisit;
        }

        System.out.println("Visit added successfully.");
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null &&
               current.next.visitId != visitId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    // Search for a visit
    public void searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visitId == visitId) {
                System.out.println("Visit Found!");
                System.out.println("Visit ID: " + current.visitId);
                System.out.println("Date: " + current.visitDate);
                System.out.println("Doctor: " + current.doctorName);
                System.out.println("Diagnosis: " + current.diagnosis);
                System.out.println("Treatment: " + current.treatment);
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Display all visits
    public void displayVisits() {

        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("=== Patient Visit History ===");

        VisitNode current = head;

        while (current != null) {

            System.out.println(
                "Visit ID: " + current.visitId +
                " | Date: " + current.visitDate +
                " | Doctor: " + current.doctorName +
                " | Diagnosis: " + current.diagnosis +
                " | Treatment: " + current.treatment
            );

            current = current.next;
        }
    }
}
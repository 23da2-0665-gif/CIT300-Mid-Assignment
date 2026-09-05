import java.util.Stack;

public class TreatmentStack {

    private Stack<String> treatmentHistory = new Stack<>();

    // Add completed treatment
    public void push(String treatmentRecord) {
        treatmentHistory.push(treatmentRecord);
        System.out.println("Treatment added: " + treatmentRecord);
    }

    // Remove most recent treatment
    public String pop() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        String treatment = treatmentHistory.pop();
        System.out.println("Removed treatment: " + treatment);
        return treatment;
    }

    // Display treatment records
    public void displayStack() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("=== Treatment History ===");

        for (int i = treatmentHistory.size() - 1; i >= 0; i--) {
            System.out.println(treatmentHistory.get(i));
        }
    }
}
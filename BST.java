public class BST {

    class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    // Insert a patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {
            root.left = insertRecursive(root.left, patient);
        } else if (patient.patientId > root.patient.patientId) {
            root.right = insertRecursive(root.right, patient);
        }

        return root;
    }

    // Search for a patient
    public Patient search(int patientId) {
        Node result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchRecursive(Node root, int patientId) {
        if (root == null || root.patient.patientId == patientId) {
            return root;
        }

        if (patientId < root.patient.patientId) {
            return searchRecursive(root.left, patientId);
        }

        return searchRecursive(root.right, patientId);
    }

    // In-order traversal
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);

            System.out.println(
                "ID: " + root.patient.patientId +
                " | Name: " + root.patient.patientName +
                " | Age: " + root.patient.age +
                " | Contact: " + root.patient.contactNumber +
                " | Condition: " + root.patient.medicalCondition
            );

            inOrder(root.right);
        }
    }

    // Delete a patient
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private Node deleteRecursive(Node root, int patientId) {
        if (root == null) {
            return null;
        }

        if (patientId < root.patient.patientId) {
            root.left = deleteRecursive(root.left, patientId);
        } else if (patientId > root.patient.patientId) {
            root.right = deleteRecursive(root.right, patientId);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMin(root.right);
            root.patient = successor.patient;
            root.right = deleteRecursive(
                root.right,
                successor.patient.patientId
            );
        }

        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
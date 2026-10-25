
import java.util.HashMap;

public class StudentMarks {
    public static void main(String[] args) {

        HashMap<String, Integer> students = new HashMap<>();

        // Insert five students
        students.put("Ali", 85);
        students.put("Sara", 90);
        students.put("Ahmed", 78);
        students.put("Ayesha", 88);
        students.put("Hamza", 82);

        // Display all student records
        System.out.println("All Student Records:");
        System.out.println(students);

        // Update marks of one student
        students.put("Ali", 95);

        System.out.println("Updated Marks of Ali: " + students.get("Ali"));

        // Retrieve marks of a specific student
        System.out.println("Marks of Sara: " + students.get("Sara"));

        // Display total number of students
        System.out.println("Total Students: " + students.size());
    }
}

package skillnext;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {

                    case 1:   // Add student
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Semester: ");
                        int sem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        Student s = new Student(0, name, sem, dept);
                        dao.insert(s);  // using insert() from your DAO

                        System.out.println("Student added successfully!");
                        break;

                    case 2:   // View all students
                        List<Student> students = dao.selectAll();
                        if (students.isEmpty()) {
                            System.out.println("No students found!");
                        } else {
                            System.out.println("\n===== All Students =====");
                            for (Student st : students) {
                                System.out.println(st);
                            }
                        }
                        break;

                    case 3:   // Update student
                        System.out.print("Enter Student ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        if (!dao.exists(uid)) {
                            System.out.println("Student ID not found!");
                            break;
                        }

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Semester: ");
                        int newSem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDept = sc.nextLine();

                        Student updated = new Student(uid, newName, newSem, newDept);
                        dao.update(updated);

                        System.out.println("Student updated successfully!");
                        break;

                    case 4:  // Delete student
                        System.out.print("Enter Student ID to Delete: ");
                        int did = sc.nextInt();
                        sc.nextLine();

                        if (!dao.exists(did)) {
                            System.out.println("Student ID not found!");
                            break;
                        }

                        dao.delete(did);
                        System.out.println("Student deleted successfully!");
                        break;

                    case 5:
                        System.out.println("Thanks for using the system!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

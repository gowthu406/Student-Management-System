import java.util.*;

public class StudentManagementSystem {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (students.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        Student s = new Student(id, name, age, course);
        students.put(id, s);
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }
        students.values().forEach(System.out::println);
    }

    private static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        Student s = students.get(id);
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = students.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New course: ");
        String course = scanner.nextLine();

        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        System.out.println("Student updated.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        if (students.remove(id) != null) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary);
    }
}

public class EmployeeManagementSystem {

    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    // Add Employee - O(1)
    public static void addEmployee(Employee emp) {
        if (count < MAX) {
            employees[count++] = emp;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search Employee by ID - O(n)
    public static int searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return i;
            }
        }
        return -1;
    }

    // Traverse Employees - O(n)
    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee by ID - O(n)
    public static void deleteEmployee(int id) {
        int index = searchEmployee(id);
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null;
        count--;
        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String pos = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    addEmployee(new Employee(id, name, pos, sal));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Search: ");
                    int sid = sc.nextInt();
                    int found = searchEmployee(sid);
                    if (found != -1) {
                        System.out.println("Employee found:");
                        employees[found].display();
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();
                    deleteEmployee(did);
                    break;

                case 4:
                    traverseEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

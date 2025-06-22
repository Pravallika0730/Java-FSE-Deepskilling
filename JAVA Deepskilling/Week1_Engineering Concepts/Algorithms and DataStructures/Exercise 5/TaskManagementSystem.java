import java.util.Scanner;

// Node structure: Task
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public void display() {
        System.out.println("Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

// Singly Linked List for Task Management
public class TaskManagementSystem {
    private Task head = null;

    // Add Task to end - O(n)
    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    // Search Task by ID - O(n)
    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Delete Task by ID - O(n)
    public boolean deleteTask(int taskId) {
        if (head == null) return false;

        if (head.taskId == taskId) {
            head = head.next;
            return true;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Traverse/Display all tasks - O(n)
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagementSystem system = new TaskManagementSystem();
        int choice;

        do {
            System.out.println("\n=== Task Management Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = sc.nextLine();
                    system.addTask(id, name, status);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task found = system.searchTask(searchId);
                    if (found != null) {
                        System.out.println("Task Found:");
                        found.display();
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = system.deleteTask(delId);
                    System.out.println(deleted ? "Task deleted." : "Task not found.");
                    break;

                case 4:
                    system.displayTasks();
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

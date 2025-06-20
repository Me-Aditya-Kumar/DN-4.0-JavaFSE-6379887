import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public void displayTask() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private TaskNode head = null;

    // Add task at the end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added.");
    }

    // Search task by ID
    public void searchTask(int id) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == id) {
                System.out.println("Task found:");
                temp.task.displayTask();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    // Traverse all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode temp = head;
        while (temp != null) {
            temp.task.displayTask();
            temp = temp.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        TaskNode prev = null, current = head;
        while (current != null && current.task.taskId != id) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
        } else {
            prev.next = current.next;
            System.out.println("Task deleted.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagementSystem manager = new TaskManagementSystem();
        int choice;

        do {
            System.out.println("\nTask Management Menu:");
            System.out.println("1. Add Task\n2. Search Task\n3. Delete Task\n4. View All Tasks\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Status: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String status = sc.next();
                    manager.addTask(new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    id = sc.nextInt();
                    manager.searchTask(id);
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteTask(id);
                    break;

                case 4:
                    manager.traverseTasks();
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

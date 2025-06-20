import java.util.Scanner;

public class EmployeeManager {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < MAX) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                employees[i].displayEmployee();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management Menu:");
            System.out.println("1. Add Employee\n2. Search Employee\n3. Delete Employee\n4. View All Employees\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Position, Salary: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String position = sc.next();
                    double salary = sc.nextDouble();
                    addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    id = sc.nextInt();
                    searchEmployee(id);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    id = sc.nextInt();
                    deleteEmployee(id);
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
    }
}

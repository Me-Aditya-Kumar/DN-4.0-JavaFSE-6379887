import java.util.HashMap;
import java.util.Scanner;

public class InventoryManager {
    private static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added.");
    }

    public static void updateProduct(int id, int quantity, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void showAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product p : inventory.values()) {
                p.displayProduct();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Add Product\n2. Update Product\n3. Delete Product\n4. View All Products\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    id = sc.nextInt();
                    System.out.print("Enter new Quantity and Price: ");
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    updateProduct(id, qty, price);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    id = sc.nextInt();
                    deleteProduct(id);
                    break;

                case 4:
                    showAllProducts();
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

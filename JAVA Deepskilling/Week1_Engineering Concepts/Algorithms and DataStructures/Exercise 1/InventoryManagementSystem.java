import java.util.HashMap;
import java.util.Scanner;

// Step 1: Define Product class
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + productId + ", Name: " + productName +
                ", Quantity: " + quantity + ", Price: " + price);
    }
}

// Step 2: Inventory Management System
public class InventoryManagementSystem {

    // HashMap for fast retrieval by productId — O(1) average time
    static HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product — O(1)
    public static void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Product ID already exists. Try updating it instead.");
        } else {
            inventory.put(product.productId, product);
            System.out.println("Product added successfully.");
        }
    }

    // Update product — O(1)
    public static void updateProduct(int productId, String newName, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.productName = newName;
            product.quantity = newQuantity;
            product.price = newPrice;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete product — O(1)
    public static void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products — O(n)
    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                product.display();
            }
        }
    }

    // Step 3: Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    updateProduct(updateId, newName, newQty, newPrice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();
                    deleteProduct(deleteId);
                    break;

                case 4:
                    displayInventory();
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

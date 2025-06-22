import java.util.Arrays;
import java.util.Scanner;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }

    // For sorting by productName
    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
}

public class EcommerceSearch {

    // Linear Search: O(n)
    public static int linearSearch(Product[] products, String keyName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(keyName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: O(log n), assumes array is sorted
    public static int binarySearch(Product[] products, String keyName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(keyName);
            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Sample data setup
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Smartphone", "Electronics"),
            new Product(104, "Bag", "Accessories"),
            new Product(105, "Watch", "Accessories")
        };

        Scanner sc = new Scanner(System.in);

        // Ask user what to search
        System.out.println("Enter product name to search: ");
        String searchKey = sc.nextLine();

        System.out.println("\n=== Linear Search ===");
        int indexLinear = linearSearch(products, searchKey);
        if (indexLinear != -1) {
            System.out.print("Product found at index " + indexLinear + ": ");
            products[indexLinear].display();
        } else {
            System.out.println("Product not found.");
        }

        // Sort products by name for binary search
        Arrays.sort(products);

        System.out.println("\n=== Binary Search ===");
        int indexBinary = binarySearch(products, searchKey);
        if (indexBinary != -1) {
            System.out.print("Product found at index " + indexBinary + ": ");
            products[indexBinary].display();
        } else {
            System.out.println("Product not found.");
        }

        sc.close();
    }
}

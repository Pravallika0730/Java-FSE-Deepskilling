import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void display() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice);
    }
}

public class OrderSorting {

    // Bubble Sort: O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort: O(n log n) average case
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display orders
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Order[] orders = {
            new Order(201, "Alice", 2999.50),
            new Order(202, "Bob", 899.99),
            new Order(203, "Charlie", 15999.99),
            new Order(204, "Daisy", 4599.00),
            new Order(205, "Eve", 699.00)
        };

        System.out.println("\nOriginal Orders:");
        displayOrders(orders);

        // Bubble Sort
        Order[] bubbleSorted = orders.clone();
        bubbleSort(bubbleSorted);
        System.out.println("\nOrders Sorted by Bubble Sort (Total Price Ascending):");
        displayOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = orders.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort (Total Price Ascending):");
        displayOrders(quickSorted);

        // Time Complexity Analysis (in comments)
        /*
         * Bubble Sort:
         * - Best Case: O(n) [only if optimized version is used]
         * - Average/Worst Case: O(n^2)
         * 
         * Quick Sort:
         * - Best/Average Case: O(n log n)
         * - Worst Case: O(n^2) (rare, when pivot choices are poor)
         *
         * 👉 Quick Sort is generally preferred due to its average-case speed and lower constant factors.
         *    Bubble Sort is simple but inefficient for large data sets.
         */

        sc.close();
    }
}

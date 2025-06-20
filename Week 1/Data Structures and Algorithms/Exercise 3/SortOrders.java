public class SortOrders {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

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
            if (orders[j].totalPrice <= pivot) {
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

    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            o.displayOrder();
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 450.00),
            new Order(102, "Bob", 1200.50),
            new Order(103, "Charlie", 300.75),
            new Order(104, "David", 875.00)
        };

        System.out.println("Original Orders:");
        displayOrders(orders);

        bubbleSort(orders);
        System.out.println("\nSorted by Bubble Sort:");
        displayOrders(orders);

        orders = new Order[]{
            new Order(101, "Alice", 450.00),
            new Order(102, "Bob", 1200.50),
            new Order(103, "Charlie", 300.75),
            new Order(104, "David", 875.00)
        };

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        displayOrders(orders);
    }
}

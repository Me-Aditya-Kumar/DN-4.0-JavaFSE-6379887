import java.util.Arrays;

public class search_product {

    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return mid;
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(5, "Laptop", "Electronics"),
            new Product(2, "Table", "Furniture"),
            new Product(4, "Shampoo", "Personal Care"),
            new Product(1, "Phone", "Electronics"),
            new Product(3, "Watch", "Accessories")
        };

        int searchId = 3;


        int linearIndex = linearSearch(products, searchId);
        if (linearIndex != -1) {
            System.out.println("Linear Search: Found - " + products[linearIndex]);
        } else {
            System.out.println("Linear Search: Product not found.");
        }


        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));

        int binaryIndex = binarySearch(products, searchId);
        if (binaryIndex != -1) {
            System.out.println("Binary Search: Found - " + products[binaryIndex]);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}

import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + " - " + productName + " - " + category + "]";
    }
}

public class ProductSearch { 
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Bag", "Fashion"),
            new Product(105, "Watch", "Accessories")
        };

        System.out.println("Linear Search:");
        Product foundLinear = linearSearch(products, "Bag");
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search:");
        Product foundBinary = binarySearch(products, "Bag");
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found");
    }
}

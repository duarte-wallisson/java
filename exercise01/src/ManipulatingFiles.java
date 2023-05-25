import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ManipulatingFiles {
    public static List<Product> toRead(String path) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            var line = br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                String item = values[0].trim();
                double price = Double.parseDouble(values[1].trim());
                Product product = new Product(item, price);

                System.out.println("Item: " + item);
                System.out.println("Price: " + price);
                products.add(product);
                line = br.readLine();
            }
            System.out.println("--------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static Double avgPrice(List<Product> items) {
        Double avg = 0D;
        for (Product item : items) {
            avg += item.getPrice();
        }
        avg /= items.size();
        return avg;
    }

    public static void sort(List<Product> items) {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        items.sort(comparator.reversed());
        for (Product product : items) {
            System.out.println("Item: " + product.getName());
            System.out.println("Price: " + product.getPrice());
        }
    }
}

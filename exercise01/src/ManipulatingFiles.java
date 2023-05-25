import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ManipulatingFiles {
    public static List<Product> toRead(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.lines()
                    .map(line -> {
                        String[] values = line.split(",");
                        String item = values[0].trim();
                        double price = Double.parseDouble(values[1].trim());
                        return new Product(item, price);
                    })
                    .peek(product -> {
                        System.out.println("Item: " + product.getName());
                        System.out.println("Price: " + product.getPrice());
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Double avgPrice(List<Product> items) {
        return items.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0D);
    }

    public static void sort(List<Product> items, Double avg) {
        List<Product> filteredItems = items.stream()
                .filter(product -> product.getPrice() < avg)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
        filteredItems.forEach(product -> {
            System.out.println("Item: " + product.getName());
            System.out.println("Price: " + product.getPrice());
        });
    }
}

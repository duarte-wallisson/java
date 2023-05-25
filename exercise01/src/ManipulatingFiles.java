import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ManipulatingFiles {
    public static Map<String, Double> toRead(String path){
        Map<String, Double> itemsMap = new HashMap<>();
        try (BufferedReader br =  new BufferedReader(new FileReader(path))){
            var line = br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                String item = values[0].trim();
                double price = Double.parseDouble(values[1].trim());

                System.out.println("Item: " + item);
                System.out.println("Price: " + price);
                itemsMap.put(item, price);
                line = br.readLine();
            }
            System.out.println("--------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    public static Double avgPrice(Map<String, Double> items) {
        Double avg = 0D;
        for (Double price: items.values()) {
            avg += price;
        }
        avg /= items.size();

        return avg;
    }

    public static void  sort(Map<String, Double> items) {
        List<Map.Entry<String, Double>> itemsList = new ArrayList<>(items.entrySet());
        itemsList.sort(Map.Entry.<String, Double>comparingByValue().reversed());
        for (Map.Entry<String, Double> entry : itemsList) {
            String item = entry.getKey();
            Double price = entry.getValue();
            System.out.println("Item: " + item);
            System.out.println("Price: " + price);
        }
    }
}

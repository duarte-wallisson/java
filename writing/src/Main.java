import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good evening", "Good night"};
        String path = "C:\\Developer\\Projects\\java\\files\\greetings.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line: lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
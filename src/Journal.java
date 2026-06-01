import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Journal {
    private String fileName;

    public Journal(String fileName) {
        this.fileName = fileName;
    }

    public void register(String operation) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(LocalDateTime.now() + " - " + operation + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no journal: " + e.getMessage());
        }
    }
}
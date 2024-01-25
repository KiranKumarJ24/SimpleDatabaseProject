// Metadata.java
package simpledatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Metadata {
    private Path filePath;

    public Metadata() {
        this.filePath = Paths.get("src/resources/metadata.txt");
    }

    public void updateMetadata(String tableName, String[] columns, String[] types) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {

            writer.write(tableName + ",");

            for (String column : columns) {
                writer.write(column + ",");
            }

            for (String type : types) {
                writer.write(type + ",");
            }

            writer.newLine();
        }
    }
}

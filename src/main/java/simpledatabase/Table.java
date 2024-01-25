// Table.java
package simpledatabase;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Table {
    private String tableName;
    private Path filePath;

    public Table(String tableName) {
        this.tableName = tableName;
        this.filePath = Paths.get("src/resources/" + tableName + ".txt");
    }

    public void createTable(String[] columns, String[] types) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {

            for (String column : columns) {
                writer.write(column + ",");
            }
            writer.newLine();


            for (String type : types) {
                writer.write(type + ",");
            }
            writer.newLine();
        }
    }

    public void insertIntoTable(Object[] values) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {

            for (Object value : values) {
                writer.write(value.toString() + ",");
            }
            writer.newLine();
        }
    }
}









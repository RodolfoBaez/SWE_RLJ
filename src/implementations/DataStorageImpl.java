package implementations;

import process.api.DataStorage;
import process.api.InputSource;
import process.api.OutputSource;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class DataStorageImpl implements DataStorage {

    @Override
    public int writeToOutput(OutputSource os) {
        String filePath = os.getFilePath();  // Get the file path from the OutputSource object
        String data = os.getData();  // Get the data to write

        try {
            FileWriter writer = new FileWriter(new File(filePath));
            writer.write(data);
            writer.close();
            return 0;  // Return 0 for success
        } catch (Exception e) {
            return -1;  // Return -1 for failure
        }
    }

    @Override
    public int readFromInput(InputSource is) {
        String filePath = is.getFilePath();  // Get the file path from the InputSource object
        StringBuilder content = new StringBuilder();

        try {
            FileReader reader = new FileReader(new File(filePath));
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            reader.close();
            is.setData(content.toString());  // Store the read data in the InputSource object
            return 0;  // Return 0 for success
        } catch (Exception e) {
            return -1;  // Return -1 for failure
        }
    }
}

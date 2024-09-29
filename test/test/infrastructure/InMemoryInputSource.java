package test.infrastructure;

import java.nio.file.Path;
import conceptual.api.InputSource;

// In-memory implementation for InputSource with a Path
public class InMemoryInputSource extends InputSource {
    private Path data;

    public InMemoryInputSource(Path data) {
        this.data = data;
    }

    // Method to retrieve the data
    public Path getData() {
        return data;
    }

    public void setData(Path data) {
        this.data = data;
    }
}

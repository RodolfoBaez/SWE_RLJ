package conceptual.api;

import java.nio.file.Path;

public class InputSource implements InputSourceInterface {
    private Path data;
    
    @Override
    public Path getData() {
        return data;
    }

    @Override
    public void setData(int data) {
    }
}

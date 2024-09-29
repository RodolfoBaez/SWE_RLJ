package conceptual.api;

import java.nio.file.Path;

public class InputSource implements InputSourceInterface {
    private Path path;

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public void setPath(Path path) {
        this.path = path;
    }
}

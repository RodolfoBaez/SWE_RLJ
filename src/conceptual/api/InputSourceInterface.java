package conceptual.api;

import java.nio.file.Path;

public interface InputSourceInterface {
    Path getPath();
    void setPath(Path path);
}

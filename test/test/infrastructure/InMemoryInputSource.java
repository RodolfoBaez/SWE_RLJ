package test.infrastructure;

import java.util.List;
import conceptual.api.InputSource;

// In-memory implementation for InputSource with a List of Integers
public class InMemoryInputSource extends InputSource<List<Integer>> {
    public InMemoryInputSource(List<Integer> data) {
        setData(data);
    }
}


// In-memory implementation for OutputSource with a List of Strings
package test.infrastructure;

import java.util.ArrayList;
import java.util.List;
import conceptual.api.OutputSource;

public class InMemoryOutputSource extends OutputSource<List<String>> {
    public InMemoryOutputSource() {
        setData(new ArrayList<>());
    }

    public void writeOutput(String data) {
        List<String> currentData = getData();
        currentData.add(data);
        setData(currentData);
    }
}

package conceptual.api;

public class OutputSource implements OutputSourceInterface {
    private int data;

    @Override
    public int getData() {
        return data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }
}

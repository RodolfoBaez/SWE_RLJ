package conceptual.api;

public class InputSource implements InputSourceInterface {
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

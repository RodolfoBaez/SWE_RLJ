package conceptual.api;

public class InputSource<T> implements InputSourceInterface<T>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

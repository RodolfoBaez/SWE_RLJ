package conceptual.api;

public interface InputSourceInterface<T> {
    T getData();
    void setData(T data);
}

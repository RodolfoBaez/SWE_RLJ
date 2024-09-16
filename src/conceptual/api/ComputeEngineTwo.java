package conceptual.api;

// Compute Engine Two
public enum ComputeEngineTwo {
    SUCCESS(1, true),
    FAILURE(0, false);
    
    private final int id;
    private final boolean success;
    
    private ComputeEngineTwo(int id, boolean success) {
        this.id = id;
        this.success = success;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean isSuccess() {
        return success;
    }
}

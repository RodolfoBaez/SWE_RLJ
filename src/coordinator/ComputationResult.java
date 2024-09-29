package coordinator;

public class ComputationResult {
    private boolean success;
    private String message;
    
    // Constructor
    public ComputationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    // Setters if needed
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

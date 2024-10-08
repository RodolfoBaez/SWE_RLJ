package process.api;

public enum ProcessResultCode {

	SUCCESS(0, "pAPI: Successfully sent input"), ERROR(1, "pAPI: Failed to send input");

	private final int code;
	private final String description;

	ProcessResultCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}

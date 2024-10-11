package process.api;

//TODO: Not sure how to add wrapper for additional functionality here
public enum ProcessResultCode {

	SUCCESS(0, "processAPI: Successfully sent input"), ERROR(1, "processAPI: Failed to send input");

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

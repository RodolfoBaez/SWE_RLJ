package coordinator;

public enum ComputationResultCode {
	SUCCESS(0, ""), ERROR(1, "");

	private final int code;
	private final String description;

	ComputationResultCode(int code, String description) {
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

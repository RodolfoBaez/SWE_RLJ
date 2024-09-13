package process.api;

public enum DSCode {
	SUCCESS(1, true),
	FALIURE(0, false);
	
	private final int id;
	private final boolean success;
	
	private DSCode(int id, boolean success){
		this.id = id;
		this.success = success;
	}
}
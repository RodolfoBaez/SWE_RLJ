package processAPI;

public enum DSCode {
	SUCCESS(1, true),
	FALIURE(0, false);
	
	private final int ID;
	private final boolean success;
	
	private DSCode(int id, boolean success)
	{
		ID = id;
		this.success = success;
	}
}

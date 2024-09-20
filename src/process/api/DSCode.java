package process.api;

public interface DSCode {
	static DSCode SUCCESS = () -> DSCodeStatus.SUCESSS;
	static DSCode FAILURE = () -> DSCodeStatus.FAILURE;
	
	DSCodeStatus getStatus();
	
	public static enum DSCodeStatus{
		SUCESSS,
		FAILURE;
	}
}
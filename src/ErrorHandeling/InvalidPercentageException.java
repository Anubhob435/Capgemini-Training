package src.ErrorHandeling;

public class InvalidPercentageException extends RuntimeException{
	
	public InvalidPercentageException(String msg) {
		super(msg);
	}
}
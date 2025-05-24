/**
 * Custom exception for invalid commands in the SimpleCalculator
 */
public class UnknownCmdException extends Exception {
	/**
	 * Constructs a new UnknownCmdException with the message to describe error
	 * @param errMessage the message to describe error
	 */
	public UnknownCmdException(String errMessage) {
		super(errMessage);
	}
}

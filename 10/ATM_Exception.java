/**
 * Custom exception class for ATM-related errors
 */
public class ATM_Exception extends Exception {
	/**
	 * Enum representing the type of ATM exception
	 */
	public enum ExceptionTYPE {
        BALANCE_NOT_ENOUGH,
        AMOUNT_INVALID
    }
    private ExceptionTYPE exceptionCondition;
    /**
     * Constructs an ATM_Exception with the type of ATM exception
     * @param type the type of ATM exception
     */
    public ATM_Exception(ExceptionTYPE type) {
        this.exceptionCondition = type;
    }
    /**
     * Returns the exception message
     */
    public String getMessage() {
        return exceptionCondition.name();
    }
}

import java.text.DecimalFormat;
/**
 * A simple calculator that performs basic arithmetic operations
 */
public class SimpleCalculator {
	private double result = 0.0;
	private int time = 0;
	private String lastOperator = "";
	private String lastValue = "";
	private boolean finished = false;
	/**
	 * Parses and process a calculation command
	 * @param cmd the input command string
	 * @throws UnknownCmdException if the command is invalid (containing unknown operator or value, or attempting to divide by zero), return error message
	 */
	public void calResult(String cmd) throws UnknownCmdException{
		String[] parts = cmd.trim().split(" ");
		if (parts.length != 2) {
			throw new UnknownCmdException("Please enter 1 operator and 1 value separated by 1 space");
		}
		String operator = parts[0];
		String valueStr = parts[1];
		double value = 0.0;
		boolean operatorValid = operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
		boolean valueValid = true;
		try {
			value = Double.parseDouble(valueStr);
		} catch (NumberFormatException e){
			valueValid = false;
		}
		if (!operatorValid && !valueValid) {
			throw new UnknownCmdException(operator + " is an unknown operator and " + valueStr + " is an unknown value");
		} if (!operatorValid) {
			throw new UnknownCmdException(operator + " is an unknown operator");
		} if (!valueValid) {
			throw new UnknownCmdException(valueStr + " is an unknown value");
		}
		if (operator.equals("/") && value == 0.0) {
            throw new UnknownCmdException("Can not divide by 0");
        }
		switch (operator) {
			case "+": result += value; break;
			case "-": result -= value; break;
			case "*": result *= value; break;
			case "/": result /= value; break;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		lastOperator = operator;
		lastValue = df.format(value);
		time++;
	}
	/**
	 * Returns a message summarizing the current state or result of the calculator
	 * @return A formatted message based on the number of operations and final state
	 */
	public String getMsg() {
		DecimalFormat df = new DecimalFormat("0.00");
		String formattedResult = df.format(result);
		if (finished) {
			return "Final result = " + formattedResult;
		} else if (time == 0) {
			return "Calculator is on. Result = " + formattedResult;
		} else if (time == 1) {
			return "Result " + lastOperator + " " + lastValue + " = " + formattedResult + ". New result = " + formattedResult;
		} else {
			return "Result " + lastOperator + " " + lastValue + " = " + formattedResult + ". Updated result = " + formattedResult;
		}
	}
	/**
	 * Ends the calculation session if the command is "r" or "R"
	 * @param cmd the input string
	 * @return true if the input string has "r" or "R", false otherwise
	 */
	public boolean endCalc(String cmd) {
		if (cmd.trim().equalsIgnoreCase("r")) {
			finished = true;
			return true;
		}
		return false;
	}
	/**
	 * Main method to simulate calculator by using SimpleCalculator class
	 * @param arg command-line argument
	 */
	public static void main(String arg[]) {
		SimpleCalculator cal = new SimpleCalculator();
		String cmd = null;
		System.out.println(cal.getMsg());
		String cmd_str = "+ 5,- 2,* 5,/ 3,% 2,* D,X D,XD,, ,/ 1000000,/ 00.000,/ 0.000001,+ 1 + 1,- 1.66633,r R,r";
		String[] cmd_arr = cmd_str.split(",");
		for (int i = 0; i < cmd_arr.length; i++) {
		  try {
		    if (cal.endCalc(cmd_arr[i])) 
		      break;		
		    cal.calResult(cmd_arr[i]);
		    System.out.println(cal.getMsg());
		  } catch (UnknownCmdException e) {
		    System.out.println(e.getMessage());
		  }
		}
		System.out.println(cal.getMsg());
	}
}

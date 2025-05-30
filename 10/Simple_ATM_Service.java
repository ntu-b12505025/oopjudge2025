/**
 * Implementation of a simple ATM service that support withdrawing
 */
public class Simple_ATM_Service implements ATM_Service{
	/**
	 * Checks whether the account has sufficient balance to withdraw the specified amount
	 */
	public boolean checkBalance(Account account, int money) throws ATM_Exception{
		if (account.getBalance() < money) {
			throw new ATM_Exception(ATM_Exception.ExceptionTYPE.BALANCE_NOT_ENOUGH);
		}
		return true;
	}
	/**
	 * Checks whether the amount to withdraw is valid
	 */
	public boolean isValidAmount (int money) throws ATM_Exception{
		if (money % 1000 !=0) {
			throw new ATM_Exception(ATM_Exception.ExceptionTYPE.AMOUNT_INVALID);
		}
		return true;
	}
	/**
	 * Withdraws money from the account, after checking balance and amount validity, and prints the updated balance
	 */
	public void withdraw (Account account, int money){
		try {
            checkBalance(account, money);
            isValidAmount(money);
            account.setBalance(account.getBalance() - money);
        } catch (ATM_Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("updated balance : " + account.getBalance());
	}
	/**
	 * Main method to test the Simple_ATM_Service class
	 * @param args command-line argument
	 */
	public static void main(String[] args) {
		Account David = new Account(4000);
		Simple_ATM_Service atm = new Simple_ATM_Service();
		System.out.println("---- first withdraw ----");
		atm.withdraw(David,1000);
		System.out.println("---- second withdraw ----");
		atm.withdraw(David,1000);
		System.out.println("---- third withdraw ----");
		atm.withdraw(David,1001);
		System.out.println("---- fourth withdraw ----");
		atm.withdraw(David,4000);
	}
}

package banking;

/**
 * @author Justin Del Vecchio
 * @author Jon Mrowczynski
 */
public class BankDriver {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("001", "Alice", 1000.0);
		BankAccount account2 = new BankAccount("002", "Bob", 500.0);
		Transaction t1 = new Transaction(account1, 500.0);
		t1.withdraw();
		Transaction t2 = new Transaction(account2, 200.0);
		t2.deposit();
	}
}
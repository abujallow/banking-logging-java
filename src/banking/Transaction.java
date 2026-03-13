package banking;

/**
 * Represents a financial transaction on a {@link BankAccount} of a given amount.
 *
 * @param account the {@link BankAccount} associated with this {@code Transaction}.
 * @param amount the amount either deposited or withdrawn.
 *
 * @author Justin Del Vecchio
 * @author Jon Mrowczynski
 */
public record Transaction(BankAccount account, double amount) {
	public void withdraw() { account.withdraw(amount); }
	public void deposit() { account.deposit(amount); }
}
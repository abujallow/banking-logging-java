package banking;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;

/**
 * @author Justin Del Vecchio
 * @author Jon Mrowczynski
 * @author abu jallow
 */
public class BankAccount {
	
	private final String accountNumber;
	
	private final String customerName;
	
	private final Logger logger;
	
	private double balance;
	
	public BankAccount(final String accountNumber, final String customerName, final double balance) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
		logger = Logger.getLogger(accountNumber);
		try {
			File logDir = new File("logs");
			if (!logDir.exists()) {
				logDir.mkdir();
			}
			FileHandler handler = new FileHandler("logs/" + accountNumber + ".log");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		}
		catch (IOException e) { logger.log(Level.SEVERE, "Error creating log file", e); }
	}
	
	public void deposit(final double amount) {
		balance += amount;
		logger.info(String.format("Deposit: $%.2f, Balance: $%.2f", amount, balance));
	}
	
	public void withdraw(final double amount) {
		balance -= amount;
		logger.info(String.format("Withdraw: $%.2f, Balance: $%.2f", amount, balance));
	}
	
	public String getAccountNumber() { return accountNumber; }
	
	public String getCustomerName() { return customerName; }
}
package practice.Batch1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom Exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

// Account Interface
interface Account {
    void deposit(double amount) throws InvalidTransactionException;
    void withdraw(double amount) throws InsufficientFundsException, InvalidTransactionException;
    double getBalance();
    int getAccountNumber();
    String getAccountHolder();
    void displayAccountInfo();
}

// Abstract Account Base Class
abstract class AbstractAccount implements Account {
    protected static int accountCounter = 1000;
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;
    
    public AbstractAccount(String accountHolder) {
        this.accountNumber = ++accountCounter;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    
    @Override
    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " to account " + accountNumber + 
                          ". New balance: $" + String.format("%.2f", balance));
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive.");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: $" + 
                                                String.format("%.2f", balance));
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from account " + accountNumber + 
                          ". Remaining balance: $" + String.format("%.2f", balance));
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
    
    @Override
    public String getAccountHolder() {
        return accountHolder;
    }
    
    @Override
    public abstract void displayAccountInfo();
}

// Checking Account Class
class CheckingAccount extends AbstractAccount {
    private static final double OVERDRAFT_LIMIT = 500.0;
    
    public CheckingAccount(String accountHolder) {
        super(accountHolder);
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive.");
        }
        if (balance + OVERDRAFT_LIMIT < amount) {
            throw new InsufficientFundsException("Insufficient funds. Available balance (with overdraft): $" + 
                                                String.format("%.2f", balance + OVERDRAFT_LIMIT));
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from checking account " + accountNumber + 
                          ". Remaining balance: $" + String.format("%.2f", balance));
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("=== Checking Account ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Overdraft Limit: $" + OVERDRAFT_LIMIT);
    }
}

// Savings Account Class
class SavingsAccount extends AbstractAccount {
    private double interestRate;
    
    public SavingsAccount(String accountHolder, double interestRate) {
        super(accountHolder);
        this.interestRate = interestRate;
    }
    
    public double calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Interest calculated for account " + accountNumber + ": $" + 
                          String.format("%.2f", interest));
        return interest;
    }
    
    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest applied. New balance: $" + String.format("%.2f", balance));
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("=== Savings Account ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Credit Card Account Class
class CreditCardAccount extends AbstractAccount {
    private double creditLimit;
    private double creditUsed;
    
    public CreditCardAccount(String accountHolder, double creditLimit) {
        super(accountHolder);
        this.creditLimit = creditLimit;
        this.creditUsed = 0.0;
    }
    
    public void makePayment(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Payment amount must be positive.");
        }
        if (creditUsed + amount > creditLimit) {
            throw new InvalidTransactionException("Payment exceeds credit limit. Available credit: $" + 
                                                 String.format("%.2f", creditLimit - creditUsed));
        }
        creditUsed += amount;
        System.out.println("Payment of $" + amount + " made on card " + accountNumber + 
                          ". Credit used: $" + String.format("%.2f", creditUsed) + 
                          " / $" + String.format("%.2f", creditLimit));
    }
    
    @Override
    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Payment amount must be positive.");
        }
        if (amount > creditUsed) {
            throw new InvalidTransactionException("Payment exceeds outstanding balance. Outstanding: $" + 
                                                 String.format("%.2f", creditUsed));
        }
        creditUsed -= amount;
        System.out.println("Payment of $" + amount + " received on card " + accountNumber + 
                          ". Remaining balance: $" + String.format("%.2f", creditUsed));
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidTransactionException {
        throw new InvalidTransactionException("Withdrawals not allowed on credit card accounts. Use makePayment instead.");
    }
    
    @Override
    public double getBalance() {
        return creditLimit - creditUsed;
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("=== Credit Card Account ===");
        System.out.println("Card Number: " + accountNumber);
        System.out.println("Card Holder: " + accountHolder);
        System.out.println("Credit Limit: $" + String.format("%.2f", creditLimit));
        System.out.println("Credit Used: $" + String.format("%.2f", creditUsed));
        System.out.println("Available Credit: $" + String.format("%.2f", creditLimit - creditUsed));
    }
    
    public double getCreditUsed() {
        return creditUsed;
    }
}

// Banking System Class
class BankingSystem {
    private Map<Integer, AbstractAccount> accounts;
    
    public BankingSystem() {
        accounts = new HashMap<>();
    }
    
    public int createAccount(String accountType, String accountHolder, double creditLimit, double interestRate) {
        AbstractAccount account = null;
        
        switch (accountType.toLowerCase()) {
            case "checking":
                account = new CheckingAccount(accountHolder);
                System.out.println("Checking account created for " + accountHolder + 
                                  " with account number: " + account.getAccountNumber());
                break;
                
            case "savings":
                account = new SavingsAccount(accountHolder, interestRate);
                System.out.println("Savings account created for " + accountHolder + 
                                  " with account number: " + account.getAccountNumber() + 
                                  " and interest rate: " + interestRate + "%");
                break;
                
            case "credit":
                account = new CreditCardAccount(accountHolder, creditLimit);
                System.out.println("Credit card account created for " + accountHolder + 
                                  " with card number: " + account.getAccountNumber() + 
                                  " and credit limit: $" + creditLimit);
                break;
                
            default:
                System.out.println("Invalid account type: " + accountType);
                return -1;
        }
        
        if (account != null) {
            accounts.put(account.getAccountNumber(), account);
            return account.getAccountNumber();
        }
        return -1;
    }
    
    public void deposit(int accountNumber, double amount) throws AccountNotFoundException, InvalidTransactionException {
        AbstractAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        
        account.deposit(amount);
    }
    
    public void withdraw(int accountNumber, double amount) throws AccountNotFoundException, 
                                                                   InsufficientFundsException, 
                                                                   InvalidTransactionException {
        AbstractAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        
        account.withdraw(amount);
    }
    
    public void checkBalance(int accountNumber) throws AccountNotFoundException {
        AbstractAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        
        if (account instanceof CreditCardAccount) {
            CreditCardAccount ccAccount = (CreditCardAccount) account;
            System.out.println("Card " + accountNumber + " - Available Credit: $" + 
                              String.format("%.2f", account.getBalance()) + 
                              " | Outstanding Balance: $" + String.format("%.2f", ccAccount.getCreditUsed()));
        } else {
            System.out.println("Account " + accountNumber + " - Balance: $" + 
                              String.format("%.2f", account.getBalance()));
        }
    }
    
    public void makePayment(int cardNumber, double amount) throws AccountNotFoundException, InvalidTransactionException {
        AbstractAccount account = accounts.get(cardNumber);
        if (account == null) {
            throw new AccountNotFoundException("Card not found: " + cardNumber);
        }
        
        if (!(account instanceof CreditCardAccount)) {
            throw new InvalidTransactionException("Account " + cardNumber + " is not a credit card account.");
        }
        
        CreditCardAccount ccAccount = (CreditCardAccount) account;
        ccAccount.makePayment(amount);
    }
    
    public void calculateInterest(int accountNumber) throws AccountNotFoundException, InvalidTransactionException {
        AbstractAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        
        if (!(account instanceof SavingsAccount)) {
            throw new InvalidTransactionException("Interest calculation only available for savings accounts.");
        }
        
        SavingsAccount savingsAccount = (SavingsAccount) account;
        savingsAccount.applyInterest();
    }
    
    public void displayAccountInfo(int accountNumber) throws AccountNotFoundException {
        AbstractAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        
        account.displayAccountInfo();
    }
    
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the system.");
            return;
        }
        
        System.out.println("\n=== ALL ACCOUNTS ===");
        for (AbstractAccount account : accounts.values()) {
            account.displayAccountInfo();
            System.out.println();
        }
    }
}

// Main Class
public class BankAccount {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BANK ACCOUNT MANAGEMENT SYSTEM ===\n");
        
        // Demonstration Examples
        try {
            // Create accounts
            System.out.println("--- Creating Accounts ---");
            int checking1 = bankingSystem.createAccount("checking", "John Doe", 0, 0);
            int savings1 = bankingSystem.createAccount("savings", "Jane Smith", 0, 3.5);
            int credit1 = bankingSystem.createAccount("credit", "Bob Johnson", 5000, 0);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Deposit to checking account
            System.out.println("--- Deposit Operations ---");
            bankingSystem.deposit(checking1, 1000);
            bankingSystem.deposit(savings1, 2000);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Check balances
            System.out.println("--- Check Balances ---");
            bankingSystem.checkBalance(checking1);
            bankingSystem.checkBalance(savings1);
            bankingSystem.checkBalance(credit1);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Withdraw from checking
            System.out.println("--- Withdrawal Operations ---");
            bankingSystem.withdraw(checking1, 300);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Make credit card payment
            System.out.println("--- Credit Card Payment ---");
            bankingSystem.makePayment(credit1, 1500);
            bankingSystem.checkBalance(credit1);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Pay off credit card
            System.out.println("--- Pay Credit Card Balance ---");
            bankingSystem.deposit(credit1, 500);
            bankingSystem.checkBalance(credit1);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Calculate interest for savings
            System.out.println("--- Calculate Interest ---");
            bankingSystem.calculateInterest(savings1);
            bankingSystem.checkBalance(savings1);
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Test error conditions
            System.out.println("--- Testing Error Conditions ---");
            
            // Insufficient funds
            try {
                System.out.println("\nAttempting to withdraw $10000 from checking...");
                bankingSystem.withdraw(checking1, 10000);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Invalid transaction
            try {
                System.out.println("\nAttempting to deposit negative amount...");
                bankingSystem.deposit(checking1, -100);
            } catch (InvalidTransactionException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Account not found
            try {
                System.out.println("\nAttempting to check balance for non-existent account...");
                bankingSystem.checkBalance(9999);
            } catch (AccountNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
            
            // Display all account information
            bankingSystem.displayAllAccounts();
            
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        
        // Interactive Mode
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== INTERACTIVE MODE ===");
        System.out.println("=".repeat(50) + "\n");
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Make Credit Card Payment");
            System.out.println("6. Calculate Interest (Savings)");
            System.out.println("7. Display Account Info");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Account Type (checking/savings/credit): ");
                        String type = scanner.nextLine();
                        System.out.print("Account Holder Name: ");
                        String name = scanner.nextLine();
                        
                        double creditLimit = 0;
                        double interestRate = 0;
                        
                        if (type.equalsIgnoreCase("credit")) {
                            System.out.print("Credit Limit: ");
                            creditLimit = scanner.nextDouble();
                        } else if (type.equalsIgnoreCase("savings")) {
                            System.out.print("Interest Rate (%): ");
                            interestRate = scanner.nextDouble();
                        }
                        
                        bankingSystem.createAccount(type, name, creditLimit, interestRate);
                        break;
                        
                    case 2:
                        System.out.print("Account Number: ");
                        int depositAcct = scanner.nextInt();
                        System.out.print("Amount to Deposit: ");
                        double depositAmt = scanner.nextDouble();
                        bankingSystem.deposit(depositAcct, depositAmt);
                        break;
                        
                    case 3:
                        System.out.print("Account Number: ");
                        int withdrawAcct = scanner.nextInt();
                        System.out.print("Amount to Withdraw: ");
                        double withdrawAmt = scanner.nextDouble();
                        bankingSystem.withdraw(withdrawAcct, withdrawAmt);
                        break;
                        
                    case 4:
                        System.out.print("Account Number: ");
                        int balanceAcct = scanner.nextInt();
                        bankingSystem.checkBalance(balanceAcct);
                        break;
                        
                    case 5:
                        System.out.print("Card Number: ");
                        int cardNum = scanner.nextInt();
                        System.out.print("Payment Amount: ");
                        double paymentAmt = scanner.nextDouble();
                        bankingSystem.makePayment(cardNum, paymentAmt);
                        break;
                        
                    case 6:
                        System.out.print("Savings Account Number: ");
                        int savingsAcct = scanner.nextInt();
                        bankingSystem.calculateInterest(savingsAcct);
                        break;
                        
                    case 7:
                        System.out.print("Account Number: ");
                        int infoAcct = scanner.nextInt();
                        bankingSystem.displayAccountInfo(infoAcct);
                        break;
                        
                    case 8:
                        bankingSystem.displayAllAccounts();
                        break;
                        
                    case 9:
                        running = false;
                        System.out.println("\nThank you for using Bank Account Management System!");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (AccountNotFoundException | InsufficientFundsException | InvalidTransactionException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear buffer
            }
        }
        
        scanner.close();
    }
}

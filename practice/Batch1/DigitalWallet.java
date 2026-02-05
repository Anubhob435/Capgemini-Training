package practice.Batch1;

import java.util.Scanner;

// Custom exception class for transaction errors
class TransactionException extends Exception {
    private String errorCode;
    
    public TransactionException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}

// Wallet class to manage wallet details
class Wallet {
    private String walletId;
    private String userName;
    private String userAccessToken;
    private double walletBalance;
    
    // Constructor without access token
    public Wallet(String walletId, String userName) {
        this.walletId = walletId;
        this.userName = userName;
        this.userAccessToken = null;
        this.walletBalance = 0.0;
    }
    
    // Constructor with access token
    public Wallet(String walletId, String userName, String userAccessCode) {
        this.walletId = walletId;
        this.userName = userName;
        this.userAccessToken = userAccessCode;
        this.walletBalance = 0.0;
    }
    
    public String getWalletId() {
        return walletId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUserAccessToken() {
        return userAccessToken;
    }
    
    public double getWalletBalance() {
        return walletBalance;
    }
    
    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }
}

// DigitalWalletTransaction class to handle transactions
class DigitalWalletTransaction {
    
    // Method to add money to the wallet
    public void addMoney(Wallet digitalWallet, int amount) throws TransactionException {
        // Check if user is authorized (has access token)
        if (digitalWallet.getUserAccessToken() == null || digitalWallet.getUserAccessToken().isEmpty()) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }
        
        // Check if amount is valid
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }
        
        // Add money to wallet
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
        System.out.println("Amount added successfully. New balance: " + digitalWallet.getWalletBalance());
    }
    
    // Method to pay money from the wallet
    public void payMoney(Wallet digitalWallet, int amount) throws TransactionException {
        // Check if user is authorized (has access token)
        if (digitalWallet.getUserAccessToken() == null || digitalWallet.getUserAccessToken().isEmpty()) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }
        
        // Check if amount is valid
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }
        
        // Check if sufficient balance exists
        if (digitalWallet.getWalletBalance() < amount) {
            throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
        }
        
        // Deduct money from wallet
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
        System.out.println("Payment successful. Remaining balance: " + digitalWallet.getWalletBalance());
    }
}

// Main class to demonstrate the Digital Wallet System
public class DigitalWallet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DigitalWalletTransaction transaction = new DigitalWalletTransaction();
        
        System.out.println("=== Digital Wallet System ===\n");
        
        // Example 1: Wallet without access token
        System.out.println("Example 1: Wallet without access token");
        Wallet wallet1 = new Wallet("W001", "John Doe");
        System.out.println("Wallet created for: " + wallet1.getUserName());
        System.out.println("Wallet ID: " + wallet1.getWalletId());
        
        try {
            transaction.addMoney(wallet1, 1000);
        } catch (TransactionException e) {
            System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 2: Wallet with access token - successful transactions
        System.out.println("Example 2: Wallet with access token");
        Wallet wallet2 = new Wallet("W002", "Jane Smith", "ACCESS_TOKEN_123");
        System.out.println("Wallet created for: " + wallet2.getUserName());
        System.out.println("Wallet ID: " + wallet2.getWalletId());
        
        try {
            // Add money
            System.out.println("\nAdding money...");
            transaction.addMoney(wallet2, 5000);
            
            // Pay money
            System.out.println("\nMaking payment...");
            transaction.payMoney(wallet2, 2000);
            
        } catch (TransactionException e) {
            System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 3: Invalid amount
        System.out.println("Example 3: Invalid amount (zero or negative)");
        try {
            transaction.addMoney(wallet2, 0);
        } catch (TransactionException e) {
            System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Example 4: Insufficient balance
        System.out.println("Example 4: Insufficient balance");
        try {
            transaction.payMoney(wallet2, 10000);
        } catch (TransactionException e) {
            System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Interactive mode
        System.out.println("Interactive Mode:");
        System.out.print("Enter Wallet ID: ");
        String walletId = scanner.nextLine();
        
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();
        
        System.out.print("Enter Access Token (press Enter to skip): ");
        String accessToken = scanner.nextLine();
        
        Wallet userWallet;
        if (accessToken.isEmpty()) {
            userWallet = new Wallet(walletId, userName);
        } else {
            userWallet = new Wallet(walletId, userName, accessToken);
        }
        
        System.out.println("\nWallet created successfully!");
        System.out.println("Wallet ID: " + userWallet.getWalletId());
        System.out.println("User: " + userWallet.getUserName());
        System.out.println("Has Access Token: " + (userWallet.getUserAccessToken() != null));
        
        boolean continueTransactions = true;
        while (continueTransactions) {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Add Money");
            System.out.println("2. Pay Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to add: ");
                    int addAmount = scanner.nextInt();
                    try {
                        transaction.addMoney(userWallet, addAmount);
                    } catch (TransactionException e) {
                        System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter amount to pay: ");
                    int payAmount = scanner.nextInt();
                    try {
                        transaction.payMoney(userWallet, payAmount);
                    } catch (TransactionException e) {
                        System.out.println("Error: " + e.getMessage() + " (Code: " + e.getErrorCode() + ")");
                    }
                    break;
                    
                case 3:
                    System.out.println("Current Balance: " + userWallet.getWalletBalance());
                    break;
                    
                case 4:
                    continueTransactions = false;
                    System.out.println("Thank you for using Digital Wallet System!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
}

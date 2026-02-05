package practice.Batch1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Custom Exceptions
class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}

class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }
}

class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

// Transaction Model
class Transaction {
    private String transactionId;
    private String userId;
    private String accountId;
    private String type; // DEBIT, CREDIT
    private double amount;
    private LocalDateTime transactionDate;
    private LocalDateTime deletedAt;
    private String description;
    
    public Transaction(String transactionId, String userId, String accountId, String type, 
                      double amount, LocalDateTime transactionDate, String description) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.deletedAt = null;
        this.description = description;
    }
    
    // Getters and Setters
    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public String getAccountId() { return accountId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public LocalDateTime getDeletedAt() { return deletedAt; }
    public String getDescription() { return description; }
    
    public void setDeletedAt(LocalDateTime deletedAt) { 
        this.deletedAt = deletedAt; 
    }
    
    public boolean isDeleted() {
        return deletedAt != null;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Transaction[ID=%s, User=%s, Account=%s, Type=%s, Amount=$%.2f, Date=%s, Description=%s]",
                           transactionId, userId, accountId, type, amount, 
                           transactionDate.format(formatter), description);
    }
}

// Transaction Filter
class TransactionFilter {
    private String accountId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double minAmount;
    private Double maxAmount;
    
    public TransactionFilter() {}
    
    public TransactionFilter setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }
    
    public TransactionFilter setDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }
    
    public TransactionFilter setAmountRange(Double minAmount, Double maxAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        return this;
    }
    
    public boolean matches(Transaction transaction) {
        // Filter by account
        if (accountId != null && !accountId.equals(transaction.getAccountId())) {
            return false;
        }
        
        // Filter by date range
        if (startDate != null && transaction.getTransactionDate().isBefore(startDate)) {
            return false;
        }
        if (endDate != null && transaction.getTransactionDate().isAfter(endDate)) {
            return false;
        }
        
        // Filter by amount range
        if (minAmount != null && transaction.getAmount() < minAmount) {
            return false;
        }
        if (maxAmount != null && transaction.getAmount() > maxAmount) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Filters: ");
        if (accountId != null) sb.append("Account=").append(accountId).append(", ");
        if (startDate != null) sb.append("StartDate=").append(startDate).append(", ");
        if (endDate != null) sb.append("EndDate=").append(endDate).append(", ");
        if (minAmount != null) sb.append("MinAmount=$").append(minAmount).append(", ");
        if (maxAmount != null) sb.append("MaxAmount=$").append(maxAmount);
        return sb.toString();
    }
}

// Pagination Cursor
class PaginationCursor {
    private String cursor; // Last transaction ID from previous page
    private int pageSize;
    
    public PaginationCursor(int pageSize) {
        this.pageSize = pageSize;
        this.cursor = null;
    }
    
    public PaginationCursor(String cursor, int pageSize) {
        this.cursor = cursor;
        this.pageSize = pageSize;
    }
    
    public String getCursor() { return cursor; }
    public int getPageSize() { return pageSize; }
}

// Paginated Response
class PaginatedResponse<T> {
    private List<T> data;
    private String nextCursor;
    private boolean hasMore;
    private int totalReturned;
    
    public PaginatedResponse(List<T> data, String nextCursor, boolean hasMore) {
        this.data = data;
        this.nextCursor = nextCursor;
        this.hasMore = hasMore;
        this.totalReturned = data.size();
    }
    
    public List<T> getData() { return data; }
    public String getNextCursor() { return nextCursor; }
    public boolean hasMore() { return hasMore; }
    public int getTotalReturned() { return totalReturned; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Paginated Response ===\n");
        sb.append("Total Returned: ").append(totalReturned).append("\n");
        sb.append("Has More: ").append(hasMore).append("\n");
        sb.append("Next Cursor: ").append(nextCursor != null ? nextCursor : "null").append("\n");
        sb.append("Data:\n");
        for (int i = 0; i < data.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(data.get(i)).append("\n");
        }
        return sb.toString();
    }
}

// User/Session for Authorization
class UserSession {
    private String userId;
    private String sessionToken;
    private boolean isAdmin;
    
    public UserSession(String userId, String sessionToken, boolean isAdmin) {
        this.userId = userId;
        this.sessionToken = sessionToken;
        this.isAdmin = isAdmin;
    }
    
    public String getUserId() { return userId; }
    public String getSessionToken() { return sessionToken; }
    public boolean isAdmin() { return isAdmin; }
}

// API Response
class ApiResponse<T> {
    private boolean success;
    private T data;
    private String error;
    private String errorCode;
    
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.data = data;
        return response;
    }
    
    public static <T> ApiResponse<T> error(String error, String errorCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.error = error;
        response.errorCode = errorCode;
        return response;
    }
    
    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public String getError() { return error; }
    public String getErrorCode() { return errorCode; }
}

// Transaction History API Service
class TransactionHistoryService {
    private List<Transaction> transactionDatabase;
    private Map<String, UserSession> activeSessions;
    
    public TransactionHistoryService() {
        this.transactionDatabase = new ArrayList<>();
        this.activeSessions = new HashMap<>();
        initializeTestData();
    }
    
    // Initialize with test data
    private void initializeTestData() {
        LocalDateTime now = LocalDateTime.now();
        
        // User1 transactions
        transactionDatabase.add(new Transaction("TXN001", "user1", "ACC001", "CREDIT", 1000.00, now.minusDays(10), "Salary deposit"));
        transactionDatabase.add(new Transaction("TXN002", "user1", "ACC001", "DEBIT", 50.00, now.minusDays(9), "Grocery shopping"));
        transactionDatabase.add(new Transaction("TXN003", "user1", "ACC001", "DEBIT", 200.00, now.minusDays(8), "Utility bill"));
        transactionDatabase.add(new Transaction("TXN004", "user1", "ACC002", "CREDIT", 500.00, now.minusDays(7), "Freelance payment"));
        transactionDatabase.add(new Transaction("TXN005", "user1", "ACC001", "DEBIT", 75.50, now.minusDays(6), "Restaurant"));
        transactionDatabase.add(new Transaction("TXN006", "user1", "ACC001", "CREDIT", 100.00, now.minusDays(5), "Refund"));
        
        // User2 transactions
        transactionDatabase.add(new Transaction("TXN007", "user2", "ACC003", "CREDIT", 2000.00, now.minusDays(10), "Salary deposit"));
        transactionDatabase.add(new Transaction("TXN008", "user2", "ACC003", "DEBIT", 300.00, now.minusDays(9), "Rent payment"));
        transactionDatabase.add(new Transaction("TXN009", "user2", "ACC003", "DEBIT", 150.00, now.minusDays(8), "Shopping"));
        transactionDatabase.add(new Transaction("TXN010", "user2", "ACC003", "CREDIT", 250.00, now.minusDays(7), "Gift received"));
        
        // User1 more recent transactions
        transactionDatabase.add(new Transaction("TXN011", "user1", "ACC001", "DEBIT", 40.00, now.minusDays(4), "Coffee shop"));
        transactionDatabase.add(new Transaction("TXN012", "user1", "ACC001", "DEBIT", 120.00, now.minusDays(3), "Gas station"));
        transactionDatabase.add(new Transaction("TXN013", "user1", "ACC002", "DEBIT", 500.00, now.minusDays(2), "Investment"));
        transactionDatabase.add(new Transaction("TXN014", "user1", "ACC001", "CREDIT", 80.00, now.minusDays(1), "Cashback"));
        transactionDatabase.add(new Transaction("TXN015", "user1", "ACC001", "DEBIT", 25.00, now, "Online purchase"));
        
        // Mark one as deleted (soft delete)
        transactionDatabase.get(2).setDeletedAt(now.minusDays(1)); // TXN003
        
        // Create test user sessions
        activeSessions.put("token_user1", new UserSession("user1", "token_user1", false));
        activeSessions.put("token_user2", new UserSession("user2", "token_user2", false));
        activeSessions.put("token_admin", new UserSession("admin", "token_admin", true));
    }
    
    // Authenticate and get user session
    private UserSession authenticate(String token) throws UnauthorizedException {
        if (token == null || token.isEmpty()) {
            throw new UnauthorizedException("Authentication token is required. Please provide a valid session token.");
        }
        
        UserSession session = activeSessions.get(token);
        if (session == null) {
            throw new UnauthorizedException("Invalid or expired session token. Please login again.");
        }
        
        return session;
    }
    
    // Get transactions with pagination and filters
    public ApiResponse<PaginatedResponse<Transaction>> getTransactions(
            String authToken, 
            TransactionFilter filter, 
            PaginationCursor pagination) {
        
        try {
            // Authenticate user
            UserSession session = authenticate(authToken);
            
            // Validate pagination parameters
            if (pagination.getPageSize() <= 0 || pagination.getPageSize() > 100) {
                throw new InvalidParameterException("Page size must be between 1 and 100");
            }
            
            // Get all non-deleted transactions for the user
            List<Transaction> userTransactions = transactionDatabase.stream()
                .filter(t -> !t.isDeleted()) // deleted_at IS NULL
                .filter(t -> session.isAdmin() || t.getUserId().equals(session.getUserId())) // Authorization
                .filter(filter::matches) // Apply filters
                .sorted((t1, t2) -> t2.getTransactionDate().compareTo(t1.getTransactionDate())) // Sort by date desc
                .collect(Collectors.toList());
            
            // Apply cursor-based pagination
            int startIndex = 0;
            if (pagination.getCursor() != null) {
                // Find the position of the cursor
                for (int i = 0; i < userTransactions.size(); i++) {
                    if (userTransactions.get(i).getTransactionId().equals(pagination.getCursor())) {
                        startIndex = i + 1;
                        break;
                    }
                }
                
                if (startIndex == 0) {
                    throw new InvalidParameterException("Invalid cursor: Transaction not found");
                }
            }
            
            // Get page of results
            int endIndex = Math.min(startIndex + pagination.getPageSize(), userTransactions.size());
            List<Transaction> pageData = userTransactions.subList(startIndex, endIndex);
            
            // Determine if there are more results
            boolean hasMore = endIndex < userTransactions.size();
            String nextCursor = hasMore && !pageData.isEmpty() 
                ? pageData.get(pageData.size() - 1).getTransactionId() 
                : null;
            
            PaginatedResponse<Transaction> response = new PaginatedResponse<>(pageData, nextCursor, hasMore);
            return ApiResponse.success(response);
            
        } catch (UnauthorizedException e) {
            return ApiResponse.error(e.getMessage(), "UNAUTHORIZED");
        } catch (InvalidParameterException e) {
            return ApiResponse.error(e.getMessage(), "INVALID_PARAMETER");
        } catch (Exception e) {
            return ApiResponse.error("An unexpected error occurred: " + e.getMessage(), "INTERNAL_ERROR");
        }
    }
    
    // Get transaction by ID
    public ApiResponse<Transaction> getTransactionById(String authToken, String transactionId) {
        try {
            UserSession session = authenticate(authToken);
            
            Transaction transaction = transactionDatabase.stream()
                .filter(t -> t.getTransactionId().equals(transactionId))
                .filter(t -> !t.isDeleted())
                .filter(t -> session.isAdmin() || t.getUserId().equals(session.getUserId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Transaction not found or you don't have permission to view it"));
            
            return ApiResponse.success(transaction);
            
        } catch (UnauthorizedException e) {
            return ApiResponse.error(e.getMessage(), "UNAUTHORIZED");
        } catch (ResourceNotFoundException e) {
            return ApiResponse.error(e.getMessage(), "NOT_FOUND");
        } catch (Exception e) {
            return ApiResponse.error("An unexpected error occurred: " + e.getMessage(), "INTERNAL_ERROR");
        }
    }
    
    // Get transaction statistics
    public ApiResponse<Map<String, Object>> getTransactionStats(String authToken) {
        try {
            UserSession session = authenticate(authToken);
            
            List<Transaction> userTransactions = transactionDatabase.stream()
                .filter(t -> !t.isDeleted())
                .filter(t -> session.isAdmin() || t.getUserId().equals(session.getUserId()))
                .collect(Collectors.toList());
            
            double totalCredits = userTransactions.stream()
                .filter(t -> t.getType().equals("CREDIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
            
            double totalDebits = userTransactions.stream()
                .filter(t -> t.getType().equals("DEBIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
            
            Map<String, Object> stats = new LinkedHashMap<>();
            stats.put("totalTransactions", userTransactions.size());
            stats.put("totalCredits", totalCredits);
            stats.put("totalDebits", totalDebits);
            stats.put("netBalance", totalCredits - totalDebits);
            
            return ApiResponse.success(stats);
            
        } catch (UnauthorizedException e) {
            return ApiResponse.error(e.getMessage(), "UNAUTHORIZED");
        } catch (Exception e) {
            return ApiResponse.error("An unexpected error occurred: " + e.getMessage(), "INTERNAL_ERROR");
        }
    }
    
    // Helper: Get valid session tokens (for testing)
    public Map<String, UserSession> getActiveSessions() {
        return activeSessions;
    }
}

// Main Class
public class TransactionHistoryApi {
    public static void main(String[] args) {
        TransactionHistoryService api = new TransactionHistoryService();
        
        System.out.println("=== TRANSACTION HISTORY API ===\n");
        
        // Display available sessions
        System.out.println("--- Available Sessions ---");
        api.getActiveSessions().forEach((token, session) -> {
            System.out.println("Token: " + token + " | User: " + session.getUserId() + 
                             " | Admin: " + session.isAdmin());
        });
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 1: Get all transactions for user1 (default pagination)
        System.out.println("TEST 1: Get all transactions for user1 (page size: 5)");
        TransactionFilter filter1 = new TransactionFilter();
        PaginationCursor cursor1 = new PaginationCursor(5);
        
        ApiResponse<PaginatedResponse<Transaction>> response1 = 
            api.getTransactions("token_user1", filter1, cursor1);
        
        if (response1.isSuccess()) {
            System.out.println(response1.getData());
        } else {
            System.out.println("Error: " + response1.getError() + " (Code: " + response1.getErrorCode() + ")");
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 2: Get next page using cursor
        System.out.println("TEST 2: Get next page using cursor from previous response");
        if (response1.isSuccess() && response1.getData().hasMore()) {
            PaginationCursor cursor2 = new PaginationCursor(response1.getData().getNextCursor(), 5);
            ApiResponse<PaginatedResponse<Transaction>> response2 = 
                api.getTransactions("token_user1", filter1, cursor2);
            
            if (response2.isSuccess()) {
                System.out.println(response2.getData());
            }
        } else {
            System.out.println("No more pages available");
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 3: Filter by account
        System.out.println("TEST 3: Filter by account (ACC001)");
        TransactionFilter filter3 = new TransactionFilter().setAccountId("ACC001");
        PaginationCursor cursor3 = new PaginationCursor(10);
        
        ApiResponse<PaginatedResponse<Transaction>> response3 = 
            api.getTransactions("token_user1", filter3, cursor3);
        
        if (response3.isSuccess()) {
            System.out.println(response3.getData());
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 4: Filter by amount range
        System.out.println("TEST 4: Filter by amount range ($50 - $200)");
        TransactionFilter filter4 = new TransactionFilter().setAmountRange(50.0, 200.0);
        PaginationCursor cursor4 = new PaginationCursor(10);
        
        ApiResponse<PaginatedResponse<Transaction>> response4 = 
            api.getTransactions("token_user1", filter4, cursor4);
        
        if (response4.isSuccess()) {
            System.out.println(response4.getData());
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 5: Filter by date range
        System.out.println("TEST 5: Filter by date range (last 5 days)");
        LocalDateTime fiveDaysAgo = LocalDateTime.now().minusDays(5);
        TransactionFilter filter5 = new TransactionFilter().setDateRange(fiveDaysAgo, LocalDateTime.now());
        PaginationCursor cursor5 = new PaginationCursor(10);
        
        ApiResponse<PaginatedResponse<Transaction>> response5 = 
            api.getTransactions("token_user1", filter5, cursor5);
        
        if (response5.isSuccess()) {
            System.out.println(response5.getData());
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 6: Unauthorized access (no token)
        System.out.println("TEST 6: Unauthorized access (no token)");
        ApiResponse<PaginatedResponse<Transaction>> response6 = 
            api.getTransactions("", new TransactionFilter(), new PaginationCursor(10));
        
        if (!response6.isSuccess()) {
            System.out.println("Error: " + response6.getError());
            System.out.println("Error Code: " + response6.getErrorCode());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 7: Invalid token
        System.out.println("TEST 7: Invalid session token");
        ApiResponse<PaginatedResponse<Transaction>> response7 = 
            api.getTransactions("invalid_token", new TransactionFilter(), new PaginationCursor(10));
        
        if (!response7.isSuccess()) {
            System.out.println("Error: " + response7.getError());
            System.out.println("Error Code: " + response7.getErrorCode());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 8: User2 trying to access their transactions
        System.out.println("TEST 8: User2 accessing their own transactions");
        ApiResponse<PaginatedResponse<Transaction>> response8 = 
            api.getTransactions("token_user2", new TransactionFilter(), new PaginationCursor(10));
        
        if (response8.isSuccess()) {
            System.out.println(response8.getData());
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 9: Get transaction by ID
        System.out.println("TEST 9: Get specific transaction by ID (TXN001)");
        ApiResponse<Transaction> response9 = api.getTransactionById("token_user1", "TXN001");
        
        if (response9.isSuccess()) {
            System.out.println("Success: " + response9.getData());
        } else {
            System.out.println("Error: " + response9.getError());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 10: Try to access deleted transaction (should not appear)
        System.out.println("TEST 10: Try to access deleted transaction (TXN003)");
        ApiResponse<Transaction> response10 = api.getTransactionById("token_user1", "TXN003");
        
        if (!response10.isSuccess()) {
            System.out.println("Error: " + response10.getError());
            System.out.println("Error Code: " + response10.getErrorCode());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 11: Get transaction statistics
        System.out.println("TEST 11: Get transaction statistics for user1");
        ApiResponse<Map<String, Object>> response11 = api.getTransactionStats("token_user1");
        
        if (response11.isSuccess()) {
            System.out.println("Transaction Statistics:");
            response11.getData().forEach((key, value) -> {
                if (value instanceof Double) {
                    System.out.println("  " + key + ": $" + String.format("%.2f", (Double) value));
                } else {
                    System.out.println("  " + key + ": " + value);
                }
            });
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Test 12: Admin accessing all transactions
        System.out.println("TEST 12: Admin accessing all transactions");
        ApiResponse<PaginatedResponse<Transaction>> response12 = 
            api.getTransactions("token_admin", new TransactionFilter(), new PaginationCursor(15));
        
        if (response12.isSuccess()) {
            System.out.println(response12.getData());
        }
        
        System.out.println("=".repeat(70) + "\n");
        
        // Test 13: Invalid page size
        System.out.println("TEST 13: Invalid page size (101)");
        ApiResponse<PaginatedResponse<Transaction>> response13 = 
            api.getTransactions("token_user1", new TransactionFilter(), new PaginationCursor(101));
        
        if (!response13.isSuccess()) {
            System.out.println("Error: " + response13.getError());
            System.out.println("Error Code: " + response13.getErrorCode());
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\nAPI demonstration completed successfully!");
        System.out.println("\nNote: Check the curl_scripts folder for helper scripts to test the API.");
    }
}

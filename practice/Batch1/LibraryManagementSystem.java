package practice.Batch1;

import java.util.*;

// Custom Exception: OutOfStockException
class OutOfStockException extends Exception {
    public OutOfStockException(String title) {
        super("Cannot borrow book '" + title + "' as it is out of stock");
    }
}

// Custom Exception: MaxBorrowedBooksException
class MaxBorrowedBooksException extends Exception {
    public MaxBorrowedBooksException(int maxBorrowedBooks) {
        super("Cannot borrow book as you have reached the maximum of " + maxBorrowedBooks + " borrowed books");
    }
}

// Book Class
class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, book is in stock
    }
    
    public Book(String bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
    
    // Getters and Setters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    public void setAvailable(boolean available) { 
        this.isAvailable = available; 
    }
    
    public String getStatus() {
        return isAvailable ? "In Stock" : "Out of Stock";
    }
    
    @Override
    public String toString() {
        return String.format("Book[ID=%s, Title='%s', Author='%s', Status=%s]",
                           bookId, title, author, getStatus());
    }
}

// User/Member Class
class LibraryMember {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private int maxBorrowedBooks;
    
    public LibraryMember(String memberId, String name, int maxBorrowedBooks) {
        this.memberId = memberId;
        this.name = name;
        this.maxBorrowedBooks = maxBorrowedBooks;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getMaxBorrowedBooks() { return maxBorrowedBooks; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    
    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }
    
    public boolean canBorrowMore() {
        return borrowedBooks.size() < maxBorrowedBooks;
    }
    
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    
    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }
    
    @Override
    public String toString() {
        return String.format("Member[ID=%s, Name='%s', Borrowed=%d/%d]",
                           memberId, name, borrowedBooks.size(), maxBorrowedBooks);
    }
}

// Library Class
class Library {
    private String libraryName;
    private Map<String, Book> books;
    private Map<String, LibraryMember> members;
    
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }
    
    // Add a new book to the library
    public void addBook(String bookId, String title, String author) {
        if (books.containsKey(bookId)) {
            System.out.println("Book with ID " + bookId + " already exists.");
            return;
        }
        
        Book book = new Book(bookId, title, author);
        books.put(bookId, book);
        System.out.println("Book added successfully: " + book.getTitle());
    }
    
    // Add a new book with availability status
    public void addBook(String bookId, String title, String author, boolean isAvailable) {
        if (books.containsKey(bookId)) {
            System.out.println("Book with ID " + bookId + " already exists.");
            return;
        }
        
        Book book = new Book(bookId, title, author, isAvailable);
        books.put(bookId, book);
        System.out.println("Book added successfully: " + book.getTitle() + " [" + book.getStatus() + "]");
    }
    
    // Register a new member
    public void registerMember(String memberId, String name, int maxBorrowedBooks) {
        if (members.containsKey(memberId)) {
            System.out.println("Member with ID " + memberId + " already exists.");
            return;
        }
        
        LibraryMember member = new LibraryMember(memberId, name, maxBorrowedBooks);
        members.put(memberId, member);
        System.out.println("Member registered successfully: " + name);
    }
    
    // Borrow a book
    public void borrowBook(String memberId, String bookId) throws OutOfStockException, MaxBorrowedBooksException {
        // Check if member exists
        LibraryMember member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
            return;
        }
        
        // Check if book exists
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        
        // Check if book is available
        if (!book.isAvailable()) {
            throw new OutOfStockException(book.getTitle());
        }
        
        // Check if member has reached maximum borrowed books
        if (!member.canBorrowMore()) {
            throw new MaxBorrowedBooksException(member.getMaxBorrowedBooks());
        }
        
        // Check if member already borrowed this book
        if (member.hasBorrowedBook(book)) {
            System.out.println("You have already borrowed this book.");
            return;
        }
        
        // Borrow the book
        member.borrowBook(book);
        book.setAvailable(false);
        System.out.println("Book borrowed successfully: '" + book.getTitle() + "' by " + member.getName());
    }
    
    // Return a book
    public void returnBook(String memberId, String bookId) {
        // Check if member exists
        LibraryMember member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
            return;
        }
        
        // Check if book exists
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        
        // Check if member has borrowed this book
        if (!member.hasBorrowedBook(book)) {
            System.out.println("This book was not borrowed by " + member.getName());
            return;
        }
        
        // Return the book
        member.returnBook(book);
        book.setAvailable(true);
        System.out.println("Book returned successfully: '" + book.getTitle() + "' by " + member.getName());
    }
    
    // View all books in inventory
    public void viewInventory() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        
        System.out.println("\n=== " + libraryName + " - Library Inventory ===");
        System.out.println("\n--- Available Books ---");
        
        List<Book> availableBooks = new ArrayList<>();
        List<Book> borrowedBooks = new ArrayList<>();
        
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            } else {
                borrowedBooks.add(book);
            }
        }
        
        if (availableBooks.isEmpty()) {
            System.out.println("No available books.");
        } else {
            for (int i = 0; i < availableBooks.size(); i++) {
                System.out.println((i + 1) + ". " + availableBooks.get(i));
            }
        }
        
        System.out.println("\n--- Borrowed Books ---");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedBooks.get(i));
            }
        }
        
        System.out.println("\nTotal Books: " + books.size() + 
                         " | Available: " + availableBooks.size() + 
                         " | Borrowed: " + borrowedBooks.size());
        System.out.println("=".repeat(50));
    }
    
    // View member's borrowed books
    public void viewMemberBooks(String memberId) {
        LibraryMember member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
            return;
        }
        
        System.out.println("\n=== Borrowed Books - " + member.getName() + " ===");
        List<Book> borrowedBooks = member.getBorrowedBooks();
        
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + borrowedBooks.get(i));
            }
        }
        
        System.out.println("\nBorrowed: " + member.getBorrowedBooksCount() + 
                         "/" + member.getMaxBorrowedBooks());
        System.out.println("=".repeat(50));
    }
    
    // Get book by ID
    public Book getBook(String bookId) {
        return books.get(bookId);
    }
    
    // Get member by ID
    public LibraryMember getMember(String memberId) {
        return members.get(memberId);
    }
    
    // Get all books
    public Collection<Book> getAllBooks() {
        return books.values();
    }
    
    // Get all members
    public Collection<LibraryMember> getAllMembers() {
        return members.values();
    }
    
    public String getLibraryName() {
        return libraryName;
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===\n");
        
        // Create library
        Library library = new Library("Central City Library");
        
        // Add sample books
        System.out.println("--- Initializing Library ---");
        library.addBook("B001", "To Kill a Mockingbird", "Harper Lee");
        library.addBook("B002", "1984", "George Orwell");
        library.addBook("B003", "The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("B004", "Pride and Prejudice", "Jane Austen");
        library.addBook("B005", "The Catcher in the Rye", "J.D. Salinger");
        library.addBook("B006", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", false); // Out of stock
        
        System.out.println();
        
        // Register members
        System.out.println("--- Registering Members ---");
        library.registerMember("M001", "Alice Johnson", 3);
        library.registerMember("M002", "Bob Smith", 2);
        library.registerMember("M003", "Charlie Brown", 5);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: View initial inventory
        System.out.println("DEMO 1: View Initial Library Inventory");
        library.viewInventory();
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: Successful book borrowing
        System.out.println("DEMO 2: Borrow Books Successfully");
        try {
            library.borrowBook("M001", "B001");
            library.borrowBook("M001", "B002");
            library.borrowBook("M002", "B003");
        } catch (OutOfStockException | MaxBorrowedBooksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: View inventory after borrowing
        System.out.println("DEMO 3: View Inventory After Borrowing");
        library.viewInventory();
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: View member's borrowed books
        System.out.println("DEMO 4: View Member's Borrowed Books");
        library.viewMemberBooks("M001");
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: Try to borrow out-of-stock book
        System.out.println("DEMO 5: Try to Borrow Out-of-Stock Book");
        try {
            library.borrowBook("M002", "B006");
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MaxBorrowedBooksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: Try to exceed maximum borrowed books
        System.out.println("DEMO 6: Try to Exceed Maximum Borrowed Books");
        try {
            library.borrowBook("M002", "B004"); // Bob's 2nd book
            library.borrowBook("M002", "B005"); // Bob's 3rd book (should fail - max is 2)
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MaxBorrowedBooksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: Return a book
        System.out.println("DEMO 7: Return a Book");
        library.returnBook("M001", "B001");
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: View inventory after return
        System.out.println("DEMO 8: View Inventory After Return");
        library.viewInventory();
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Demonstration: Borrow the returned book
        System.out.println("DEMO 9: Borrow Previously Returned Book");
        try {
            library.borrowBook("M003", "B001");
        } catch (OutOfStockException | MaxBorrowedBooksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Interactive Mode
        System.out.println("=== INTERACTIVE MODE ===\n");
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Library Inventory");
            System.out.println("6. View Member's Borrowed Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.println();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Is book available? (yes/no): ");
                        String availStr = scanner.nextLine();
                        boolean isAvailable = availStr.equalsIgnoreCase("yes");
                        
                        library.addBook(bookId, title, author, isAvailable);
                        break;
                        
                    case 2:
                        System.out.print("Enter Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter Member Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Max Borrowed Books: ");
                        int maxBooks = scanner.nextInt();
                        scanner.nextLine();
                        
                        library.registerMember(memberId, name, maxBooks);
                        break;
                        
                    case 3:
                        System.out.print("Enter Member ID: ");
                        String borrowMemberId = scanner.nextLine();
                        System.out.print("Enter Book ID: ");
                        String borrowBookId = scanner.nextLine();
                        
                        library.borrowBook(borrowMemberId, borrowBookId);
                        break;
                        
                    case 4:
                        System.out.print("Enter Member ID: ");
                        String returnMemberId = scanner.nextLine();
                        System.out.print("Enter Book ID: ");
                        String returnBookId = scanner.nextLine();
                        
                        library.returnBook(returnMemberId, returnBookId);
                        break;
                        
                    case 5:
                        library.viewInventory();
                        break;
                        
                    case 6:
                        System.out.print("Enter Member ID: ");
                        String viewMemberId = scanner.nextLine();
                        library.viewMemberBooks(viewMemberId);
                        break;
                        
                    case 7:
                        running = false;
                        System.out.println("Thank you for using " + library.getLibraryName() + "!");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (OutOfStockException | MaxBorrowedBooksException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear buffer
            }
        }
        
        scanner.close();
    }
}

package src.Association;

public class Book {

	private String bookId;
	
	private String title;
	
	private String author;
	
	private String price;
	
	Book(){
		
	}
	
	public Book(String bookId, String title, String author, String price) {
	
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPrice() {
		return price;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDetials() {
		return "Book Id : "+bookId+" Title : "+title+" Author : "+author+" Price : "+price;
	}

	
	
	
	
}

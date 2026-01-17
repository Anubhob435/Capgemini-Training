package src.Association;


public class Library {

	private String name;
	private String location;
	private String address;
	private String pincode;
	
	private Book[] book;
	
	
	public Book[] addBook(int size) {
		return new Book[size];
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getAddress() {
		return address;
	}

	public String getPincode() {
		return pincode;
	}

	public Book[] getBook() {
		return book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setBook(Book[] book) {
		this.book = book;
	}
	
	public String getLibraryDetials() {
		return "Name "+name+" Location "+location+" Address "+address+" Pincode : "+pincode; 
	}
	
}
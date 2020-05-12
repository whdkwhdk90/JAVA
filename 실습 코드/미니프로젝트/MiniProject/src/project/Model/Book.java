package project.Model;

public class Book {

	private String author;
	private String title;
	private String price;
	private int count =0;
	
	public Book(String author, String title, String price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return title;
	}

}

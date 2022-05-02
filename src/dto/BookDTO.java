package dto;

public class BookDTO {
	public int book_id;
	public String book_title;
	public int book_price;
	public int book_inventory;
	public String book_author;
	public String book_publisher;
	public String book_genre;
	public String book_country;
	public int book_publishyear;
	public String book_language;
	
	public int likecnt;

	public BookDTO(String book_title, int book_price, int book_inventory, String book_author,
			String book_publisher, String book_genre, String book_country, int book_publishyear,
			String book_language) {
		this.book_title = book_title;
		this.book_price = book_price;
		this.book_inventory = book_inventory;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_genre = book_genre;
		this.book_country = book_country;
		this.book_publishyear = book_publishyear;
		this.book_language = book_language;
		this.likecnt = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BookDTO) {
			BookDTO target = (BookDTO)obj;
			return target.hashCode() == this.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return book_id;
	}
	
	@Override
	public String toString() {
		return book_id+"\t"+book_title+"\t"+book_price+"\t"+
	book_inventory+"\t"+book_author+"\t"+book_publisher+
	"\t"+book_genre+"\t"+book_country+"\t"+book_publishyear+"\t"+
	book_language+"\t"+likecnt;
	}
}












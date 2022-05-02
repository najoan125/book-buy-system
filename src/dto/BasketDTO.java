package dto;

public class BasketDTO {
	public int basket_id;
	
	public String user_id;	//FK(Foreign Key)
	public int book_id;		//FK(Foreign Key)

	public BasketDTO(String user_id, int book_id) {
		this.user_id = user_id;
		this.book_id = book_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BasketDTO) {
			BasketDTO target = (BasketDTO)obj;
			return target.hashCode() == this.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return basket_id;
	}
	
	@Override
	public String toString() {
		return user_id+"\t"+book_id;
	}
}












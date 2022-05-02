package dto;

public class OrdersDTO {
	public int order_id;
	public String order_check;
	public java.sql.Timestamp order_buydate;
	
	public String user_id;	//FK(Foreign Key)
	public int book_id;		//FK(Foreign Key)

	public OrdersDTO(String order_check, java.sql.Timestamp order_buydate, String user_id, int book_id) {
		this.order_check = order_check;
		this.order_buydate = order_buydate;
		this.user_id = user_id;
		this.book_id = book_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OrdersDTO) {
			OrdersDTO target = (OrdersDTO)obj;
			return target.hashCode() == this.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return order_id;
	}
	
	@Override
	public String toString() {
		return order_id+"\t"+order_check+"\t"+order_buydate+"\t"+user_id+"\t"+book_id;
	}
}












package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.OrdersDTO;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public OrderDAO() {
		conn = DBConnection.getConnection();
	}
//	(int order_id, String order_check, java.sql.Timestamp order_buydate, String user_id, int book_id)
	public boolean addOrder(OrdersDTO orders) {
		String sql = "insert into orders (order_check, order_buydate, user_id, book_id)"
				+ "values(?, ? ,? ,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, orders.order_check);
			ps.setTimestamp(2, orders.order_buydate);
			ps.setString(3, orders.user_id);
			ps.setInt(4,orders.book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}

	public String getOrderList() {
		String sql = "select * from orders where user_id = ?";
		String result = "주문 번호\t주문 현황\t주문 날짜\t\t책 아이디\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getDate(3) + "\t";
				result += rs.getInt(4) + "\n";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}

	public boolean modifyOrder(int order_id) {
		String sql = "update orders set order_check=? where order_id=?";
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "배송 완료");
			ps.setInt(2, order_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
			
		return false;
	}
	
	public boolean cancelOrder(int order_id) {
		String sql = "delete from orders where order_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
}



















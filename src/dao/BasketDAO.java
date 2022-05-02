package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.BasketDTO;

public class BasketDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BasketDAO() {
		conn = DBConnection.getConnection();
	}
//	(int order_id, String order_check, java.sql.Timestamp order_buydate, String user_id, int book_id)
	public boolean addBasket(BasketDTO basket) {
		String sql = "insert into basket (user_id, book_id)"
				+ "values(? ,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, basket.user_id);
			ps.setInt(2,basket.book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}

	public String getBasketList() {
		String sql = "select * from basket where user_id = ?";
		String result = "장바구니 번호\t책 아이디\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result += rs.getInt(1) + "\t\t";
				result += rs.getInt(2) + "\n";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}
	
	public boolean deleteBasket(int basket_id) {
		String sql = "delete from basket where basket_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, basket_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
}



















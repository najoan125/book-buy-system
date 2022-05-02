package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.BookDTO;

public class BookDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BookDAO() {
		conn = DBConnection.getConnection();
	}
	
	
	public boolean addBook(BookDTO book) {
		String sql = "insert into book (book_title,book_price,book_inventory,book_author,"
				+ "book_publisher,book_genre,book_country,book_publishyear,book_language)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.book_title);
			ps.setInt(2, book.book_price);
			ps.setInt(3, book.book_inventory);
			ps.setString(4, book.book_author);
			ps.setString(5, book.book_publisher);
			ps.setString(6, book.book_genre);
			ps.setString(7, book.book_country);
			ps.setInt(8, book.book_publishyear);
			ps.setString(9, book.book_language);
			
			return ps.executeUpdate() == 1;
		}  catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
		return false;
	}
	
	public String getBookList(int book_id) {
		String sql = "select * from book where book_id = ?";
		String result = "책 아이디\t책 제목\t책 가격\t책 재고\t책 작가\t책 출판사\t책 장르\t출판 국가\t출판 년도\t사용 언어\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getInt(3) + "\t";
				result += rs.getInt(4) + "\t";
				result += rs.getString(5) + "\t";
				result += rs.getString(6) + "\t";
				result += rs.getString(7) + "\t";
				result += rs.getString(8) + "\t";
				result += rs.getInt(9) + "\t";
				result += rs.getString(10) + "\n";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}

	public boolean removeBasketBook(int book_id) {
		String sql = "delete from basket where book_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
	
	public boolean removeOrderBook(int book_id) {
		String sql = "delete from orders where book_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
	
	public boolean removeBook(int book_id) {
		removeBasketBook(book_id);
		removeOrderBook(book_id);
		String sql = "delete from book where book_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}

	public boolean modifyBook(int book_id, int choice, String newData) {
		String[] cols = {"book_title","book_price","book_inventory","book_author","book_publisher","book_genre","book_country","book_publishyear","book_language"};
		String sql = "update book set "+ cols[choice-1] +"=? where book_id=?";
				
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setInt(2, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
			
		return false;
	}

	public String titleSearch(String keyword) {
		String sql = "select * from book where book_title like ?";
		String result = "책 아이디\t책 제목\t책 가격\t책 재고\t책 작가\t책 출판사\t책 장르\t출판 국가\t출판 년도\t사용 언어\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getInt(3) + "\t";
				result += rs.getInt(4) + "\t";
				result += rs.getString(5) + "\t";
				result += rs.getString(6) + "\t";
				result += rs.getString(7) + "\t";
				result += rs.getString(8) + "\t";
				result += rs.getInt(9) + "\t";
				result += rs.getString(10) + "\n";
			}
			else {
				result = "none";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}
	
	public String authorSearch(String keyword) {
		String sql = "select * from book where book_author like ?";
		String result = "책 아이디\t책 제목\t책 가격\t책 재고\t책 작가\t책 출판사\t책 장르\t출판 국가\t출판 년도\t사용 언어\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getString(3) + "\t";
				result += rs.getString(4) + "\t";
				result += rs.getString(5) + "\t";
				result += rs.getString(6) + "\t";
				result += rs.getString(7) + "\t";
				result += rs.getString(8) + "\t";
				result += rs.getString(9) + "\t";
				result += rs.getString(10) + "\n";
			}
			else {
				result = "none";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}
	
	public String publisherSearch(String keyword) {
		String sql = "select * from book where book_publisher like ?";
		String result = "책 아이디\t책 제목\t책 가격\t책 재고\t책 작가\t책 출판사\t책 장르\t출판 국가\t출판 년도\t사용 언어\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getString(3) + "\t";
				result += rs.getString(4) + "\t";
				result += rs.getString(5) + "\t";
				result += rs.getString(6) + "\t";
				result += rs.getString(7) + "\t";
				result += rs.getString(8) + "\t";
				result += rs.getString(9) + "\t";
				result += rs.getString(10) + "\n";
			}
			else {
				result = "none";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}
	
	public String genreSearch(String keyword) {
		String sql = "select * from book where book_genre like ?";
		String result = "책 아이디\t책 제목\t책 가격\t책 재고\t책 작가\t책 출판사\t책 장르\t출판 국가\t출판 년도\t사용 언어\n\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result += rs.getString(1) + "\t";
				result += rs.getString(2) + "\t";
				result += rs.getString(3) + "\t";
				result += rs.getString(4) + "\t";
				result += rs.getString(5) + "\t";
				result += rs.getString(6) + "\t";
				result += rs.getString(7) + "\t";
				result += rs.getString(8) + "\t";
				result += rs.getString(9) + "\t";
				result += rs.getString(10) + "\n";
			}
			else {
				result = "none";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}
	public boolean clickLike(int book_id) {
		String sql = "update book set likecnt = likecnt + 1 where book_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
	public boolean purchasedBook(int book_id) {
		String sql = "update book set book_inventory = book_inventory - 1 where book_id = ? and book_inventory > 0";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
}



















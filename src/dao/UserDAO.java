package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean join(UserDTO user) {
		String sql = "insert into user (user_id,user_pw,user_name,user_email,user_phonenum,user_addr) "
				+ "values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.user_id);
			ps.setString(2, user.user_pw);
			ps.setString(3, user.user_name);
			ps.setString(4, user.user_email);
			ps.setString(5, user.user_phonenum);
			ps.setString(6, user.user_addr);
			
			return ps.executeUpdate() == 1;
		}  catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
		return false;
	}

	public boolean checkDup(String user_id) {
		String sql = "select * from user where user_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);//select * from user where user_id='apple'
			
			rs = ps.executeQuery();
			
			//rs.next()는 더이상 데이터가 존재하지 않으면 false / 데이터가 존재한다면 true
			return !rs.next();
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
		return false;
	}
	
	public boolean login(String user_id, String user_pw) {
		String sql = "select * from user where user_id=? and user_pw=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_pw);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Session.put("login_id", user_id);
//				밑에 줄 이건 user_idx 어디서 어디로 가져오는건지 모르겠음.
//				Session.put("login_idx", rs.getInt("user_idx")+"");
				return true;
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
		return false;
	}

	public String myInfo() {
		String sql = "select * from user where user_id = ?";
		String result = "";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				 result += "아이디 :\t" + rs.getString(1) + "\n";
	             result += "비밀번호 :\t" + rs.getString(6) + "\n";
	             result += "이름 :\t" + rs.getString(4) + "\n";
	             result += "이메일 :\t" + rs.getString(2) + "\n";
	             result += "핸드폰번호 :\t" + rs.getString(3) + "\n";
	             result += "주소 :\t" + rs.getString(5) + "\n";
			}
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return result;
	}

	public boolean modifyUser(int col, String newData) {
		//col : 1-비밀번호 수정 / 2-핸드폰 번호 수정 / 3-주소 수정 / 4. 이메일 수정
		//1 : update user set user_pw = 'abcd1234' where user_id='apple'
		//2 : update user set user_phonenum = '01011111111' where user_id='apple'
		String[] cols = {"user_pw","user_phonenum","user_addr","user_email"};
		String sql = "update user set "+ cols[col-1] +"=? where user_id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, Session.get("login_id"));
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : "+sqle);
		}
		
		return false;
	}

	public boolean checkPw(String user_pw) {
		String sql = "select * from user where user_id = ? and user_pw = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			ps.setString(2, user_pw);
			
			rs = ps.executeQuery();
			
			return rs.next();
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}

	public boolean leaveBasketId() {
		String sql = "delete from basket where user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean leaveOrderId() {
		String sql = "delete from orders where user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
	
	public boolean leaveId() {
		leaveBasketId();
		leaveOrderId();
		String sql = "delete from user where user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Session.get("login_id"));
			
			return ps.executeUpdate() == 1;
		} catch (SQLException sqle) {
			System.out.println("쿼리 수행 실패 : " + sqle);
		}
		return false;
	}
}











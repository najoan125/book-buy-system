package dto;

public class UserDTO {
	//Alt + Shift + A : 그리드 편집 모드(여러줄 동시에 편집)
	public String user_id;
	public String user_pw;
	public String user_name;
	public String user_email;
	public String user_phonenum;
	public String user_addr;
	
	public UserDTO(String user_id, String user_pw, String user_name, String user_email, String user_phonenum, String user_addr) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phonenum = user_phonenum;
		this.user_addr = user_addr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UserDTO) {
			UserDTO target = (UserDTO)obj;
			
			if(target.user_id.equals(this.user_id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return user_id+"\t"+user_pw+"\t"+user_name+
				"\t"+user_phonenum+"\t"+user_addr+"\t"+user_email;
	}
}














package Board1;

public class Member {//ȸ������ Ʋ

	private String userName;
	private String userId;
	private String userPw;
	
	public Member(String userName, String userId, String userPw) {
//		������ �Ѱܹ��� ���� this�� �����ϰ� ��
		this.userName=userName;  //this�� ���̸� ������ �� MemberŬ������ userName�� �ν���?
		this.userId=userId;
		this.userPw=userPw;
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	
	

	
	
}
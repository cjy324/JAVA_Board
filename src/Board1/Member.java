package Board1;

public class Member {//회원가입 틀

	private String userName;
	private String userId;
	private String userPw;
	
	public Member(String userName, String userId, String userPw) {
//		위에서 넘겨받은 값을 this에 셋팅하게 됨
		this.userName=userName;  //this를 붙이면 무조건 위 Member클래스의 userName을 인식함?
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
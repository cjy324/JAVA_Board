package Board1;

import java.util.ArrayList;

public class Article {

	private int tNumber;  //private=접근제어자(함부로 작동할 수 없게끔 막는 것)
	private String title;
	private String body;
	private String writer;  //요구사항 11-2
	private String regDate; //요구사항 11-3
	ArrayList<Reply> replies=new ArrayList<>(); //요구사항12

	
	
	public void addReply(Reply reply) {
		replies.add(reply);		
	}
	public ArrayList<Reply> getReplies() {
		return replies;
	}
	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}

	
	
	//캡슐화
	 
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String wtiter) {
		this.writer = wtiter;
	}
	public int getTNumber() {  //getter 가져오는 것
		return tNumber;
	}
	public void setTNumber(int tNumber) {  //setter  가져올 것
		this.tNumber = tNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	

	
	
}

//캡슐화
//자료구조를 처리하는 알고리즘 =메서드
//알고리즘에 의해 자료구조가 변화할 수 있음
//알고리즘이 자료구조(데이터를)바꿀 수 없도록 보호하는 것이 캡슐화
//	int tNumber;
//	String title;
//	String body;
//	는 누구나 바꿀 수 있음 캡슐화 할 필요가 있음
package Board1;

import java.util.ArrayList;

public class Article {

	private int tNumber;  //private=����������(�Ժη� �۵��� �� ���Բ� ���� ��)
	private String title;
	private String body;
	private String writer;  //�䱸���� 11-2
	private String regDate; //�䱸���� 11-3
	ArrayList<Reply> replies=new ArrayList<>(); //�䱸����12

	
	
	public void addReply(Reply reply) {
		replies.add(reply);		
	}
	public ArrayList<Reply> getReplies() {
		return replies;
	}
	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}

	
	
	//ĸ��ȭ
	 
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
	public int getTNumber() {  //getter �������� ��
		return tNumber;
	}
	public void setTNumber(int tNumber) {  //setter  ������ ��
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

//ĸ��ȭ
//�ڷᱸ���� ó���ϴ� �˰��� =�޼���
//�˰��� ���� �ڷᱸ���� ��ȭ�� �� ����
//�˰����� �ڷᱸ��(�����͸�)�ٲ� �� ������ ��ȣ�ϴ� ���� ĸ��ȭ
//	int tNumber;
//	String title;
//	String body;
//	�� ������ �ٲ� �� ���� ĸ��ȭ �� �ʿ䰡 ����
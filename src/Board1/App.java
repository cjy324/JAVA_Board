package Board1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class App {//�ٽɷ��� �и�
	//���� Board1�� �ִ� ���� ������ static���� ���� ���������� ����
	//���� �� ���α׷��� Ȯ�强,�������� ���� �ٽɷ����� �����ϰ� ���� �и�

	ArticleDao aDao=new ArticleDao();  //�и��� Dao�� ���� �ִ� ������ �������� ���� ��ü �����
	MemberDao mDao=new MemberDao();  //�и��� Dao�� ���� �ִ� ������ �������� ���� ��ü �����
	Member loginedMember=null;  //�䱸����11-1 �α����� ���¶�� ���� ��� ���������־�� ��

	
	public void start(){ //non-static �żҵ�

	
	Scanner sc=new Scanner(System.in);		
	
//	int a=1; //�䱸����3   //�䱸����7-2�� ���� �ʿ� ������
	
	while(true) {  //�䱸����1-1
		String s=sc.nextLine();
	if(s.equals("exit")){
		System.out.println("����");
		break;
	}
	else if(s.equals("add")){  //�䱸����1-2
		
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		System.out.println("������ �Է��ϼ���: ");
		String title=sc.nextLine();
		System.out.println("������ �Է��ϼ���: ");
		String body=sc.nextLine();
		
//		tNumbers.add(a);//�䱸����3
//		a++;
//		titles.add(title);
//		bodies.add(body);
		
		Article article=new Article();  //�䱸����7-2
		
		article.setTitle(title);
		article.setBody(body);
		article.setWriter(loginedMember.getUserName());  //�䱸����11-2

		//�䱸����11-3
//		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
//		Date time= new Date();
//		String time1 = format1.format(time);
//		article.setRegDate(time1);

		article.setRegDate(getCurrentDate());

		
		aDao.addArticle(article);  //dao���� article �߰��ض� ��Ű�� ��
		}	
	}
	else if(s.equals("list")){  //�䱸����1-3
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		ArrayList<Article> articles=aDao.getArticles(); //dao���� ��ü article �����Ͷ� ��Ű�� ��

		printArticles(articles);  //�ߺ�����
		
//		for(int i=0; i<articles.size(); i++) {
//		Article article = articles.get(i); //�䱸����7-4
//		System.out.println("��ȣ: "+article.getTNumber());
//		System.out.println("����: "+article.getTitle());
//		System.out.println("�ۼ���: "+article.getWriter()); //�䱸����11-2
//		System.out.println("--------------");
//		}
		}
	}
	
	else if(s.equals("read")){  //�䱸����4
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		System.out.println("������ �Խù� ��ȣ �Է�: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=dao.getIndexByTNum(tNum);   //dao���� ��Ź->�ʿ����
		Article article=aDao.getArticleByTNum(tNum);
		
		
//		for(int i=0; i<tNumbers.size(); i++) {    //�䱸����7 �ߺ� ����
//			if(index==-1){
			if(article==null){		//dao�� �ش� �Խù��� ������ null
				System.out.println("���� �Խù��Դϴ�.");
			}
			else{		
				printArticle(article);  //�ߺ�����
//				Article article = articles.get(index); //�䱸����7-4
//				System.out.println("��ȣ: "+article.getTNumber());
//				System.out.println("����: "+article.getTitle());
//				System.out.println("����: "+article.getBody());
//				System.out.println("�ۼ���: "+article.getWriter());
//				System.out.println("�ۼ���: "+article.getRegDate());
//				System.out.println("----�󼼺���(reply:���, back:�ڷΰ���)----");	
//				
			}
			while(true) {  //�䱸����12
			System.out.println("�󼼺��� ��ɾ� �Է�(reply : ���,  back : �ڷΰ���)");
			String dcmd = sc.nextLine();
			if(dcmd.equals("back")) {
				break;
			}
			else if(dcmd.equals("reply")){	
				Reply reply=new Reply();
				System.out.println("��� ������ �Է����ּ���.");
				String rbody = sc.nextLine();
				reply.setBody(rbody);
				reply.setWriter(loginedMember.getUserName());
				reply.setRegDate(getCurrentDate());
				article.addReply(reply);
				System.out.println("����� ��ϵǾ����ϴ�.");
				printArticle(article);
			}
			}
			
			
			
			
			
			
			
			
			
			}
		
			
//			else if(tNum != tNumbers.get(i));{
//				System.out.println("������ �Խù��� �����ϴ�.");
//
//			}  ??? �� �ȸ�����...
//		}
	}
	else if(s.equals("update")){  //�䱸����5
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		System.out.println("������ �Խù� ��ȣ �Է�: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=getIndexByTNum(tNum);
		Article article=aDao.getArticleByTNum(tNum);
		
//		for(int i=0; i<tNumbers.size(); i++) {   //�䱸����7 �ߺ� ����
//			if(tNum==tNumbers.get(i));{
//		if(index==-1){
		if(article==null){		//dao�� �ش� �Խù��� ������ null
			System.out.println("���� �Խù��Դϴ�.");
		}
		else {
				System.out.println("���ο� ����");
				String title=sc.nextLine();	
				System.out.println("���ο� ����");
				String body=sc.nextLine();
				
//				Article article = articles.get(index); //�䱸����7-2 ����ȭ
				article.setTitle(title);
				article.setBody(body);
				
//				articles.set(index, article);
				aDao.updateArticle(tNum, article);
				
//				titles.set(index, title);   //ArrayList �迭 ���� ��ɾ�
//				bodies.set(index, body);
		}
	
	
		}
	}
	else if(s.equals("delete")){  //�䱸����6
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		System.out.println("������ �Խù� ��ȣ �Է�: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=getIndexByTNum(tNum);
		Article article=aDao.getArticleByTNum(tNum);
		
//		for(int i=0; i<tNumbers.size(); i++) {   //�䱸����7 �ߺ� ����
//			if(tNum==tNumbers.get(i));{
//		if(index==-1){
		if(article==null){		//dao�� �ش� �Խù��� ������ null
			System.out.println("���� �Խù��Դϴ�.");

		}else {
//				tNumbers.remove(index); //ArrayList �迭 ���� ��ɾ�
//				titles.remove(index);  
//				bodies.remove(index);
									
//				articles.remove(index);
			aDao.deleteArticle(article);
				
				
				
			} 
		}
		}
	else if(s.equals("search")){    //�䱸����8
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		System.out.println("�˻�� �Է����ּ���. ");
		String keyword=sc.nextLine();
		
		ArrayList<Article> articles=aDao.getArticles(); //dao���� ��ü article �����Ͷ� ��Ű�� ��
	
		//���� ���ο� �Խù� ����Ʈ ����� //�䱸���� 11-2�� �ߺ�����
		//��, searchedArticles�� ���ο� �迭����Ʈ�� ���� �װ���  printArticles�ϵ��� �ϴ� ����
		ArrayList<Article> searchedArticles=new ArrayList<>();
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //�䱸����7-4
		if(article.getTitle().contains(keyword)) {
			searchedArticles.add(article); //�ߺ�����
//			System.out.println("��ȣ: "+article.getTNumber());
//			System.out.println("����: "+article.getTitle());
//			System.out.println("--------------");		
		}		
		}
		printArticles(searchedArticles);  //�ߺ�����

		}
	}
	else if(s.equals("sort")){    //�䱸����13
		System.out.println("���� ����� �������ּ���. (id:��ȣ)");
		String sortTarget=sc.nextLine();
		System.out.println("���� ����� �������ּ���. (asc:�������� / desc:��������)");
		String sortType=sc.nextLine();
		
		ArrayList<Article> articles=aDao.getArticles(); //dao���� ��ü article �����Ͷ� ��Ű�� ��
	
		//���� ���ο� �Խù� ����Ʈ ����� //�䱸���� 11-2�� �ߺ�����
		//��, searchedArticles�� ���ο� �迭����Ʈ�� ���� �װ���  printArticles�ϵ��� �ϴ� ����
		ArrayList<Article> searchedArticles=new ArrayList<>();
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //�䱸����7-4
		if(article.getTitle().contains(keyword)) {
			searchedArticles.add(article); //�ߺ�����
//			System.out.println("��ȣ: "+article.getTNumber());
//			System.out.println("����: "+article.getTitle());
//			System.out.println("--------------");		
		}		
		}
		printArticles(searchedArticles);  //�ߺ�����

		
	}
	
	
	else if(s.equals("signup")){  //�䱸����9
		System.out.println("�̸��� �Է��ϼ���: ");
		String userName=sc.nextLine();
		System.out.println("����Ͻ� ���̵��� �Է��ϼ���: ");
		String userId=sc.nextLine();
		System.out.println("����Ͻ� ��й�ȣ�� �Է��ϼ���: ");
		String userPw=sc.nextLine();
		
		Member member=new Member(userName, userId, userPw);  
		
//		member.setUserName(userName);    //�� �������� ���� �ʿ� ����
//		member.setUserId(userId);
//		member.setUserPw(userPw);
		
		mDao.addMember(member);  //mDao���� �߰��ض� ��Ű�� ��
		
	}
	else if(s.equals("memberlist")){  //ȸ������Ʈ �ҷ�����
		if(loginedMember==null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
		}else {
		ArrayList<Member> members=mDao.getMembers(); //dao���� ��ü article �����Ͷ� ��Ű�� ��
		for(int i=0; i<members.size(); i++) {
		Member member = members.get(i); //�䱸����7-4
		System.out.println("�̸�: "+member.getUserName());
		System.out.println("--------------");
		}
		}
	}
	else if(s.equals("login")){  //�䱸����10
		System.out.println("ID : ");
		String ID=sc.nextLine();
		System.out.println("PW : ");
		String PW=sc.nextLine();

//�䱸����11-1		mDao.doLogin(ID,PW);  //mDao���� ��Ű�� ��
		
		Member member=mDao.getMemberByUserId(ID);
		
		if(member==null) {  //App���� �ν��� �� �ֵ��� �Ű� �°�
			System.out.println("���� ���̵��Դϴ�.");
//			return false;
		}else {
			if(PW.equals(member.getUserPw())) {
				System.out.println(member.getUserName()+"�� �ݰ����ϴ�.");
				loginedMember=member; //�α����� ���¶�� ���� ��� ���������־�� ��
//				return true;
			}else {
				System.out.println("��й�ȣ�� Ʋ���̽��ϴ�.");
//				return false;
			}			
		}		
	}
	
 } //while
	
}
	void printArticles(ArrayList<Article> articles){
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //�䱸����7-4
			System.out.println("��ȣ: "+article.getTNumber());
			System.out.println("����: "+article.getTitle());
			System.out.println("�ۼ���: "+article.getWriter());
			System.out.println("�ۼ���: "+article.getRegDate());
			System.out.println("--------------");		
		}
	}
	void printArticle(Article article){
		System.out.println("��ȣ: "+article.getTNumber());
		System.out.println("����: "+article.getTitle());
		System.out.println("����: "+article.getBody());
		System.out.println("�ۼ���: "+article.getWriter());
		System.out.println("�ۼ���: "+article.getRegDate());
		System.out.println("-----���-----");	
		ArrayList<Reply> replies=article.getReplies();
		for(int i=0; i<replies.size(); i++) {
			System.out.println("����: "+replies.get(i).getBody());
			System.out.println("�ۼ���: "+replies.get(i).getWriter());
			System.out.println("�ۼ���: "+replies.get(i).getRegDate());	
	}
	}
	String getCurrentDate() {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String time1 = format1.format(time);
		
		return time1;
	}
	
	
}



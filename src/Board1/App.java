package Board1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class App {//핵심로직 분리
	//본래 Board1에 있던 기초 로직은 static으로 인해 유연하지가 못함
	//따라서 본 프로그램의 확장성,유연성을 위해 핵심로직을 유연하게 따로 분리

	ArticleDao aDao=new ArticleDao();  //분리한 Dao가 갖고 있는 데이터 가져오기 위해 개체 만들기
	MemberDao mDao=new MemberDao();  //분리한 Dao가 갖고 있는 데이터 가져오기 위해 개체 만들기
	Member loginedMember=null;  //요구사항11-1 로그인한 상태라는 것을 계속 인지시켜주어야 함

	
	public void start(){ //non-static 매소드

	
	Scanner sc=new Scanner(System.in);		
	
//	int a=1; //요구사항3   //요구사항7-2로 인해 필요 없어짐
	
	while(true) {  //요구사항1-1
		String s=sc.nextLine();
	if(s.equals("exit")){
		System.out.println("종료");
		break;
	}
	else if(s.equals("add")){  //요구사항1-2
		
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		System.out.println("제목을 입력하세요: ");
		String title=sc.nextLine();
		System.out.println("내용을 입력하세요: ");
		String body=sc.nextLine();
		
//		tNumbers.add(a);//요구사항3
//		a++;
//		titles.add(title);
//		bodies.add(body);
		
		Article article=new Article();  //요구사항7-2
		
		article.setTitle(title);
		article.setBody(body);
		article.setWriter(loginedMember.getUserName());  //요구사항11-2

		//요구사항11-3
//		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
//		Date time= new Date();
//		String time1 = format1.format(time);
//		article.setRegDate(time1);

		article.setRegDate(getCurrentDate());

		
		aDao.addArticle(article);  //dao에게 article 추가해라 시키는 것
		}	
	}
	else if(s.equals("list")){  //요구사항1-3
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		ArrayList<Article> articles=aDao.getArticles(); //dao에게 전체 article 가져와라 시키는 것

		printArticles(articles);  //중복제거
		
//		for(int i=0; i<articles.size(); i++) {
//		Article article = articles.get(i); //요구사항7-4
//		System.out.println("번호: "+article.getTNumber());
//		System.out.println("제목: "+article.getTitle());
//		System.out.println("작성자: "+article.getWriter()); //요구사항11-2
//		System.out.println("--------------");
//		}
		}
	}
	
	else if(s.equals("read")){  //요구사항4
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		System.out.println("열람할 게시물 번호 입력: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=dao.getIndexByTNum(tNum);   //dao에게 부탁->필요없음
		Article article=aDao.getArticleByTNum(tNum);
		
		
//		for(int i=0; i<tNumbers.size(); i++) {    //요구사항7 중복 제거
//			if(index==-1){
			if(article==null){		//dao에 해당 게시물이 없으면 null
				System.out.println("없는 게시물입니다.");
			}
			else{		
				printArticle(article);  //중복제거
//				Article article = articles.get(index); //요구사항7-4
//				System.out.println("번호: "+article.getTNumber());
//				System.out.println("제목: "+article.getTitle());
//				System.out.println("내용: "+article.getBody());
//				System.out.println("작성자: "+article.getWriter());
//				System.out.println("작성일: "+article.getRegDate());
//				System.out.println("----상세보기(reply:댓글, back:뒤로가기)----");	
//				
			}
			while(true) {  //요구사항12
			System.out.println("상세보기 명령어 입력(reply : 댓글,  back : 뒤로가기)");
			String dcmd = sc.nextLine();
			if(dcmd.equals("back")) {
				break;
			}
			else if(dcmd.equals("reply")){	
				Reply reply=new Reply();
				System.out.println("댓글 내용을 입력해주세요.");
				String rbody = sc.nextLine();
				reply.setBody(rbody);
				reply.setWriter(loginedMember.getUserName());
				reply.setRegDate(getCurrentDate());
				article.addReply(reply);
				System.out.println("댓글이 등록되었습니다.");
				printArticle(article);
			}
			}
			
			
			
			
			
			
			
			
			
			}
		
			
//			else if(tNum != tNumbers.get(i));{
//				System.out.println("열람할 게시물이 없습니다.");
//
//			}  ??? 왜 안먹히지...
//		}
	}
	else if(s.equals("update")){  //요구사항5
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		System.out.println("수정할 게시물 번호 입력: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=getIndexByTNum(tNum);
		Article article=aDao.getArticleByTNum(tNum);
		
//		for(int i=0; i<tNumbers.size(); i++) {   //요구사항7 중복 제거
//			if(tNum==tNumbers.get(i));{
//		if(index==-1){
		if(article==null){		//dao에 해당 게시물이 없으면 null
			System.out.println("없는 게시물입니다.");
		}
		else {
				System.out.println("새로운 제목");
				String title=sc.nextLine();	
				System.out.println("새로운 내용");
				String body=sc.nextLine();
				
//				Article article = articles.get(index); //요구사항7-2 구조화
				article.setTitle(title);
				article.setBody(body);
				
//				articles.set(index, article);
				aDao.updateArticle(tNum, article);
				
//				titles.set(index, title);   //ArrayList 배열 수정 명령어
//				bodies.set(index, body);
		}
	
	
		}
	}
	else if(s.equals("delete")){  //요구사항6
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		System.out.println("삭제할 게시물 번호 입력: ");
		int tNum=Integer.parseInt(sc.nextLine());
//		int index=getIndexByTNum(tNum);
		Article article=aDao.getArticleByTNum(tNum);
		
//		for(int i=0; i<tNumbers.size(); i++) {   //요구사항7 중복 제거
//			if(tNum==tNumbers.get(i));{
//		if(index==-1){
		if(article==null){		//dao에 해당 게시물이 없으면 null
			System.out.println("없는 게시물입니다.");

		}else {
//				tNumbers.remove(index); //ArrayList 배열 삭제 명령어
//				titles.remove(index);  
//				bodies.remove(index);
									
//				articles.remove(index);
			aDao.deleteArticle(article);
				
				
				
			} 
		}
		}
	else if(s.equals("search")){    //요구사항8
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		System.out.println("검색어를 입력해주세요. ");
		String keyword=sc.nextLine();
		
		ArrayList<Article> articles=aDao.getArticles(); //dao에게 전체 article 가져와라 시키는 것
	
		//먼저 새로운 게시물 리스트 만들기 //요구사항 11-2중 중복제거
		//즉, searchedArticles란 새로운 배열리스트를 만들어서 그것을  printArticles하도록 하는 개념
		ArrayList<Article> searchedArticles=new ArrayList<>();
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //요구사항7-4
		if(article.getTitle().contains(keyword)) {
			searchedArticles.add(article); //중복제거
//			System.out.println("번호: "+article.getTNumber());
//			System.out.println("제목: "+article.getTitle());
//			System.out.println("--------------");		
		}		
		}
		printArticles(searchedArticles);  //중복제거

		}
	}
	else if(s.equals("sort")){    //요구사항13
		System.out.println("정렬 대상을 선택해주세요. (id:번호)");
		String sortTarget=sc.nextLine();
		System.out.println("정렬 방법을 선택해주세요. (asc:오름차순 / desc:내림차순)");
		String sortType=sc.nextLine();
		
		ArrayList<Article> articles=aDao.getArticles(); //dao에게 전체 article 가져와라 시키는 것
	
		//먼저 새로운 게시물 리스트 만들기 //요구사항 11-2중 중복제거
		//즉, searchedArticles란 새로운 배열리스트를 만들어서 그것을  printArticles하도록 하는 개념
		ArrayList<Article> searchedArticles=new ArrayList<>();
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //요구사항7-4
		if(article.getTitle().contains(keyword)) {
			searchedArticles.add(article); //중복제거
//			System.out.println("번호: "+article.getTNumber());
//			System.out.println("제목: "+article.getTitle());
//			System.out.println("--------------");		
		}		
		}
		printArticles(searchedArticles);  //중복제거

		
	}
	
	
	else if(s.equals("signup")){  //요구사항9
		System.out.println("이름을 입력하세요: ");
		String userName=sc.nextLine();
		System.out.println("사용하실 아이디을 입력하세요: ");
		String userId=sc.nextLine();
		System.out.println("사용하실 비밀번호를 입력하세요: ");
		String userPw=sc.nextLine();
		
		Member member=new Member(userName, userId, userPw);  
		
//		member.setUserName(userName);    //위 내용으로 인해 필요 없음
//		member.setUserId(userId);
//		member.setUserPw(userPw);
		
		mDao.addMember(member);  //mDao에게 추가해라 시키는 것
		
	}
	else if(s.equals("memberlist")){  //회원리스트 불러오기
		if(loginedMember==null) {
			System.out.println("로그인이 필요한 기능입니다.");
		}else {
		ArrayList<Member> members=mDao.getMembers(); //dao에게 전체 article 가져와라 시키는 것
		for(int i=0; i<members.size(); i++) {
		Member member = members.get(i); //요구사항7-4
		System.out.println("이름: "+member.getUserName());
		System.out.println("--------------");
		}
		}
	}
	else if(s.equals("login")){  //요구사항10
		System.out.println("ID : ");
		String ID=sc.nextLine();
		System.out.println("PW : ");
		String PW=sc.nextLine();

//요구사항11-1		mDao.doLogin(ID,PW);  //mDao에게 시키는 것
		
		Member member=mDao.getMemberByUserId(ID);
		
		if(member==null) {  //App에서 인식할 수 있도록 옮겨 온것
			System.out.println("없는 아이디입니다.");
//			return false;
		}else {
			if(PW.equals(member.getUserPw())) {
				System.out.println(member.getUserName()+"님 반갑습니다.");
				loginedMember=member; //로그인한 상태라는 것을 계속 인지시켜주어야 함
//				return true;
			}else {
				System.out.println("비밀번호를 틀리셨습니다.");
//				return false;
			}			
		}		
	}
	
 } //while
	
}
	void printArticles(ArrayList<Article> articles){
		for(int i=0; i<articles.size(); i++) {
		Article article = articles.get(i); //요구사항7-4
			System.out.println("번호: "+article.getTNumber());
			System.out.println("제목: "+article.getTitle());
			System.out.println("작성자: "+article.getWriter());
			System.out.println("작성일: "+article.getRegDate());
			System.out.println("--------------");		
		}
	}
	void printArticle(Article article){
		System.out.println("번호: "+article.getTNumber());
		System.out.println("제목: "+article.getTitle());
		System.out.println("내용: "+article.getBody());
		System.out.println("작성자: "+article.getWriter());
		System.out.println("작성일: "+article.getRegDate());
		System.out.println("-----댓글-----");	
		ArrayList<Reply> replies=article.getReplies();
		for(int i=0; i<replies.size(); i++) {
			System.out.println("내용: "+replies.get(i).getBody());
			System.out.println("작성자: "+replies.get(i).getWriter());
			System.out.println("작성일: "+replies.get(i).getRegDate());	
	}
	}
	String getCurrentDate() {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String time1 = format1.format(time);
		
		return time1;
	}
	
	
}



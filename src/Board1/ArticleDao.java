package Board1;

import java.util.ArrayList;


//dao=데이터엑세스오브젝트
//데이터관리 클래스(dao)와 데이터처리 클래스(app)를 분리


public class ArticleDao {   //데이터 관리
	//현재의 DB는 ArrayList	
	ArrayList<Article> articles=new ArrayList<>(); //요구사항7-2 구조화
	int lastTNum=4;
	
	//생성자
	ArticleDao(){
		makeTestData();
	}
	
	void makeTestData() {
		
		Article article1=new Article();
		article1.setTNumber(1);
		article1.setTitle("제목1");
		article1.setBody("내용1");
		article1.setWriter("홍길동");
		article1.setRegDate("2020-09-03");


		
		Article article2=new Article();
		article2.setTNumber(2);
		article2.setTitle("제목2");
		article2.setBody("내용2");
		article2.setWriter("임꺽정");
		article2.setRegDate("2020-09-03");


		
		Article article3=new Article();
		article3.setTNumber(3);
		article3.setTitle("제목3");
		article3.setBody("내용3");
		article3.setWriter("백동수");
		article3.setRegDate("2020-09-03");


		
		articles.add(article1);  //요구사항7-3 articles라는 틀에 1을 넣어둔다, void main이 시작될때 항상 이미 들어가 있음
		articles.add(article2);  //요구사항7-3 articles라는 틀에 2를 넣어둔다, void main이 시작될때 항상 이미 들어가 있음
		articles.add(article3);  //요구사항7-3 articles라는 틀에 3을 넣어둔다, void main이 시작될때 항상 이미 들어가 있음
		
	}
	
	
	//신규 데이터 추가
	void addArticle(Article article) {//article을 받아줌?? 
		article.setTNumber(lastTNum);    //요구사항7-2

		articles.add(article);

		lastTNum++;

	}
	
	//저장되어있는 전체 데이터 가져오기
	ArrayList<Article> getArticles(){
		return articles;
	}
	
	void updateArticle(int tNum, Article article) {
		int index = getIndexByTNum(tNum);
		
		if(index != -1) {
			articles.set(index, article);
		}
		
	}
	
	void deleteArticle(Article article) {
			articles.remove(article);
	}
	
	
	
	
	Article getArticleByTNum(int tNum) { //본 번호의 게시물을 가져와라
		int index=getIndexByTNum(tNum);  //index를 번호를 통해 가져와라
		
		if(index == -1) {
			return null;  //index가 -1이면
						  //null값을 리턴
		}
			return articles.get(index);
	
	}
	
	
	//요구사항7 중복 제거
	//index가져오기 기능
	int getIndexByTNum(int tNum) {
	
	for(int i=0; i<articles.size(); i++) {
		if(tNum==articles.get(i).getTNumber()){
			return i;
		}
}
	return -1; //int getIndexByTNum의 리턴을 해줘야 함
}
	
	
	
	
}

package Board1;

import java.util.ArrayList;


//dao=�����Ϳ�����������Ʈ
//�����Ͱ��� Ŭ����(dao)�� ������ó�� Ŭ����(app)�� �и�


public class ArticleDao {   //������ ����
	//������ DB�� ArrayList	
	ArrayList<Article> articles=new ArrayList<>(); //�䱸����7-2 ����ȭ
	int lastTNum=4;
	
	//������
	ArticleDao(){
		makeTestData();
	}
	
	void makeTestData() {
		
		Article article1=new Article();
		article1.setTNumber(1);
		article1.setTitle("����1");
		article1.setBody("����1");
		article1.setWriter("ȫ�浿");
		article1.setRegDate("2020-09-03");


		
		Article article2=new Article();
		article2.setTNumber(2);
		article2.setTitle("����2");
		article2.setBody("����2");
		article2.setWriter("�Ӳ���");
		article2.setRegDate("2020-09-03");


		
		Article article3=new Article();
		article3.setTNumber(3);
		article3.setTitle("����3");
		article3.setBody("����3");
		article3.setWriter("�鵿��");
		article3.setRegDate("2020-09-03");


		
		articles.add(article1);  //�䱸����7-3 articles��� Ʋ�� 1�� �־�д�, void main�� ���۵ɶ� �׻� �̹� �� ����
		articles.add(article2);  //�䱸����7-3 articles��� Ʋ�� 2�� �־�д�, void main�� ���۵ɶ� �׻� �̹� �� ����
		articles.add(article3);  //�䱸����7-3 articles��� Ʋ�� 3�� �־�д�, void main�� ���۵ɶ� �׻� �̹� �� ����
		
	}
	
	
	//�ű� ������ �߰�
	void addArticle(Article article) {//article�� �޾���?? 
		article.setTNumber(lastTNum);    //�䱸����7-2

		articles.add(article);

		lastTNum++;

	}
	
	//����Ǿ��ִ� ��ü ������ ��������
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
	
	
	
	
	Article getArticleByTNum(int tNum) { //�� ��ȣ�� �Խù��� �����Ͷ�
		int index=getIndexByTNum(tNum);  //index�� ��ȣ�� ���� �����Ͷ�
		
		if(index == -1) {
			return null;  //index�� -1�̸�
						  //null���� ����
		}
			return articles.get(index);
	
	}
	
	
	//�䱸����7 �ߺ� ����
	//index�������� ���
	int getIndexByTNum(int tNum) {
	
	for(int i=0; i<articles.size(); i++) {
		if(tNum==articles.get(i).getTNumber()){
			return i;
		}
}
	return -1; //int getIndexByTNum�� ������ ����� ��
}
	
	
	
	
}

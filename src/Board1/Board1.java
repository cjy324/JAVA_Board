package Board1;

//import java.util.ArrayList; //요구사항2
//import java.util.Scanner;


public class Board1 {
	

//	static ArrayList<Integer> tNumbers=new ArrayList<>();   //요구사항7-2 구조화로 인해 필요가 없어짐
//	static ArrayList<String> titles=new ArrayList<>();   //요구사항7-2 구조화로 인해 필요가 없어짐
//	static ArrayList<String> bodies=new ArrayList<>();	 //요구사항7-2 구조화로 인해 필요가 없어짐
//  static을 붙여야 static이 붙은 메인 메서드에서 사용이 가능하다
//  그렇게 되면 재사용성이 낮아짐 ->효율성 안좋음
//  따라서 되도록이면 핵심로직에 static을 붙여 제한을 걸어두는것은 피하는 것이 좋음
	
	public static void main(String[] args) {
		
		App app=new App();  //핵심로직인 App을 사용하기 위해  app이라는 개체 생성
		app.start();
		
		
//		<테스트용 샘플>  //요구사항7-3
		
		
		
	
}
}


//class Article{
//	int tNumber;
//	String title;
//	String body;
//	
//}



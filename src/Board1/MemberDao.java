package Board1;

import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> members=new ArrayList<>(); //요구사항9 구조화
//	Member loginedMember=null;  //로그인한 상태라는 것을 계속 인지시켜주어야 함
	
	
	//생성자
	MemberDao(){
		makeTestMemberData();
	}
	
	void makeTestMemberData() {
		
		Member member1=new Member("홍길동", "아이디1", "비밀번호1");
		Member member2=new Member("임꺽정", "아이디2", "비밀번호2");		
		Member member3=new Member("백동수", "아이디3", "비밀번호3");
		
		members.add(member1); 
		members.add(member2);  
		members.add(member3); 
	}
	
	
	//신규 회원 추가
	void addMember(Member member) {//article을 받아줌?? 

		members.add(member);

	}
	
	//저장되어있는 전체 데이터 가져오기
	ArrayList<Member> getMembers(){
		return members;
	}	
	
	Member getMemberByUserId(String id) { //본 Id의 게시물을 가져와라
		int index=getIndexByUserId(id);  //index를 번호를 통해 가져와라
		
		if(index == -1) {
			return null;  //index가 -1이면
						  //null값을 리턴
		}
			return members.get(index);
	
	}
	
	
	//요구사항7 중복 제거
	//index가져오기 기능
	int getIndexByUserId(String id) {
	
	for(int i=0; i<members.size(); i++) {
		if(id.equals(members.get(i).getUserId())){
			return i;
		}
}
	return -1; //int getIndexByTNum의 리턴을 해줘야 함
}
//	boolean doLogin(String ID, String PW) {//요구사항10
//		
//		Member member=getMemberByUserId(ID);
//		
//		if(member==null) {
//			System.out.println("없는 아이디입니다.");
//			return false;
//		}else {
//			if(PW.equals(member.getUserPw())) {
//				System.out.println(member.getUserName()+"님 반갑습니다.");
//				loginedMember=member; //로그인한 상태라는 것을 계속 인지시켜주어야 함
//				return true;
//			}else {
//				System.out.println("비밀번호를 틀리셨습니다.");
//				return false;
//
//			}
//			
//		}
//		
//		
//		
//}    요구사항11-1을 위해 App으로 이동
	
	
	
	
}

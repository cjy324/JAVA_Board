package Board1;

import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> members=new ArrayList<>(); //�䱸����9 ����ȭ
//	Member loginedMember=null;  //�α����� ���¶�� ���� ��� ���������־�� ��
	
	
	//������
	MemberDao(){
		makeTestMemberData();
	}
	
	void makeTestMemberData() {
		
		Member member1=new Member("ȫ�浿", "���̵�1", "��й�ȣ1");
		Member member2=new Member("�Ӳ���", "���̵�2", "��й�ȣ2");		
		Member member3=new Member("�鵿��", "���̵�3", "��й�ȣ3");
		
		members.add(member1); 
		members.add(member2);  
		members.add(member3); 
	}
	
	
	//�ű� ȸ�� �߰�
	void addMember(Member member) {//article�� �޾���?? 

		members.add(member);

	}
	
	//����Ǿ��ִ� ��ü ������ ��������
	ArrayList<Member> getMembers(){
		return members;
	}	
	
	Member getMemberByUserId(String id) { //�� Id�� �Խù��� �����Ͷ�
		int index=getIndexByUserId(id);  //index�� ��ȣ�� ���� �����Ͷ�
		
		if(index == -1) {
			return null;  //index�� -1�̸�
						  //null���� ����
		}
			return members.get(index);
	
	}
	
	
	//�䱸����7 �ߺ� ����
	//index�������� ���
	int getIndexByUserId(String id) {
	
	for(int i=0; i<members.size(); i++) {
		if(id.equals(members.get(i).getUserId())){
			return i;
		}
}
	return -1; //int getIndexByTNum�� ������ ����� ��
}
//	boolean doLogin(String ID, String PW) {//�䱸����10
//		
//		Member member=getMemberByUserId(ID);
//		
//		if(member==null) {
//			System.out.println("���� ���̵��Դϴ�.");
//			return false;
//		}else {
//			if(PW.equals(member.getUserPw())) {
//				System.out.println(member.getUserName()+"�� �ݰ����ϴ�.");
//				loginedMember=member; //�α����� ���¶�� ���� ��� ���������־�� ��
//				return true;
//			}else {
//				System.out.println("��й�ȣ�� Ʋ���̽��ϴ�.");
//				return false;
//
//			}
//			
//		}
//		
//		
//		
//}    �䱸����11-1�� ���� App���� �̵�
	
	
	
	
}

package Board1;

import java.util.ArrayList;

public class test_comparator {
	public static void main(String[] args) {



/*

<����>

-�ܼ��迭 ���ķδ�

int[] �迭��={4,1,2,3,5};

Arrays.sort(�迭��);    ->��������
Arrays.sort(�迭��,Collections,reverseOrder());    ->��������


-��ü Ÿ�� ������ ���ؼ� ���� ������ �������־�� ��
� ���� �������� ArrayList�� �������� �̸� �����־�� ��ǻ�Ͱ� ������ �� ����  
Comparator�� ������ �־�� ��

*/


ArrayList<Num> nList=new ArrayList<>();
 
nList.add(new Num(1, 3));
nList.add(new Num(3, 2));
nList.add(new Num(5, 5));
nList.add(new Num(2, 4));
nList.add(new Num(4, 1));

for(int i=0; i<nList.size(); i++) {
	System.out.println(nList.get(i));
	
}
	}

	
	
}
class Num{
	int n1;
	int n2;

	Num(int a, int b){
		n1=a;
		n2=b;
	}
}
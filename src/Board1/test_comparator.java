package Board1;

import java.util.ArrayList;

public class test_comparator {
	public static void main(String[] args) {



/*

<정렬>

-단순배열 정렬로는

int[] 배열명={4,1,2,3,5};

Arrays.sort(배열명);    ->오름차순
Arrays.sort(배열명,Collections,reverseOrder());    ->내림차순


-객체 타입 정렬을 위해선 정렬 기준을 설정해주어야 함
어떤 것을 기준으로 ArrayList를 정렬할지 미리 정해주어야 컴퓨터가 인지할 수 있음  
Comparator를 구현해 주어야 함

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
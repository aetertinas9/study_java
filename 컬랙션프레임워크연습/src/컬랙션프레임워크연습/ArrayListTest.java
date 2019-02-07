package 컬랙션프레임워크연습;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//객체 생성
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(90));
		//객체로 포장
		list.add(new Integer(85));
		list.add(new Integer(100));
		list.add(new Integer(70));
		list.add(new Integer(60));
		list.add(new Integer(20));
		
		System.out.println(list);//[90, 85, 100, 70, 60, 20]
		userPrint(list);
		userPrint2(list);
		
		System.out.println("인덱스 2인 위치에 객체 삽입");
		list.add(2,56);
		System.out.println(list);
		
		
		Collections.sort(list);
		userPrint(list);//객체 정렬 후 출력

	}




//사용자 정의 메소드 구현 -> 개발자가 필요에 의해서 만든 메소드
public static void userPrint(ArrayList<Integer> list)
{
	for(int i=0;i<list.size();i++)
	{
		System.out.print(list.get(i)+ " ");
	}
	System.out.println("");
	
}
public static void userPrint2(ArrayList<Integer> list)
{
	for(Integer in: list)
		System.out.print(in + " ");
	System.out.println("");
}



}














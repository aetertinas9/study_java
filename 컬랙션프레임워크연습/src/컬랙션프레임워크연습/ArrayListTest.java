package �÷��������ӿ�ũ����;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//��ü ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(90));
		//��ü�� ����
		list.add(new Integer(85));
		list.add(new Integer(100));
		list.add(new Integer(70));
		list.add(new Integer(60));
		list.add(new Integer(20));
		
		System.out.println(list);//[90, 85, 100, 70, 60, 20]
		userPrint(list);
		userPrint2(list);
		
		System.out.println("�ε��� 2�� ��ġ�� ��ü ����");
		list.add(2,56);
		System.out.println(list);
		
		
		Collections.sort(list);
		userPrint(list);//��ü ���� �� ���

	}




//����� ���� �޼ҵ� ���� -> �����ڰ� �ʿ信 ���ؼ� ���� �޼ҵ�
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














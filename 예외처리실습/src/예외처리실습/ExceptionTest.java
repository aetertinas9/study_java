package ����ó���ǽ�;


public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a;
		try{
			a=0;
			a=10/0;
			System.out.println("�߳��������ϴ�");
		}
		catch(ArithmeticException e) //�Ƹ�����ƽ�� ���������!!!
		{
			System.out.println(e.getMessage());
		}
		System.out.println("����� �������ϴ�");
		
		
		
		
		

	}

}

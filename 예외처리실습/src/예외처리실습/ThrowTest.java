package ����ó���ǽ�;

public class ThrowTest {




public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	try{
		aa();
		System.out.println("���� ó�� �Ǿ����ϴ�");
	}
	catch(Exception a)
	{
		System.out.println("ó���� ���� �߻�");
	}

	
	
}
public static void aa() throws Exception{
try{
int i = 10/0;
}
catch(Exception a)

		{
			System.out.println("aa() �޼ҵ忡�� ���� �߻�");
			throw a;
		}
}



}
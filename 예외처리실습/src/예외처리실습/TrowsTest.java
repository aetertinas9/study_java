package 예외처리실습;

public class TrowsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		aa();	
		}
		catch(Exception a)
		{
		System.out.println("ERROR");
		}

	
		

	}
	//사용자 정의 메소드 구현
	public static void aa() throws Exception{

		int i= 10/0;
	}

}

package 예외처리실습;

public class ThrowTest {




public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	try{
		aa();
		System.out.println("정상 처리 되었습니다");
	}
	catch(Exception a)
	{
		System.out.println("처리중 에러 발생");
	}

	
	
}
public static void aa() throws Exception{
try{
int i = 10/0;
}
catch(Exception a)

		{
			System.out.println("aa() 메소드에서 에러 발생");
			throw a;
		}
}



}
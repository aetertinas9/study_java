package 예외처리실습;


public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a;
		try{
			a=0;
			a=10/0;
			System.out.println("잘나누어집니다");
		}
		catch(ArithmeticException e) //아리스메틱은 산술적오류!!!
		{
			System.out.println(e.getMessage());
		}
		System.out.println("계산이 끝났습니다");
		
		
		
		
		

	}

}

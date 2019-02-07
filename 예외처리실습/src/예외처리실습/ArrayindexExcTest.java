package 예외처리실습;

public class ArrayindexExcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ArrayindexExcTest.test();
		}
		catch(Exception a)
		{
			System.out.println("main() 메소드가 예외처리 : "+a);
		}
	

}
	
	public static void test() throws ArithmeticException
	{
		int a =0;
		a=10/0;
	}
	
	
}
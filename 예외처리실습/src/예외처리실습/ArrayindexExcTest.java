package ����ó���ǽ�;

public class ArrayindexExcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ArrayindexExcTest.test();
		}
		catch(Exception a)
		{
			System.out.println("main() �޼ҵ尡 ����ó�� : "+a);
		}
	

}
	
	public static void test() throws ArithmeticException
	{
		int a =0;
		a=10/0;
	}
	
	
}
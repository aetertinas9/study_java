package 예외처리실습;

public class ArrayindexExcTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			int []a=new int[4];
			a[5]=10;
			System.out.println("값은 : "+a[5]);
		}
		catch(Exception a)
		{
			System.out.println("배열의 크기를 벗어남"+a);
		}
		
		
		
	}

}

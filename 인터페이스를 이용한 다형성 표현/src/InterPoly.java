

interface printer
{
		//추상 메소드가 필요
	
	public void print(String str);
	
	
}

class printerA implements printer{

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello "+ str + "!");
		
	}
	
}
class printerB implements printer{

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		
		System.out.println("안녕 "+ str + "!");
		
	}
	
}
class printerC implements printer{

	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		
		System.out.println("안녕 "+ str + "!");
		
	}
	
}


public class InterPoly {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printer p1 = new printerA();
		printer p2 = new printerB();
		printer p3 = new printerC();
		
		p1.print("JAVA");
		p2.print("자바");
		p3.print("하세요");
		

	}

}

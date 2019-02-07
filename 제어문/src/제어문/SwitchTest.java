package 제어문;

public class SwitchTest {

	/*
	 switch문의 괄호에는 정수타입(byte,char,short,int...) 변수나 정수값을
	 산출하는 연산식만 할 수 있었다
	 하지만 자바7부터는 string 타입의 변수도 올 수 있다.	  
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		
		switch(n)
		{
		case 1:
			System.out.println("simple java");
		case 2:
			System.out.println("funny java");
		case 3:
			System.out.println("fantastic java");
		break;
		default:
			System.out.println("the best programming language");
		}
		
		System.out.println("Do you like coffee?");
		
		String position = "과장";
		
		switch(position)
		{
		case "부장" : System.out.println("700만원");
		break;
		case "과장" : System.out.println("500만원");
		break;
		default:
			System.out.println("300만원");
		}
		
		
		
		}
		
		
	}


package 제어문활용;

import java.util.Scanner;



public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menunum; 		//사용자가 선택한 메뉴번호
		boolean run = true; //지역변수 초기화
		int balance = 0;	//지역변수 초기화
		Scanner scanner= new Scanner(System.in);	//키보드로부터 입력받음
		

		
		while(run)		//반복하겠다
		{	
			System.out.println("---------------------------------------");
			System.out.println(" 1.예금         2.출금         3.잔고          4.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택: ");
			
			menunum = scanner.nextInt();
			
			
			switch(menunum)
			{
			
			case 1 :
				System.out.println("현재잔액은 :");
				System.out.println(balance);
				System.out.print("예금액: ");
				balance = balance + scanner.nextInt();
				break;
			case 2 :
				System.out.println("현재잔액은 :");
				System.out.println(balance);
				System.out.print("출금액: ");
				balance = balance - scanner.nextInt();
				break;
			case 3 :
				System.out.println("현재 잔액은 : ");
				System.out.println(balance);
				break;
			case 4 : 
				run = false;
				break;
				//프로그램종료
			}
			
			
		}
		

		
	}

}

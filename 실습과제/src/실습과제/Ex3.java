package �ǽ�����;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner scan = new Scanner(System.in);
		int year;
		System.out.println("������ �Է��ϼ���: ");
		year = scan.nextInt(); //�����Է�
		
		if(year%4==0 &&year%100!=0|| year%400==0)
		{
			System.out.println("�����Դϴ�");
		}
		else
			System.out.println("����Դϴ�");
		
		
		
	}

}

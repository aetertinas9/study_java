package �ǽ�����;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 String class�� toLoswerCase( ) , toUpperCase( ) �޼ҵ� ���
		 
		 Scanner Ŭ������ next( )-> ���������� ���ڿ��� �޾Ƶ帲 nextLine( ) -> ��ü���ڿ�
		 next( ) �ڹ� ��ü���� -> �ڹ�
		 nextLine( ) �ڹ� ��ü���� -> �ڹ� ��ü����
		 */
		
		
		
		boolean run = true;
		char alpha;
		
		Scanner scan = new Scanner(System.in);
		
		while(run)
		{
			System.out.println("���� �� �ڸ� �Է��ϼ��� : ");
			alpha = scan.next().charAt(0); //chatAt --> Ư�����ڸ� �������ڴ� 0�� ù���� ���ڸ� �ǹ�
			
			if(alpha >= 'a' && alpha <='z')
			{
				//�ҹ��ڰ� �Էµȴ��ϸ�
				alpha = (char)(alpha - 32); //��ҹ��� ���̰� 32 'a' 97-32='A'
				System.out.println(alpha);
			}
			else if(alpha >= 'A' && alpha <='Z')
			{
				//�빮�ڰ� �Էµȴ��ϸ�
				alpha = (char)(alpha + 32); //��ҹ��� ���̰� 32 'a' 97-32='A'	
				System.out.println(alpha);
			}
			else
			{
				System.out.println("�����ڰ� �ƴմϴ�.");
				run = false;
			}
			
		}
		
		
		
	}

}

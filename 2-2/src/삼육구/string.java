package ������;

import java.util.Scanner;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String number;
		Scanner scan = new Scanner(System.in);
		char c;
		int clap=0;
		
		System.out.println("1~9999������ ���� �Է�����: ");
		number=scan.next();
	
		for (int i=0;i<4;i++)
		{
			c = number.charAt(i);
			if (c == '3' || c =='6' || c=='9')
			{
				clap++;
			}
		}
		if(clap==0) System.out.println("�ڼ��� ġ�� �ʴ´�.");
		if(clap==1) System.out.println("�ڼ� ¦");
		if(clap==2) System.out.println("�ڼ� ¦¦");
		if(clap==3) System.out.println("�ڼ� ¦¦¦");
		if(clap==4) System.out.println("�ڼ� ¦¦¦¦");
		
		
		
	}

}

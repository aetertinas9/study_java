package ���Ȱ��;

import java.util.Scanner;



public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menunum; 		//����ڰ� ������ �޴���ȣ
		boolean run = true; //�������� �ʱ�ȭ
		int balance = 0;	//�������� �ʱ�ȭ
		Scanner scanner= new Scanner(System.in);	//Ű����κ��� �Է¹���
		

		
		while(run)		//�ݺ��ϰڴ�
		{	
			System.out.println("---------------------------------------");
			System.out.println(" 1.����         2.���         3.�ܰ�          4.����");
			System.out.println("---------------------------------------");
			System.out.print("����: ");
			
			menunum = scanner.nextInt();
			
			
			switch(menunum)
			{
			
			case 1 :
				System.out.println("�����ܾ��� :");
				System.out.println(balance);
				System.out.print("���ݾ�: ");
				balance = balance + scanner.nextInt();
				break;
			case 2 :
				System.out.println("�����ܾ��� :");
				System.out.println(balance);
				System.out.print("��ݾ�: ");
				balance = balance - scanner.nextInt();
				break;
			case 3 :
				System.out.println("���� �ܾ��� : ");
				System.out.println(balance);
				break;
			case 4 : 
				run = false;
				break;
				//���α׷�����
			}
			
			
		}
		

		
	}

}

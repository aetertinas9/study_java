package ���;

public class SwitchTest {

	/*
	 switch���� ��ȣ���� ����Ÿ��(byte,char,short,int...) ������ ��������
	 �����ϴ� ����ĸ� �� �� �־���
	 ������ �ڹ�7���ʹ� string Ÿ���� ������ �� �� �ִ�.	  
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
		
		String position = "����";
		
		switch(position)
		{
		case "����" : System.out.println("700����");
		break;
		case "����" : System.out.println("500����");
		break;
		default:
			System.out.println("300����");
		}
		
		
		
		}
		
		
	}


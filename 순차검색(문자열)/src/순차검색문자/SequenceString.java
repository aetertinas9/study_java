package �����˻�����;

import java.util.Scanner;

public class SequenceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		String find;
		Scanner scan=new Scanner(System.in);
		String name []={"����ȣ","������","������","�����"};
		find= scan.next();

		
		for(i=0;i<name.length;i++)
		{
			if(find.equals(name[i]))
			{
				System.out.println("ã�� ����� : "+name[i]);
				break;
			}
		}
		
		if(i==name.length)
		{
			System.out.println("ã�� ����� �����ϴ�");
		}
	
		
	}

}

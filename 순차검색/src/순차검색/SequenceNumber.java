package �����˻�;

import java.util.Scanner;

public class SequenceNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i;
		int find;
		int data[]={5,28,30,46,50,67,70,90};
				
		Scanner scan = new Scanner(System.in);
		System.out.print("����� �����ʹ�: ");
		for(int j=0;j<data.length;j++)
		{
		System.out.print(data[j]+" ");
		}
		System.out.println(" ");
		System.out.print("ã���� �ϴ� ������ ����? ");
		find =scan.nextInt();
		
		
		for(i=0;i<data.length;i++)
		{
			if(find == data[i])
			{
				System.out.println("ã���� �ϴ� ���� "+data[i]);
				break;
			}
		}
		if(i==data.length) 
			System.out.println("��ġ�ϴ� ���� �����ϴ�");
		
	}

}

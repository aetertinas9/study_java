package �ǽ�����;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�迭 ����
		int[] arrMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		String[] str = {"��������","������","��õ����","õ����","�����","���","�ʿ�","�Ͽ�"};
		int[] result = new int[9]; //��������: ȭ���� ���� üũ���ؼ� �迭�� ����� new�ʿ� -> 0���� �ڵ��ʱ�ȭ
		
		System.out.print("�ݾ��� �Է��ϼ���: ");
		Scanner in = new Scanner(System.in);
		
		int Money = in.nextInt(); //�Է¿Ϸ�
		
		for(int i=0; i<arrMoney.length;i++)
		{
			int num=Money /arrMoney[i];
			int remainder = Money % arrMoney[i];
			Money=remainder;
			
			if(num>0 &&i<4)
			{
				System.out.println(str[i]+" "+num+"��");
			}
			else if(num>0 && i<=4)
			{
				System.out.println(str[i]+" "+num+"��");
			}
		}
		
		
	}

}

package �ֹε�Ϲ�ȣ;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class SocialNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String juminNum;
		int weight []={2,3,4,5,6,7,0,8,9,2,3,4,5};	//������ -�� 0�� ����ġ�� �д�
		int sum = 0;	//���������� �� �ʱ�ȭ�����ش� �ֳ��ϸ� ��������!!!!![����!!!!]
		int temp, result;
		
		System.out.println("�ֹι�ȣ �Է�: ");
		Scanner scan = new Scanner(System.in);
		juminNum=scan.next();
		
		for(int i=0;i<13;i++)
		{
			if(juminNum.charAt(i)=='-')
			{
				continue;	// '-'�� �ǳʶڴ�
			}
			sum= sum + (juminNum.charAt(i)-48) * weight[i]; //���ڹ��ڰ� �������ڷ� ��ȯ�ȴ�
		}
		
		temp = 11 - (sum%11); //sum+temp-11�� ���
		result = temp %10;	//temp ���� 2�ڸ��� ���ڸ��� �ٲ�
		
		
		if(result == juminNum.charAt(13)-48)
		{
			System.out.println("�ֹι�ȣ �Դϴ�");
			//��������
			
			//����
			Calendar cal = Calendar.getInstance(Locale.KOREA);
			int year = cal.get(Calendar.YEAR);
			int yy = Integer.parseInt(juminNum.substring(0,2));
			
			if(juminNum.charAt(7)-48<3) yy=yy+1900;
			else yy=yy+2000;
			
			int age = year - yy + 1;	//������ -> �츦 ������ ���ؼ�
			System.out.println(age);
			
			
			//����
			if(juminNum.charAt(7)-48%2==0) System.out.println("�����Դϴ�");//2�Ǵ� 4 --> ����
			else System.out.println("�����Դϴ�");
			
			//�������
			String [][] localecode = {{"����", "00", "08"},
									  {"�λ�","09","11"},
									  {"��õ","13","15"},
									  {"���","16","25"},
									  {"����","26","34"},
									  {"���","35","39"},
									  {"����","44","48"},
									  {"�泲","41","43"},
									  {"�泲","45","47"},
									  {"����","44","44"},
									  {"����","49","49"},
									  {"����","48","54"},
									  {"����","55","64"},
									  {"����","65","66"},
									  {"�뱸","67","70"},
									  {"���","71","80"},
									  {"�泲","81","84"},
									  {"�泲","86","90"},
									  {"���","85","85"},
									  {"����","91","95"}
			};
			//�̰� ���� ȿ�����̴�!!!!!
			String localeString = juminNum.substring(8,10);
			int locale = Integer.parseInt(localeString);
			String birthplace = null;//�������� �ʱ�ȭ!!!!!!!
			
			for(int i=0;i<20;i++)
			{
				if(locale >=Integer.parseInt(localecode[i][1])&&
				   locale<=Integer.parseInt(localecode[i][2]))
				{
					birthplace=localecode[i][0];
				}
			}
			System.out.println("���������: "+birthplace);
			
			//������
			int twelve = age %12;
			switch(twelve)
			{
			case 6: System.out.println("���");	break;
			case 7: System.out.println("�Ҷ�");	break;
			case 8: System.out.println("ȣ���̶�");	break;
			case 9: System.out.println("�䳢��");	break;
			case 10: System.out.println("���");	break;
			case 11: System.out.println("���");	break;
			case 0: System.out.println("����");	break;
			case 1: System.out.println("���");	break;
			case 2: System.out.println("�����̶�");	break;
			case 3: System.out.println("�߶�");	break;
			case 4: System.out.println("����");	break;
			case 5: System.out.println("������");	break;
			}
			/*
			 String ddi= null
			 String []ganji={"������","��",....}
			 ddi=ganji[yy%12];
			 */
			
			System.out.println("������� : "+yy+"/"+juminNum.substring(2,4)+"/"+juminNum.substring(4,6));
			
			
			
			
						
		}
		else System.out.println("�ֹι�ȣ�� �ƴմϴ�");
		
		
	}

}

package ���ڿ�2�����迭����;

public class TwoDSelectionString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	String[][]str =	{{"3","����ȣ","����","ȸ���"},
					{"1","����ö","�泲","������"},
					{"2","����ö","�λ�","������"}};
	int i,j,k;
	int x,y;
	
	
	
	
	
	//int n = 4;
	String temp;
	//���� ��ȣ�� �����ϰ������ 0��, �� ����Ÿ������ �ٲپ�����Ѵ� �ȱ׷��� 10�̻󿡼� �� �ȵ�
	//��ȣ����
	for(i=0;i<str.length-1;i++)
	{
		for(j=i+1; j<str.length;j++)
		{
			if(Integer.parseInt(str[i][0])>Integer.parseInt(str[j][0]))
			{
				
			for(k=0;k<str[i].length;k++)
			{
			temp=str[i][k];
			str[i][k]=str[j][k];
			str[j][k]=temp;
			}
		}
		}
	}
	/*//�̸�����
	for(i=0;i<str.length-1;i++)
	{
		for(j=i+1; j<str.length;j++)
		{
			if(str[i][1].compareTo(str[j][1])>0)
			{
				
			for(k=0;k<str[i].length;k++)
			{
			temp=str[i][k];
			str[i][k]=str[j][k];
			str[j][k]=temp;
			}
		}
		}
	}*/
	//�̸��� 1���̶� 1�� �־���
	//�ٸ��ɷ� �����ϰ� ������ �ٸ� ���� �Է�!!
	
	
	for(x=0;x<str.length;x++)
	{
		for(y=0;y<str.length+1;y++)
			System.out.print(str[x][y]+" ");
		System.out.println();
	}
	
	}}
		
	
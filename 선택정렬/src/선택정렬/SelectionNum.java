package ��������;

public class SelectionNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int [ ] data = {50,30,10,40,20}; //�迭����� ���ÿ� �ʱⰪ ���� 
	int i, j, k;
	int temp=0; //k�� ��¿�
	int n = 5; //������ ����
	
	//������ �ý���!
	
	//selection ���� �˰���
	for (i=0; i<n-1; i++) //data �� n���϶��� n-1ȸ���� �Ѵ�
	{
		for (j=i+1;j<n;j++)
		{
			if(data[i] >data[j])
			{
				temp = data[i];
				data [i] = data[j];
				data [j]= temp;
			}
		}
		
		System.out.print((i+1)+ "ȸ��: ");
		for(k=0; k<n; k++)
			System.out.print(data[k] + " ");
	
	System.out.println();
	}
	}

}

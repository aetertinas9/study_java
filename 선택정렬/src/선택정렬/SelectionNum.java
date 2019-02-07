package 선택정렬;

public class SelectionNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int [ ] data = {50,30,10,40,20}; //배열선언과 동시에 초기값 설정 
	int i, j, k;
	int temp=0; //k는 출력용
	int n = 5; //데이터 갯수
	
	//고객관리 시스템!
	
	//selection 정렬 알고리즘
	for (i=0; i<n-1; i++) //data 가 n개일때는 n-1회전을 한다
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
		
		System.out.print((i+1)+ "회전: ");
		for(k=0; k<n; k++)
			System.out.print(data[k] + " ");
	
	System.out.println();
	}
	}

}

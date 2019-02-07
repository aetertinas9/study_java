package 문자열2차원배열정렬;

public class TwoDSelectionString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	String[][]str =	{{"3","박태호","서울","회사원"},
					{"1","김의철","경남","공무원"},
					{"2","오수철","부산","연예인"}};
	int i,j,k;
	int x,y;
	
	
	
	
	
	//int n = 4;
	String temp;
	//만약 번호로 정렬하고싶으면 0열, 꼭 정수타입으로 바꾸어줘야한다 안그러면 10이상에서 잘 안됨
	//번호정렬
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
	/*//이름정렬
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
	//이름이 1열이라 1을 넣었다
	//다른걸로 정렬하고 싶으면 다른 숫자 입력!!
	
	
	for(x=0;x<str.length;x++)
	{
		for(y=0;y<str.length+1;y++)
			System.out.print(str[x][y]+" ");
		System.out.println();
	}
	
	}}
		
	
package 문자정렬;

public class StringSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	String str [ ] = {"박태호", "김의실", "오수철"};
	int i,j,k;
	String temp;
	
	//int n = 3;
	
	for(i=0;i<str.length;i++)
	{
		for(j=i+1; j<str.length;j++)
		{
			if(str[i].compareTo(str[j])>0)
			{
			temp=str[i];
			str[i]=str[j];
			str[j]=temp;
			}
		}
	}
	
	
	for(k=0;k<str.length;k++)
		System.out.println(str[k]+" ");
		
	}

}

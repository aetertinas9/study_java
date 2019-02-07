package 순차검색;

import java.util.Scanner;

public class SequenceNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i;
		int find;
		int data[]={5,28,30,46,50,67,70,90};
				
		Scanner scan = new Scanner(System.in);
		System.out.print("저장된 데이터는: ");
		for(int j=0;j<data.length;j++)
		{
		System.out.print(data[j]+" ");
		}
		System.out.println(" ");
		System.out.print("찾고자 하는 데이터 값은? ");
		find =scan.nextInt();
		
		
		for(i=0;i<data.length;i++)
		{
			if(find == data[i])
			{
				System.out.println("찾고자 하는 값은 "+data[i]);
				break;
			}
		}
		if(i==data.length) 
			System.out.println("일치하는 값이 없습니다");
		
	}

}

package 순차검색문자;

import java.util.Scanner;

public class SequenceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		String find;
		Scanner scan=new Scanner(System.in);
		String name []={"최인호","김진평","조정래","김흥신"};
		find= scan.next();

		
		for(i=0;i<name.length;i++)
		{
			if(find.equals(name[i]))
			{
				System.out.println("찾는 사람은 : "+name[i]);
				break;
			}
		}
		
		if(i==name.length)
		{
			System.out.println("찾는 사람이 없습니다");
		}
	
		
	}

}

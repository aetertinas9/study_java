package »ïÀ°±¸;

import java.util.Scanner;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String number;
		Scanner scan = new Scanner(System.in);
		char c;
		int clap=0;
		
		System.out.println("1~9999»çÀÌÀÇ °ªÀ» ÀÔ·ÂÇÏÀÚ: ");
		number=scan.next();
	
		for (int i=0;i<4;i++)
		{
			c = number.charAt(i);
			if (c == '3' || c =='6' || c=='9')
			{
				clap++;
			}
		}
		if(clap==0) System.out.println("¹Ú¼ö¸¦ Ä¡Áö ¾Ê´Â´Ù.");
		if(clap==1) System.out.println("¹Ú¼ö Â¦");
		if(clap==2) System.out.println("¹Ú¼ö Â¦Â¦");
		if(clap==3) System.out.println("¹Ú¼ö Â¦Â¦Â¦");
		if(clap==4) System.out.println("¹Ú¼ö Â¦Â¦Â¦Â¦");
		
		
		
	}

}

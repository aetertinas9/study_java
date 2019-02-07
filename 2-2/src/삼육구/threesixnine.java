package »ïÀ°±¸;

import java.util.Scanner;

public class threesixnine {

	public static void main(String[] args) {
		
		int number =0;
		int first,second,third,fourth;
		int clap =0;
		Scanner scan =new Scanner(System.in);
		
		System.out.println("1~9999»çÀÌÀÇ °ªÀ» ÀÔ·ÂÇÏÀÚ: ");
		number=scan.nextInt();
		
		/*
		String num[];
		Scanner scan = new Scanner(System.in)
		
		System.out.println("1~9999»çÀÌÀÇ °ªÀ» ÀÔ·ÂÇÏÀÚ: ");
		number=scan.next();
		
		for (i=0;i<4;i++)
		{
			c = a[i];
			if c == '3' or c =='6' or 
		}
		
		*/
		
		first=number%10;
		second=(number/10)%10;
		third=(number/100)%10;
		fourth=(number/1000)%10;
		
		if(first==3||first==6||first==9) 	clap++;
		if(second==3||second==6||second==9)	clap++;
		if(third==3||third==6||third==9)	clap++;
		if(fourth==3||fourth==6||fourth==9)	clap++;
		
		if(clap==0) System.out.println("¹Ú¼ö¸¦ Ä¡Áö ¾Ê´Â´Ù");
		if(clap==1) System.out.println("¹Ú¼ö Â¦");
		if(clap==2) System.out.println("¹Ú¼ö Â¦Â¦");
		if(clap==3) System.out.println("¹Ú¼ö Â¦Â¦Â¦");
		if(clap==4) System.out.println("¹Ú¼ö Â¦Â¦Â¦Â¦");
		

	}


}

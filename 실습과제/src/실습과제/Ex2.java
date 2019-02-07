package 실습과제;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열 선언
		int[] arrMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		String[] str = {"오만원권","만원권","오천원권","천원권","오백원","백원","십원","일원"};
		int[] result = new int[9]; //선언이유: 화폐의 개수 체크위해서 배열만 선언시 new필요 -> 0으로 자동초기화
		
		System.out.print("금액을 입력하세요: ");
		Scanner in = new Scanner(System.in);
		
		int Money = in.nextInt(); //입력완료
		
		for(int i=0; i<arrMoney.length;i++)
		{
			int num=Money /arrMoney[i];
			int remainder = Money % arrMoney[i];
			Money=remainder;
			
			if(num>0 &&i<4)
			{
				System.out.println(str[i]+" "+num+"매");
			}
			else if(num>0 && i<=4)
			{
				System.out.println(str[i]+" "+num+"개");
			}
		}
		
		
	}

}

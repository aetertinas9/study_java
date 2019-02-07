package 실습과제;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner scan = new Scanner(System.in);
		int year;
		System.out.println("연도를 입력하세요: ");
		year = scan.nextInt(); //연도입력
		
		if(year%4==0 &&year%100!=0|| year%400==0)
		{
			System.out.println("윤년입니다");
		}
		else
			System.out.println("평년입니다");
		
		
		
	}

}

package 실습과제;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 String class의 toLoswerCase( ) , toUpperCase( ) 메소드 사용
		 
		 Scanner 클래스의 next( )-> 공백직전의 문자열만 받아드림 nextLine( ) -> 전체문자열
		 next( ) 자바 객체지향 -> 자바
		 nextLine( ) 자바 객체지향 -> 자바 객체지향
		 */
		
		
		
		boolean run = true;
		char alpha;
		
		Scanner scan = new Scanner(System.in);
		
		while(run)
		{
			System.out.println("문자 한 자를 입력하세요 : ");
			alpha = scan.next().charAt(0); //chatAt --> 특정문자만 가져오겠다 0은 첫번재 문자를 의미
			
			if(alpha >= 'a' && alpha <='z')
			{
				//소문자가 입력된다하면
				alpha = (char)(alpha - 32); //대소문자 차이가 32 'a' 97-32='A'
				System.out.println(alpha);
			}
			else if(alpha >= 'A' && alpha <='Z')
			{
				//대문자가 입력된다하면
				alpha = (char)(alpha + 32); //대소문자 차이가 32 'a' 97-32='A'	
				System.out.println(alpha);
			}
			else
			{
				System.out.println("영문자가 아닙니다.");
				run = false;
			}
			
		}
		
		
		
	}

}

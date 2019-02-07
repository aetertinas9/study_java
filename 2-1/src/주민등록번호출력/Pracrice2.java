package 주민등록번호출력;

import java.util.Scanner;

public class Pracrice2 {

	public static void main(String[] args) {

		System.out.println("주민등록번호를 입력하세요: ");
		Scanner scan = new Scanner(System.in).useDelimiter("\\s|-");
		
		int preid=scan.nextInt();
		int postid=scan.nextInt();
		
		System.out.println("앞자리는 :"+preid);
		
		
		
		
	}

}

package 주민등록번호;

import java.util.Calendar;
import java.util.Scanner;

public class  SocialNumber {
	public static Boolean checkJumin(String jumin){
		
		Boolean checktrue = false; 		
	
		int numberLength = 11; 
		int checkSum = 0; 
		int reg =jumin.charAt(jumin.length() -1) - 48; 	
		int checkReg = 0; 		
		
		int[] weight = { 2,3,4,5,6,7,8,9,2,3,4,5 }; 
		jumin = jumin.replace("-", ""); 	
		jumin = jumin.substring(0,jumin.length()-1); 

		for( int i = 0 ; i < weight.length ; i++){
			checkSum += (jumin.charAt(i) - 48) * weight[i];
		}
		
	   checkReg = numberLength - (checkSum%numberLength);
	   
	   if(checkReg == 10){
		   checkReg = 0;
	   }
	   
	   if ( checkReg == reg ){
		   checktrue = true; 
	   }
		
	   System.out.println(checkSum);
		return checktrue;
	}
	

	public static void main(String[] args) {
		
		
		String jumin;
		
		
		System.out.print("주민번호를 입력하세요(xxxxxx-xxxxxxx) : " );
		Scanner scan = new Scanner(System.in);		
		jumin = scan.next();
		

		
		if(checkJumin(jumin)){
			System.out.println("정상입니다");
		}else{
			System.out.println("비정상입니다");
		}
		
	}

}
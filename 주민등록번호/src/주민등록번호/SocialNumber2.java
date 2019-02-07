package 주민등록번호;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class SocialNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String juminNum;
		int weight []={2,3,4,5,6,7,0,8,9,2,3,4,5};	//하이픈 -은 0을 가중치로 둔다
		int sum = 0;	//누적변수는 꼭 초기화시켜준다 왜냐하면 지역변수!!!!![주의!!!!]
		int temp, result;
		
		System.out.println("주민번호 입력: ");
		Scanner scan = new Scanner(System.in);
		juminNum=scan.next();
		
		for(int i=0;i<13;i++)
		{
			if(juminNum.charAt(i)=='-')
			{
				continue;	// '-'은 건너뛴다
			}
			sum= sum + (juminNum.charAt(i)-48) * weight[i]; //숫자문자가 정수문자로 변환된다
		}
		
		temp = 11 - (sum%11); //sum+temp-11의 배수
		result = temp %10;	//temp 값이 2자리면 한자리로 바꿈
		
		
		if(result == juminNum.charAt(13)-48)
		{
			System.out.println("주민번호 입니다");
			//정보추출
			
			//나이
			Calendar cal = Calendar.getInstance(Locale.KOREA);
			int year = cal.get(Calendar.YEAR);
			int yy = Integer.parseInt(juminNum.substring(0,2));
			
			if(juminNum.charAt(7)-48<3) yy=yy+1900;
			else yy=yy+2000;
			
			int age = year - yy + 1;	//본나이 -> 띠를 얻어오기 위해서
			System.out.println(age);
			
			
			//성병
			if(juminNum.charAt(7)-48%2==0) System.out.println("여자입니다");//2또는 4 --> 여자
			else System.out.println("남자입니다");
			
			//출신지역
			String [][] localecode = {{"서울", "00", "08"},
									  {"부산","09","11"},
									  {"인천","13","15"},
									  {"경기","16","25"},
									  {"강원","26","34"},
									  {"충북","35","39"},
									  {"대전","44","48"},
									  {"충남","41","43"},
									  {"충남","45","47"},
									  {"세종","44","44"},
									  {"세종","49","49"},
									  {"전북","48","54"},
									  {"전남","55","64"},
									  {"광주","65","66"},
									  {"대구","67","70"},
									  {"경북","71","80"},
									  {"경남","81","84"},
									  {"경남","86","90"},
									  {"울산","85","85"},
									  {"제주","91","95"}
			};
			//이게 가장 효율적이다!!!!!
			String localeString = juminNum.substring(8,10);
			int locale = Integer.parseInt(localeString);
			String birthplace = null;//지역변수 초기화!!!!!!!
			
			for(int i=0;i<20;i++)
			{
				if(locale >=Integer.parseInt(localecode[i][1])&&
				   locale<=Integer.parseInt(localecode[i][2]))
				{
					birthplace=localecode[i][0];
				}
			}
			System.out.println("출신지역은: "+birthplace);
			
			//띠추출
			int twelve = age %12;
			switch(twelve)
			{
			case 6: System.out.println("쥐띠");	break;
			case 7: System.out.println("소띠");	break;
			case 8: System.out.println("호랑이띠");	break;
			case 9: System.out.println("토끼띠");	break;
			case 10: System.out.println("용띠");	break;
			case 11: System.out.println("뱀띠");	break;
			case 0: System.out.println("말띠");	break;
			case 1: System.out.println("양띠");	break;
			case 2: System.out.println("원숭이띠");	break;
			case 3: System.out.println("닭띠");	break;
			case 4: System.out.println("개띠");	break;
			case 5: System.out.println("돼지띠");	break;
			}
			/*
			 String ddi= null
			 String []ganji={"원숭이","닭",....}
			 ddi=ganji[yy%12];
			 */
			
			System.out.println("생년월일 : "+yy+"/"+juminNum.substring(2,4)+"/"+juminNum.substring(4,6));
			
			
			
			
						
		}
		else System.out.println("주민번호가 아닙니다");
		
		
	}

}

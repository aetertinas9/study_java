package 컬렉션프레임워크예제;
import java.util.StringTokenizer;


public class StringTokenizerTest {

	//일반적으로는 default 생성자가 자동적으로 만들어진다!!컴파일시 그러나 상속의 경우 꼭 따로 선언이 필요하다!!!!!!!!!!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str="이름=홍길동/나이=34/출신지역=서울/직업=회사원";
		
		StringTokenizer st= new StringTokenizer(str,"/");
		
		
		int count=st.countTokens();
		System.out.println("Token 개수= "+ count);
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
	
		
		

	}

}

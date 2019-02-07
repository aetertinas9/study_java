package 컬랙션프레임워크연습;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String [] arr = {"김진명","최민호","조정래","박경리","정비석"};
		
		//String 객체만 저장하겠다
		Vector<String> vec = new Vector<String>(4,3);//"가변배열" 생성
		System.out.println("백터에 저장된 요소의 개수는: "+vec.size());//size()메소드는 객체의 개수
		System.out.println("백터의 용량은? : "+vec.capacity());//capacity()메소드는 객체의 용량
		
		
		for(int i=0;i<arr.length;i++)
		{
			vec.add(arr[i]);	//벡터 객체에 객체를 추가(삽입)시키는 메소드
		}
		
		System.out.println(vec);//[김진명, 최민호, 조정래, 박경리, 정비석] 주로 정수 출력에 사용
		
		for(String item: vec)
		{//확장된 for문
		System.out.print(item+"\t");//김진명	최민호	조정래	박경리	정비석 주로 객체 출력에 사용
		}//객체 없으면 for문 빠져나옴
		System.out.println("");
		
		
		
		//백터에 객체 추가
		vec.add(1, "박지성");
		System.out.println(vec);
		//[김진명, 박지성, 최민호, 조정래, 박경리, 정비석]
		
		//객체 삭제
		vec.remove(1);
		System.out.println(vec);
		//[김진명, 최민호, 조정래, 박경리, 정비석]
		
		System.out.println("백터에 저장된 요소의 개수는: "+vec.size());//size()메소드는 객체의 개수
		System.out.println("백터의 용량은? : "+vec.capacity());//capacity()메소드는 객체의 용량
		
		
		
		//특정객체만 가져오기 
		System.out.println(vec.get(2));
		

	}

}

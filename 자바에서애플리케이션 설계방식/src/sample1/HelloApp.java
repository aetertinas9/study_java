package sample1;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageBean bean = new MessageBean();
		
		//참조변수를 통해서 접근
		
		bean.sayHello("Kim");	//인자값준다
		bean.sayHello("김");		//이경우 다른 클래스를 한글로 다 수정해야한다!! 이게 클래스간의 강한결합의 단점 ->수정시 연결된 클래스도 다 수정해야한다
		
		
	}

}

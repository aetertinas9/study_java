package sample2;

public class HelloApp {

	public static void main(String[] args) {
		
		//°³¹ßÄÚµå
		
		MessageBean bean = new MessageBeanEn();
		MessageBean bean2 = new MessageBeanKr();
		
		bean.sayHello("Kim");
		bean2.sayHello("±è");
	}

}

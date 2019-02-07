package Ex1;

class Robot extends Thread{
	//생성자
	public Robot(String name){
		super(name);
		//슈퍼-> 상속받은 부모클래스의 생성자 호출
		//슈퍼는 자식생성자의 첫줄에 코딩해야 한다 
		//스러데는 먼저 cpu차지하면 먼저 실행 
	}
	
	@Override
	public void run(){
		//스래드 실행 내용 코딩
		for(int i=1;i<=5;i++)
		{
			System.out.println(getName()+" "+i);
		}
	}

	
}

public class Test1 {

	public static void main(String[] args) {
		
		Robot robot1 = new Robot("로봇-A");
		Robot robot2 = new Robot("로봇-B");
		
		robot1.start();
		robot2.start();
		
		
	}

}

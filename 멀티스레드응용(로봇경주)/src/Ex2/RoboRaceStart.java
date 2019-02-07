package Ex2;

//RoboRace 클래스 구현
class RoboRace extends Thread{
	
	//자식 클래스 생성자 구현
	public RoboRace(String name){
		
		super(name);
				
	}	
	@Override
	public void run() {
		//스래스 실행 내용 코딩한다
		for(int i=1;i<=4;i++){
		System.out.println(getName()+"가 "+i*10+"m전진");
		try{
			sleep(1000);	//1000.1000초 -> 1초 지연
		}catch(InterruptedException e){
			System.out.println(e.toString());
		}		
		}
		
		
		System.out.println(getName()+"가 결승점에 도착");
		
		
	}
}
public class RoboRaceStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RoboRace robotA = new RoboRace("로봇-A");	
		RoboRace robotB = new RoboRace("로봇-B");
		RoboRace robotC = new RoboRace("로봇-C");
		
		robotA.start();
		robotB.start();
		robotC.start();

	}

}

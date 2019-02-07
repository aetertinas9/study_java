
public class Myclass {

	public static void main(String[] args) {
		// 개발코드!!!!!!!!!!!!!!!!!
		
		RemoteControl rc =null;
		
		rc = new Television();//구현객체
		rc.turnOn();
		rc.setVolume(10);
		
		rc.setMuta(true);
		RemoteControl.changeBattery();
		rc.turnOff();
		
		rc = new Audio();
		

	}

}


public class Myclass {

	public static void main(String[] args) {
		// �����ڵ�!!!!!!!!!!!!!!!!!
		
		RemoteControl rc =null;
		
		rc = new Television();//������ü
		rc.turnOn();
		rc.setVolume(10);
		
		rc.setMuta(true);
		RemoteControl.changeBattery();
		rc.turnOff();
		
		rc = new Audio();
		

	}

}

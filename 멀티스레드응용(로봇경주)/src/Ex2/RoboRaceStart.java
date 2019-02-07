package Ex2;

//RoboRace Ŭ���� ����
class RoboRace extends Thread{
	
	//�ڽ� Ŭ���� ������ ����
	public RoboRace(String name){
		
		super(name);
				
	}	
	@Override
	public void run() {
		//������ ���� ���� �ڵ��Ѵ�
		for(int i=1;i<=4;i++){
		System.out.println(getName()+"�� "+i*10+"m����");
		try{
			sleep(1000);	//1000.1000�� -> 1�� ����
		}catch(InterruptedException e){
			System.out.println(e.toString());
		}		
		}
		
		
		System.out.println(getName()+"�� ������� ����");
		
		
	}
}
public class RoboRaceStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RoboRace robotA = new RoboRace("�κ�-A");	
		RoboRace robotB = new RoboRace("�κ�-B");
		RoboRace robotC = new RoboRace("�κ�-C");
		
		robotA.start();
		robotB.start();
		robotC.start();

	}

}

package CarŬ��������;

//�ڽ�Ŭ����!!!!!!!!!!!!!!!�θ�Ŭ������ Car




public class Truck extends Car{

		// TODO Auto-generated constructor stub


	//extends Ŭ������ ��ӽ� ����Ѵ�!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	public void speedUp(int velocity)
	{
		speed = speed + velocity;
		if(speed>110)
			speed = 100;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Truck myTruck = new Truck();
		
		myTruck.speedUp(150);
		System.out.println("Ʈ���� �ӵ���: "+myTruck.speed);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

package Car클래스구현;

//자식클래스!!!!!!!!!!!!!!!부모클래스는 Car




public class Truck extends Car{

		// TODO Auto-generated constructor stub


	//extends 클래스는 상속시 사용한다!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
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
		System.out.println("트럭의 속도는: "+myTruck.speed);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

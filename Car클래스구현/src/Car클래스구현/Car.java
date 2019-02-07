package Car클래스구현;

public class Car {	//부모클래스 또는 상위클래스 -> 부모는 main method 포함 X

	
	//객체가 가져야할 속성(데이터)
	protected int speed;		//현재속도
	protected int wheelNum;	//바퀴수
	protected String carName;	//자동차이름
	
	//상속관계는 private 못쓰고 protected사용!!!!!!!!!!!!!!!!
	
	//생성자 구분 ==> 다형성!!!!!!!!
	
	//상속을 위해 default 생성자를 추가해달라!!!!!!!!!!!111
	public Car()
	{
	}
	
	
	
	public Car(String name)
	{
		carName = name;
	}
	
	public Car(int velocity)
	{
		speed=velocity;
	}
	public Car(String name, int velocity)
	{
		carName= name;
		speed = velocity;
	}
	//메소드 구현
	
	//Car 클래스를 Truck 클래스로 상속!!!!!!!!1
	//순수한 클래스를 만들기 위해 멤버변수, 메소드 , 클래스, 메인제거 -> 실행은 안됨 
	
	
	//메소드 오버로딩!!!!!!!!->다형성!!!!!!!!!!
	public void speedUp()
	{
		speed = speed + 10;
	}
	public void speedDown()
	{
		speed = speed - 10;	
	}
	public void speedUp(int velocity)
	{
		speed = speed +velocity;
	}
	public void speedDown(int velocity)
	{
		speed -=velocity;
	}
	public void stop()
	{
		speed=0;
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car myCar, yourCar, hisCar; 	//참조변수
		
		myCar = new Car("제네시스");	//String 입력했으니 name에 저장
		yourCar = new Car(120);		//int 입력했으니 속도에 저장 
		hisCar = new Car("체어맨",150);
		
		System.out.println("내차는 : "+myCar.carName);
		System.out.println("네차의 현재속도는: "+yourCar.speed);
		System.out.println("그의차의 종류는 :"+hisCar.carName +"그의차의 현재속도는: "+hisCar.speed);
		

	}

}
*/
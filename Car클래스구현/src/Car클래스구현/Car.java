package CarŬ��������;

public class Car {	//�θ�Ŭ���� �Ǵ� ����Ŭ���� -> �θ�� main method ���� X

	
	//��ü�� �������� �Ӽ�(������)
	protected int speed;		//����ӵ�
	protected int wheelNum;	//������
	protected String carName;	//�ڵ����̸�
	
	//��Ӱ���� private ������ protected���!!!!!!!!!!!!!!!!
	
	//������ ���� ==> ������!!!!!!!!
	
	//����� ���� default �����ڸ� �߰��ش޶�!!!!!!!!!!!111
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
	//�޼ҵ� ����
	
	//Car Ŭ������ Truck Ŭ������ ���!!!!!!!!1
	//������ Ŭ������ ����� ���� �������, �޼ҵ� , Ŭ����, �������� -> ������ �ȵ� 
	
	
	//�޼ҵ� �����ε�!!!!!!!!->������!!!!!!!!!!
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
		
		Car myCar, yourCar, hisCar; 	//��������
		
		myCar = new Car("���׽ý�");	//String �Է������� name�� ����
		yourCar = new Car(120);		//int �Է������� �ӵ��� ���� 
		hisCar = new Car("ü���",150);
		
		System.out.println("������ : "+myCar.carName);
		System.out.println("������ ����ӵ���: "+yourCar.speed);
		System.out.println("�������� ������ :"+hisCar.carName +"�������� ����ӵ���: "+hisCar.speed);
		

	}

}
*/
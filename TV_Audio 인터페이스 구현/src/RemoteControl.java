
public interface RemoteControl {

	
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int Volume);
	
	//�ڹ�8�������� -> ����Ʈ �޼ҵ�, �����޼ҵ� ������ �����ϴ�
	default void setMuta(boolean muta)
	{
		if(muta)
		{
			System.out.println("����ó���մϴ�");
		}
		else 
			System.out.println("���� �����մϴ�");
			
			
	}
	//default �޼ҵ� �뵵 -> ���� �������̽��� Ȯ���Ͽ� ���ο� ����� �߰��ϱ� 
	//�����޼ҵ� ����Ʈ�޼ҵ�ʹ� �޸� ��ü�� ��� �������̽������� ȣ���� ����

	static void changeBattery()
	{
		System.out.println("�������� ��ȯ�ϼ���");
	}

	//����Ʈ ���� �޼ҵ�� ������ �ִ� �޼ҵ�!!!!!!override�ʿ� x
}

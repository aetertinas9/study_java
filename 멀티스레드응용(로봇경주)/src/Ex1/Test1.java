package Ex1;

class Robot extends Thread{
	//������
	public Robot(String name){
		super(name);
		//����-> ��ӹ��� �θ�Ŭ������ ������ ȣ��
		//���۴� �ڽĻ������� ù�ٿ� �ڵ��ؾ� �Ѵ� 
		//�������� ���� cpu�����ϸ� ���� ���� 
	}
	
	@Override
	public void run(){
		//������ ���� ���� �ڵ�
		for(int i=1;i<=5;i++)
		{
			System.out.println(getName()+" "+i);
		}
	}

	
}

public class Test1 {

	public static void main(String[] args) {
		
		Robot robot1 = new Robot("�κ�-A");
		Robot robot2 = new Robot("�κ�-B");
		
		robot1.start();
		robot2.start();
		
		
	}

}

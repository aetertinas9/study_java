package �������̽��ǽ�����;

//�������̽� ����!!!!!!!!!!!!!
interface Fruit
{
	//�������̽� �ȿ��� ����� �߻�޼ҵ常 ��!!!!!!!!!!!
	int APPLE = 1;//������� �빮�ڷ� ���ش� -> ����
	int BANANA = 2;
	int CHERRY=3; //������ �׳� �̷��� �ᵵ �ȴ�
	//��� �տ��� public static final
	
	public abstract void select();
	public abstract void setFruit (int fruitsel);
	public abstract int getFruit ();
	
	//�߻󺯼� �տ��� public abstract 
	
	
}
interface Selection
{
	//�߻�޼ҵ常 ����
	void select();
	
	
}

class FruitSelection implements Fruit, Selection{
	
	//�긦 ���ؼ� ��ü���� ��ȣ�ۿ��� �ϰڴ�
	
	int fruit = 0;
	
	@Override	//����ټ� -> �����Ϸ����� �뺸�ϴ� �� �������̵� �ҰŴ�
	public void select()
	{
		System.out.println("�� �����ϴ�.");
	}
	@Override	//�������̵�-> �θ��� �߻�޼ҵ带 �ڽ��� �������ؼ����ڴ�
	public void setFruit(int fruitsel)
	{
		this.fruit = fruitsel;
		//this. �� �Ⱦ����� �������� ��������� �̸��� �״�� ����Ҷ��� �� this�� ������Ѵ�. this.fruit=fruit �̷���� �����ʿ�!!����� ��ü ǥ��
	}
	//���� �ص����� �ϰ� �˾Ƽ� ä���� ��
	@Override
	public int getFruit() {
		return fruit;
	}
	
}

public class interfaceTest {

	public static void main(String[] args) {
		//�����ڵ�!!!!!!!!!!
		
		FruitSelection fru = new FruitSelection();
		fru.setFruit(Fruit.APPLE);
		
		switch(fru.getFruit())
		{
		
		case Fruit.APPLE:
			System.out.println("���");
			break;
		case Fruit.BANANA:
			System.out.println("�ٳ���");
			break;
		case Fruit.CHERRY:
			System.out.println("ü��");
			break;
		}
				
		
		
		
		
		

	}

}

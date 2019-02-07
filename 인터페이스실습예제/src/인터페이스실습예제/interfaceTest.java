package 인터페이스실습예제;

//인터페이스 선언!!!!!!!!!!!!!
interface Fruit
{
	//인터페이스 안에는 상수와 추상메소드만 들어감!!!!!!!!!!!
	int APPLE = 1;//상수명은 대문자로 해준다 -> 관례
	int BANANA = 2;
	int CHERRY=3; //하지만 그냥 이렇게 써도 된다
	//상수 앞에는 public static final
	
	public abstract void select();
	public abstract void setFruit (int fruitsel);
	public abstract int getFruit ();
	
	//추상변수 앞에는 public abstract 
	
	
}
interface Selection
{
	//추상메소드만 선언
	void select();
	
	
}

class FruitSelection implements Fruit, Selection{
	
	//얘를 통해서 객체간의 상호작용을 하겠다
	
	int fruit = 0;
	
	@Override	//언어텐션 -> 컴파일러에게 통보하는 것 오버라이드 할거다
	public void select()
	{
		System.out.println("를 선택하다.");
	}
	@Override	//오버라이드-> 부모의 추상메소드를 자식이 재정의해서쓰겠다
	public void setFruit(int fruitsel)
	{
		this.fruit = fruitsel;
		//this. 과 안쓴점의 차이점은 멤버변수의 이름을 그대로 사용할때는 꼭 this를 써줘야한다. this.fruit=fruit 이런경우 구분필요!!나라는 객체 표현
	}
	//선언만 해뒀으니 니가 알아서 채워서 써
	@Override
	public int getFruit() {
		return fruit;
	}
	
}

public class interfaceTest {

	public static void main(String[] args) {
		//개발코드!!!!!!!!!!
		
		FruitSelection fru = new FruitSelection();
		fru.setFruit(Fruit.APPLE);
		
		switch(fru.getFruit())
		{
		
		case Fruit.APPLE:
			System.out.println("사과");
			break;
		case Fruit.BANANA:
			System.out.println("바나나");
			break;
		case Fruit.CHERRY:
			System.out.println("체리");
			break;
		}
				
		
		
		
		
		

	}

}


public interface RemoteControl {

	
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int Volume);
	
	//자바8버전에서 -> 디폴트 메소드, 정적메소드 선언이 가능하다
	default void setMuta(boolean muta)
	{
		if(muta)
		{
			System.out.println("무음처리합니다");
		}
		else 
			System.out.println("무음 해제합니다");
			
			
	}
	//default 메소드 용도 -> 기존 인터페이스를 확장하여 새로운 기능을 추가하기 
	//정적메소드 디폴트메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능

	static void changeBattery()
	{
		System.out.println("건전지를 교환하세요");
	}

	//디폴트 정적 메소드는 내용이 있는 메소드!!!!!!override필요 x
}

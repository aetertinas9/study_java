
public class Audio implements RemoteControl{

	private int volume;
	@Override
	public void turnOn() {
		
		System.out.println("AUDIO를 켠다");
	}

	@Override
	public void turnOff() {
		System.out.println("AUDIO를 끈다");
	}

	@Override
	public void setVolume(int volume) {
	
		if(volume>RemoteControl.MAX_VOLUME)
			this.volume=RemoteControl.MAX_VOLUME;
		else if(volume<RemoteControl.MIN_VOLUME)
			this.volume=RemoteControl.MIN_VOLUME;
		else 
			this.volume=volume;
		
		System.out.println("현재 AUDIO 볼륨은: "+this.volume);//주의!!!this를 반드시 붙여줘야한다!!!!!!!!
		
	}
}


public class Audio implements RemoteControl{

	private int volume;
	@Override
	public void turnOn() {
		
		System.out.println("AUDIO�� �Ҵ�");
	}

	@Override
	public void turnOff() {
		System.out.println("AUDIO�� ����");
	}

	@Override
	public void setVolume(int volume) {
	
		if(volume>RemoteControl.MAX_VOLUME)
			this.volume=RemoteControl.MAX_VOLUME;
		else if(volume<RemoteControl.MIN_VOLUME)
			this.volume=RemoteControl.MIN_VOLUME;
		else 
			this.volume=volume;
		
		System.out.println("���� AUDIO ������: "+this.volume);//����!!!this�� �ݵ�� �ٿ�����Ѵ�!!!!!!!!
		
	}
}

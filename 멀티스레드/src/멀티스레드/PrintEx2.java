package ��Ƽ������;

public class PrintEx2 { //��Ƽ������ ����
	/*
	 * ���� �����尡 �۾� �����带 �����ϰ� �����Ѵ�.
	 */
	public static void main(String[] args) {
		//�۾������� ����� ����
		Runnable beepTask = new BeepTask();
		
		Thread thread = new Thread(beepTask);
		
		thread.start(); // �� �������� �ΰ��� �����尡 ���ÿ� ����ȴ�. �۾��������� run() �޼ҵ� ȣ��
		//�۾������� ����� ��
		
		for(int i=0; i<5; i++){
			System.out.println("��");
			try{
				Thread.sleep(1000); //1�ʰ� ����
			} catch(Exception e){
				System.out.println(e);
			}
		}

	}

}

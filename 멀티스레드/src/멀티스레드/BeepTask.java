package 멀티스레드;

import java.awt.Toolkit;

public static void main(String[] args){

	Runnable beepTask = new BeepTask();
	Thread thread = new Thread(beepTask);
	
	thread.start();
	
	for(int i=0;i<5; i++){
		System.out.println("띵");//5번
		try{
			Thread.sleep(1000); //1초간 정지
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
}
}


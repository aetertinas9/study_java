package 멀티스레드;

public class PrintEx2 { //멀티스레드 구현
	/*
	 * 메인 스레드가 작업 스레드를 생성하고 실행한다.
	 */
	public static void main(String[] args) {
		//작업스레드 만들기 시작
		Runnable beepTask = new BeepTask();
		
		Thread thread = new Thread(beepTask);
		
		thread.start(); // 이 시점에서 두개의 스레드가 동시에 실행된다. 작업스레드의 run() 메소드 호출
		//작업스레드 만들기 끝
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try{
				Thread.sleep(1000); //1초간 정지
			} catch(Exception e){
				System.out.println(e);
			}
		}

	}

}

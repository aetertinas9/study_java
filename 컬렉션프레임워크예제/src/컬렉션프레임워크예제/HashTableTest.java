package 컬렉션프레임워크예제;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] userId = {"Lee","kim","jang","wang","Ha"};
		String [] passWord = {"L123","K456","J234","W876","H23"};
		
		//HashTable 객체 생성
		Hashtable<String,String> ht = new Hashtable<String,String>(5);
		
		for(int i=0;i<5;i++)
		{
			ht.put(userId[i], passWord[i]);
		}
		System.out.println(ht);
		//{Ha=H23, kim=K456, jang=J234, Lee=L123, wang=W876}

		
		boolean run = true;
		while(run)
		{
			System.out.println("유저 Id는?: ");
			Scanner scan = new Scanner(System.in);
			String user_key=scan.next();
			String pw_value=ht.get(user_key);
			
			if(pw_value !=null){
				System.out.println("유저 암호는? ");
				String passwordInput = scan.next();
				
				if(pw_value.equals(passwordInput))
				{
					System.out.println("암호가 일치합니다");
				}
				else System.out.println("암호가 일치하지 않습니다");
			}
			else
			{
				System.out.println("유저 Id가 등록되어있지 않습니다");
				run = false;
			}
		
		}
	}
		

}

package �÷��������ӿ�ũ����;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] userId = {"Lee","kim","jang","wang","Ha"};
		String [] passWord = {"L123","K456","J234","W876","H23"};
		
		//HashTable ��ü ����
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
			System.out.println("���� Id��?: ");
			Scanner scan = new Scanner(System.in);
			String user_key=scan.next();
			String pw_value=ht.get(user_key);
			
			if(pw_value !=null){
				System.out.println("���� ��ȣ��? ");
				String passwordInput = scan.next();
				
				if(pw_value.equals(passwordInput))
				{
					System.out.println("��ȣ�� ��ġ�մϴ�");
				}
				else System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�");
			}
			else
			{
				System.out.println("���� Id�� ��ϵǾ����� �ʽ��ϴ�");
				run = false;
			}
		
		}
	}
		

}

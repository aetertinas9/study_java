package �÷��������ӿ�ũ����;
import java.util.StringTokenizer;


public class StringTokenizerTest {

	//�Ϲ������δ� default �����ڰ� �ڵ������� ���������!!�����Ͻ� �׷��� ����� ��� �� ���� ������ �ʿ��ϴ�!!!!!!!!!!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str="�̸�=ȫ�浿/����=34/�������=����/����=ȸ���";
		
		StringTokenizer st= new StringTokenizer(str,"/");
		
		
		int count=st.countTokens();
		System.out.println("Token ����= "+ count);
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
	
		
		

	}

}

package �÷��������ӿ�ũ����;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String [] arr = {"������","�ֹ�ȣ","������","�ڰ渮","����"};
		
		//String ��ü�� �����ϰڴ�
		Vector<String> vec = new Vector<String>(4,3);//"�����迭" ����
		System.out.println("���Ϳ� ����� ����� ������: "+vec.size());//size()�޼ҵ�� ��ü�� ����
		System.out.println("������ �뷮��? : "+vec.capacity());//capacity()�޼ҵ�� ��ü�� �뷮
		
		
		for(int i=0;i<arr.length;i++)
		{
			vec.add(arr[i]);	//���� ��ü�� ��ü�� �߰�(����)��Ű�� �޼ҵ�
		}
		
		System.out.println(vec);//[������, �ֹ�ȣ, ������, �ڰ渮, ����] �ַ� ���� ��¿� ���
		
		for(String item: vec)
		{//Ȯ��� for��
		System.out.print(item+"\t");//������	�ֹ�ȣ	������	�ڰ渮	���� �ַ� ��ü ��¿� ���
		}//��ü ������ for�� ��������
		System.out.println("");
		
		
		
		//���Ϳ� ��ü �߰�
		vec.add(1, "������");
		System.out.println(vec);
		//[������, ������, �ֹ�ȣ, ������, �ڰ渮, ����]
		
		//��ü ����
		vec.remove(1);
		System.out.println(vec);
		//[������, �ֹ�ȣ, ������, �ڰ渮, ����]
		
		System.out.println("���Ϳ� ����� ����� ������: "+vec.size());//size()�޼ҵ�� ��ü�� ����
		System.out.println("������ �뷮��? : "+vec.capacity());//capacity()�޼ҵ�� ��ü�� �뷮
		
		
		
		//Ư����ü�� �������� 
		System.out.println(vec.get(2));
		

	}

}

package �ζǹ�ȣ������;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LottoGetNumber extends JFrame implements ActionListener{
	//��ü �������� ����
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton btn;
	JTextArea txt;
	
	
	//������ ����
	public LottoGetNumber()
	{
		setTitle("����� �ζǹ�ȣ ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf1=new JTextField(2);
		tf2=new JTextField(2);
		tf3=new JTextField(2);
		tf4=new JTextField(2);
		tf5=new JTextField(2);
		tf6=new JTextField(2);
		
		
		
		
		
		btn = new JButton("Lotto Get Button");
		btn.setBackground(Color.YELLOW);
		
		setLayout(new FlowLayout());
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(btn);
		
		btn.addActionListener(this);
		setSize(400,300);
		setLocation(700,150);
		setVisible(true);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ó����� ����
		/*
���� �߻� Ŭ���� rnd ����
	1~45����
	Random();	


6���� �ζ� ��ȣ ���� �߻�
	for(int i=0; i<6;i++)
	LottoNumber[i]=rnd.nextInt(45)+1;

�ߺ��� ���� �ٽ� ���� �߻��Լ���

	for(int j=0; j<i; j++)
	if(LottoNumber[i]==LottoNuber[i])
	i--;

���
		 */
		int[] LottoNumber = new int [6];
		int n=6;
		int temp;//���ľ˰���
		int i,j;
		int index =0;
		
		
		Random rand = new Random();
		//�ߺ�üũ!!!
		while(index<n)
		{
			int rnd = rand.nextInt(45)+1; //1~45���� ���� �߻�
			boolean FLAG = false;
			
			
			for(i=0;i<n;i++)
			{	
				if(rnd ==LottoNumber[i])
				{
				FLAG = true;
				break;
				}
				
				if(FLAG ==false)
				{
					LottoNumber[i]=rnd;
					index++;
				}
					for(j=0;j<n;j++)
			{
				if(LottoNumber[i]>LottoNumber[j])
				{
					temp=LottoNumber[i];
					LottoNumber[i]=LottoNumber[j];
					LottoNumber[j]=temp;
				}
			}
			
			}

			tf1.setText(Integer.toString(LottoNumber[0]));
			tf2.setText(Integer.toString(LottoNumber[1]));
			tf3.setText(Integer.toString(LottoNumber[2]));
			tf4.setText(Integer.toString(LottoNumber[3]));
			tf5.setText(Integer.toString(LottoNumber[4]));
			tf6.setText(Integer.toString(LottoNumber[5]));

		
			
			
		}
		
		
	}

	
	
	
	public static void main(String[] args) {
		new LottoGetNumber();
	}
	
	
	
	
	
}

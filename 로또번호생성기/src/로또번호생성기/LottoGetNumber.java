package 로또번호생성기;

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
	//객체 참조변수 선언
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton btn;
	JTextArea txt;
	
	
	//생성자 구현
	public LottoGetNumber()
	{
		setTitle("행운의 로또번호 생성기");
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
		//시나리오 설정
		/*
난수 발생 클래스 rnd 생성
	1~45까지
	Random();	


6개의 로또 번호 난수 발생
	for(int i=0; i<6;i++)
	LottoNumber[i]=rnd.nextInt(45)+1;

중복된 값은 다시 난수 발생함수로

	for(int j=0; j<i; j++)
	if(LottoNumber[i]==LottoNuber[i])
	i--;

출력
		 */
		int[] LottoNumber = new int [6];
		int n=6;
		int temp;//정렬알고리즘
		int i,j;
		int index =0;
		
		
		Random rand = new Random();
		//중복체크!!!
		while(index<n)
		{
			int rnd = rand.nextInt(45)+1; //1~45까지 난수 발생
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

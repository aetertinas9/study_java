package ��ư������Ʈ�̺�Ʈó��;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
						//���			//�������̽� ����
public class ButtonEvent extends JFrame implements ActionListener{

	JButton btn;
	JTextArea txt;
	
	public ButtonEvent ()
	{
		//������, ���۳�Ʈ ��ü����, �̺�Ʈ ���� -> �ڈ�
		setTitle("��ư �̺�Ʈ ó�� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������Ʈ ��ü ����
	
		btn = new JButton("��ư�� ����");
		btn.setBackground(Color.YELLOW);
		txt = new JTextArea();
		//���̾ƿ� ������ ��ü ���� �� ������Ʈ ��ġ
		setLayout(new BorderLayout());
		add(btn,BorderLayout.NORTH);
		add(txt,BorderLayout.CENTER);	//��ġ
		//��ü ����� ������
		
		//�ȵ���̵� ���Ǵ� �ٷ� �����غ��� ����
		
		btn.addActionListener(this);
		
		
		setSize(300,300);
		setLocation(700,150);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		//������ ���α׷����� ����� �� ����� �Ѵ� JFrame!! �ϳ��� ��Ӱ����ϹǷ� �������� �������̽�!!!
		
		new ButtonEvent();	//��ü ������ ���ÿ� ������ ȣ��		
		
	}

	@Override	//������
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		txt.setText(txt.getText()+"��ư�� �������"+"\n");
		
		
	}

}

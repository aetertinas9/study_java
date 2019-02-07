package 버튼컴포넌트이벤트처리;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
						//상속			//인터페이스 구현
public class ButtonEvent extends JFrame implements ActionListener{

	JButton btn;
	JTextArea txt;
	
	public ButtonEvent ()
	{
		//디자인, 컴퍼넌트 객체생성, 이벤트 연결 -> 코닏
		setTitle("버튼 이벤트 처리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//컴포넌트 객체 생성
	
		btn = new JButton("버튼을 누름");
		btn.setBackground(Color.YELLOW);
		txt = new JTextArea();
		//레이아웃 관리자 객체 생성 및 컴포넌트 배치
		setLayout(new BorderLayout());
		add(btn,BorderLayout.NORTH);
		add(txt,BorderLayout.CENTER);	//배치
		//객체 만드는 생성자
		
		//안드로이드 강의는 바로 실행해볼수 있음
		
		btn.addActionListener(this);
		
		
		setSize(300,300);
		setLocation(700,150);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		//윈도우 프로그래밍은 상속을 꼭 해줘야 한다 JFrame!! 하나만 상속가능하므로 나머지는 인터페이스!!!
		
		new ButtonEvent();	//객체 생성과 동시에 생성자 호출		
		
	}

	@Override	//재정의
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		txt.setText(txt.getText()+"버튼을 눌렀어요"+"\n");
		
		
	}

}

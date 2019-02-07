import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CheckBoxEventTest extends JFrame implements ItemListener{
	
	JLabel fruit = new JLabel ("사과 1000원,배 1500원, 체리 3000원");
	JCheckBox[] fruits = new JCheckBox[3];
	String [] names = {"사과","배","체리"};
	JLabel sumLabel;
	int sum=0;
	
	//생성자 구현
	public CheckBoxEventTest() {
		
		setTitle("체크박스 이벤트 처리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(fruit);
		for(int i=0;i<fruits.length;i++)
		{
			fruits[i]=new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
		//	fruits[i].setBackground(Color.YELLOW);
		
			add(fruits[i]);
			fruits[i].addItemListener(this);
		}
		
		sumLabel = new JLabel("현재 0원입니다");
		add(sumLabel);
		
		setSize(250,200);
		setLocation(700,150);
		setVisible(true);
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		//추상메소드 재정의
		
		
		int selected = 0;
		
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			selected=1;
		}
		else selected = -1;
		
		if(e.getSource()==fruits[0])
		{
			sum +=1000;
		}
		else if(e.getSource()==fruits[1])
		{
			sum +=1500;
		}
		else
		{
			sum +=3000;
		}
		sumLabel.setText("현재 금액은 "+sum+"입니다");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxEventTest();
	}
}

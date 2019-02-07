package 제이프레임컴퍼넌트;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JComponentEventTest extends JFrame implements ActionListener{
		String[] fruits={"apple","banana","kiwi","orange"};
		JComboBox<String> strcombo;
		JLabel label = new JLabel(); 
		JTextField textField = new JTextField();

		
	
	ImageIcon [] images ={  new ImageIcon("images/apple.jpg"),
							new ImageIcon("images/banan.jpg"),
							new ImageIcon("images/kiwi.jpg"),
							new ImageIcon("images/orange.jpg"),
	};
	
	
	
	
	public JComponentEventTest() {
		// TODO Auto-generated constructor stub
		

		
		
		setTitle("체크박스 이벤트 에러");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(120, 120);
		setLayout(new FlowLayout());//체크박스 객체 생성

		strcombo = new JComboBox<String>(fruits);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox<String> cb= (JComboBox<String>) e.getSource();
		
		int index=cb.getSelectedIndex();

		
	//	imgLabel.setIcon(images[index]);	
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComponentEventTest();
			
	}

}

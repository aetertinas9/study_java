import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;




public class JradioButtonEvent extends JFrame implements ItemListener {

	JRadioButton [] radio = new JRadioButton[3];
	String[] text = {"사과","배","체리"};
	JRadioButton[] image={new ImageIcon(images/apple.jpg),
							
							};
								
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JradioButtonEvent()
	{
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

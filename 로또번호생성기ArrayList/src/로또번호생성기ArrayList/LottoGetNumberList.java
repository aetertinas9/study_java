package 로또번호생성기ArrayList;

	import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class LottoGetNumberList extends JFrame implements ActionListener {
	
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton btn;
	JTextArea txt;
	
	
	public LottoGetNumberList()
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
			
		List<Integer>list = new ArrayList<Integer>();
		
		for(int i=1;i<=45;i++)
		{
			list.add(new Integer(i));
		}
		
		Collections.shuffle(list);
		
		List<Integer> sub = list.subList(0, 6);
		Collections.sort(sub);
		
		tf1.setText(String.valueOf(sub.get(0)));
		tf2.setText(String.valueOf(sub.get(1)));
		tf3.setText(String.valueOf(sub.get(2)));
		tf4.setText(String.valueOf(sub.get(3)));
		tf5.setText(String.valueOf(sub.get(4)));
		tf6.setText(String.valueOf(sub.get(5)));
			
			
			
			
			
			
			
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LottoGetNumberList();
	}



}

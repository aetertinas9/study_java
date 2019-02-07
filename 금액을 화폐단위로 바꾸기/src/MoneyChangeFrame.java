import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class MoneyChangeFrame extends JFrame{
//�ܺ�Ŭ���� ������
	public MoneyChangeFrame(){
		setTitle("�ݾ��� ȭ������� ��ȯ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(350,300);//��üũ��
		setLocation(700,150);
		setVisible(true);

	}	
	
	class MyPanel extends JFrame{
		//���� Ŭ����
		
			int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
			String[] str = {"��������","������","��õ����","õ����","�����","���","���ʿ�","�ʿ�","�Ͽ�"};
			
			JTextField source;
			JTextField tf[] = new JTextField[9];
			//���� Ŭ���� ������
					
			public MyPanel(){
				
				setBackground(Color.GRAY);
				setLayout(null); //���̾ƿ� ����� ���� ���� 
				
				JLabel la= new JLabel("�ݾ�");
				la.setHorizontalAlignment(JLabel.RIGHT);
				la.setSize(50,20);
				la.setLocation(20,20);
				add(la);
				
				source = new JTextField(25);
				source.setSize(100,20);
				source.setLocation(100,10);
				add(source);
				
				JButton calcbtn = new JButton("���");
				calcbtn.setSize(70,20);
				calcbtn.setLocation(210,20);
				add(calcbtn);
				
				for(int i=0;i<str.length;i++)
				{
					la=new JLabel(str[i]);
					la.setHorizontalAlignment(JLabel.RIGHT);
					la.setSize(50,20);
					la.setLocation(50,50+i*20);
					add(la);
					
					tf[i]=new JTextField(20);
					tf[i].setHorizontalAlignment(JLabel.CENTER);
					tf[i].setSize(70,20);
					tf[i].setLocation(120,50+i*20);
					add(tf[i]);
				}
				//end for��
				//�̺�Ʈ �� �ڵ鷯 ó�� ���ÿ�
				calcbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String gstr = source.getText();
						if(gstr.length()==0)
						{
							//�Է¹����� ����
							return;
						}
						int money=Integer.parseInt(gstr);
						for(int i=0;i<unit.length;i++)
						{
							int portion = money/unit[i];
							tf[i].setText(Integer.toString(portion));//���� ��üȭ toString 
							if(portion>0) money=money%unit[i];
						}
						
						
					}
				});
				
				
				
				
			}		
			
		}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	new MoneyChangeFrame();//�ڵ����� ������ ���
			

	}
	

}

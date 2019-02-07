import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class MoneyChangeFrame extends JFrame{
//외부클래스 생성자
	public MoneyChangeFrame(){
		setTitle("금액을 화폐단위로 변환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(350,300);//전체크기
		setLocation(700,150);
		setVisible(true);

	}	
	
	class MyPanel extends JFrame{
		//내부 클래스
		
			int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
			String[] str = {"오만원권","만원권","오천원권","천원권","오백원","백원","오십원","십원","일원"};
			
			JTextField source;
			JTextField tf[] = new JTextField[9];
			//내부 클래스 생성자
					
			public MyPanel(){
				
				setBackground(Color.GRAY);
				setLayout(null); //레이아웃 사용자 자유 해지 
				
				JLabel la= new JLabel("금액");
				la.setHorizontalAlignment(JLabel.RIGHT);
				la.setSize(50,20);
				la.setLocation(20,20);
				add(la);
				
				source = new JTextField(25);
				source.setSize(100,20);
				source.setLocation(100,10);
				add(source);
				
				JButton calcbtn = new JButton("계산");
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
				//end for문
				//이벤트 및 핸들러 처리 동시에
				calcbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String gstr = source.getText();
						if(gstr.length()==0)
						{
							//입력받은게 없다
							return;
						}
						int money=Integer.parseInt(gstr);
						for(int i=0;i<unit.length;i++)
						{
							int portion = money/unit[i];
							tf[i].setText(Integer.toString(portion));//숫자 객체화 toString 
							if(portion>0) money=money%unit[i];
						}
						
						
					}
				});
				
				
				
				
			}		
			
		}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	new MoneyChangeFrame();//자동으로 생성자 출력
			

	}
	

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class JTableApp extends JFrame{
	//외부 클래스
	
	//전역변수 내부클래스 객체 미리 생성
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	
	int updateRow;//나중에 어디든 접근 가능
	
	
	
	

	//생성자 구현->외부 클래스
	
	public JTableApp(){
		
		setTitle("JTable (응용,추가,수정,삭제)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		add(menuMain.bar, BorderLayout.NORTH);
		add(west,BorderLayout.WEST);
		add(buttons, BorderLayout.SOUTH);
		add(showTable.scrollpane,BorderLayout.CENTER);
		
		
		setSize(600,300);
		setLocation(700,200);
		setVisible(true);
		
		
	}
	
	//MenuMain 내부 클래스 구현
	class MenuMain extends JPanel implements ActionListener, ItemListener
	{
	
		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fopen, fsave, fexit, proInfo;
		JCheckBoxMenuItem sname; //이름가지고 정렬
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, saveFileName, readFileName;
		
		
		//생성자 구현하기
		public MenuMain(){
			
			bar=new JMenuBar();
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			fopen = new JMenuItem("열기");
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			proInfo = new JMenuItem("프로그램 정보");
			
			sname = new JCheckBoxMenuItem("이름정렬");
			
			file.add(fopen); file.add(fsave);
			file.addSeparator();
			file.add(fexit);
			
			sort.add(sname);
			help.add(proInfo);
			bar.add(file);
			bar.add(sort);
			bar.add(help);
			
			fopen.addActionListener(this);
			fsave.addActionListener(this);
			fexit.addActionListener(this);
						
			sname.addItemListener(this);
			
			
			
			
			
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class West extends JPanel{
		
		JLabel la;
		JTextField tf[];
		
		public West(){
		
			setBorder(new TitledBorder(new LineBorder(Color.BLUE,2)));
			
			String text[]={"이름","핸드폰번호","주민번호"};
			tf = new JTextField[3];
			setLayout(new GridLayout(3,2,5,10));
			
			for(int i=0; i<text.length; i++){
				la = new JLabel(text[i]);
				tf[i]=new JTextField(20);
				la.setHorizontalAlignment(JLabel.CENTER);
				add(la);add(tf[i]);
			}
				setPreferredSize(new Dimension(230,300));
			
		}
	}
	
	class Buttons extends JPanel implements ActionListener{
		
		//필드 선언
		Vector<String> vector;
		JButton addBtn,updateBtn, deleteBtn;
		String juminNum;
		
		
		public Buttons(){
			setLayout(new GridLayout(1,3));
			addBtn=new JButton("추가");
			updateBtn=new JButton("수정");
			deleteBtn=new JButton("삭제");
			
			addBtn.setBackground(Color.gray);
			updateBtn.setBackground(Color.yellow);
			deleteBtn.setBackground(Color.green);
			
			add(addBtn);
			add(deleteBtn);
			add(updateBtn);
			
			//이벤트 연결
			addBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			deleteBtn.addActionListener(this);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("추가"))	AddData();
			else if(e.getActionCommand().equals("수정"))	UpdateData();
			if(e.getActionCommand().equals("삭제"))	DeleteData();
			

		
		}
		
		public void AddData(){
			Vector<String> vector = new Vector<String>();
			vector.add(west.tf[0].getText());//이름
			vector.add(west.tf[1].getText());//핸드폰번호
			
			//주민번호 체크하기 정상인지 아닌지
			juminNum = west.tf[2].getText();
			
			
			
			vector.add(west.tf[2].getText());//주민번호
			
			
		}
		public void UpdateData(){
			
			
			
		}
		public void DeleteData(){
	
	
	
}
		
		
		

	}
	
	class ShowTable extends MouseAdapter{
		
		DefaultTableModel datamodel;
		JTable table;
		JScrollPane scrollpane;
		
		String colName[]={"이름","핸드폰번호","주민번호"};
		
		Vector<Vector<String>> data;
		Vector<String> column_name;
		
		public ShowTable(){
			
			
			data = new Vector<Vector<String>>();
			column_name= new Vector<String>();
			
			for(int i=0;i<colName.length;i++)
			{
				column_name.add(colName[i]);
			}
			//중요!! JTable 데이터를 삽입, 수정, 삭제 하려면 반드시 3단계를거쳐야 한다 아까는 2단계만!!!!!
			datamodel=new DefaultTableModel(data, column_name);
			table = new JTable(datamodel);
			scrollpane = new JScrollPane(table);
			
			table.addMouseListener(this);
			TableSize();//사용자 정의 메소드
			
			//이벤트 연결

		}
		public void TableSize(){
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(70);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
							
		}
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {
	
				new JTableApp();
		

	}

}

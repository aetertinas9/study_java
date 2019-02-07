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
	//�ܺ� Ŭ����
	
	//�������� ����Ŭ���� ��ü �̸� ����
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	
	int updateRow;//���߿� ���� ���� ����
	
	
	
	

	//������ ����->�ܺ� Ŭ����
	
	public JTableApp(){
		
		setTitle("JTable (����,�߰�,����,����)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		add(menuMain.bar, BorderLayout.NORTH);
		add(west,BorderLayout.WEST);
		add(buttons, BorderLayout.SOUTH);
		add(showTable.scrollpane,BorderLayout.CENTER);
		
		
		setSize(600,300);
		setLocation(700,200);
		setVisible(true);
		
		
	}
	
	//MenuMain ���� Ŭ���� ����
	class MenuMain extends JPanel implements ActionListener, ItemListener
	{
	
		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fopen, fsave, fexit, proInfo;
		JCheckBoxMenuItem sname; //�̸������� ����
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, saveFileName, readFileName;
		
		
		//������ �����ϱ�
		public MenuMain(){
			
			bar=new JMenuBar();
			file = new JMenu("����");
			sort = new JMenu("����");
			help = new JMenu("����");
			
			fopen = new JMenuItem("����");
			fsave = new JMenuItem("����");
			fexit = new JMenuItem("�ݱ�");
			proInfo = new JMenuItem("���α׷� ����");
			
			sname = new JCheckBoxMenuItem("�̸�����");
			
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
			
			String text[]={"�̸�","�ڵ�����ȣ","�ֹι�ȣ"};
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
		
		//�ʵ� ����
		Vector<String> vector;
		JButton addBtn,updateBtn, deleteBtn;
		String juminNum;
		
		
		public Buttons(){
			setLayout(new GridLayout(1,3));
			addBtn=new JButton("�߰�");
			updateBtn=new JButton("����");
			deleteBtn=new JButton("����");
			
			addBtn.setBackground(Color.gray);
			updateBtn.setBackground(Color.yellow);
			deleteBtn.setBackground(Color.green);
			
			add(addBtn);
			add(deleteBtn);
			add(updateBtn);
			
			//�̺�Ʈ ����
			addBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			deleteBtn.addActionListener(this);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("�߰�"))	AddData();
			else if(e.getActionCommand().equals("����"))	UpdateData();
			if(e.getActionCommand().equals("����"))	DeleteData();
			

		
		}
		
		public void AddData(){
			Vector<String> vector = new Vector<String>();
			vector.add(west.tf[0].getText());//�̸�
			vector.add(west.tf[1].getText());//�ڵ�����ȣ
			
			//�ֹι�ȣ üũ�ϱ� �������� �ƴ���
			juminNum = west.tf[2].getText();
			
			
			
			vector.add(west.tf[2].getText());//�ֹι�ȣ
			
			
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
		
		String colName[]={"�̸�","�ڵ�����ȣ","�ֹι�ȣ"};
		
		Vector<Vector<String>> data;
		Vector<String> column_name;
		
		public ShowTable(){
			
			
			data = new Vector<Vector<String>>();
			column_name= new Vector<String>();
			
			for(int i=0;i<colName.length;i++)
			{
				column_name.add(colName[i]);
			}
			//�߿�!! JTable �����͸� ����, ����, ���� �Ϸ��� �ݵ�� 3�ܰ踦���ľ� �Ѵ� �Ʊ�� 2�ܰ踸!!!!!
			datamodel=new DefaultTableModel(data, column_name);
			table = new JTable(datamodel);
			scrollpane = new JScrollPane(table);
			
			table.addMouseListener(this);
			TableSize();//����� ���� �޼ҵ�
			
			//�̺�Ʈ ����

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

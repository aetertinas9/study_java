import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class JTableApp extends JFrame{ //�ܺ� Ŭ����
	
	//�߿�=>���� Ŭ���� ��ü ����==> �̸� �����ϸ� ���� Ŭ���� ����  ��ȣ�ۿ��� �����ϴ�.(����)
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	int updateRow;    //�������� ����
	
	// ������ ����
	public JTableApp(){ //�ܺ� Ŭ���� ��
		setTitle("JTable ����(�߰�, ����, ����)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(menuMain.bar, BorderLayout.NORTH); // menuMain��=>bar �ݵ�� �߰�
		add(west, BorderLayout.WEST);
		add(buttons, BorderLayout.SOUTH);
		add(showTable.scrollPane, BorderLayout.CENTER); // showTable��=>scrollPane // �ݵ�� �߰�
		
		setSize(600, 300);
		setLocation(700, 200);
		setVisible(true);
	}
	
	
	// MainMenu ����Ŭ���� ���� => �޴� �����   
	class MenuMain extends JPanel implements ActionListener, ItemListener{
		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fopen, fsave, fexit;
		JCheckBoxMenuItem sname;
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, savefileName, readfileName;
		
		//������ ����
		public MenuMain(){
			bar = new JMenuBar();
			file = new JMenu("����");
			sort = new JMenu("����");
			help = new JMenu("����");
			
			fopen = new JMenuItem("����");
			fsave = new JMenuItem("����");
			fexit = new JMenuItem("�ݱ�");
			
			sname = new JCheckBoxMenuItem("�̸�");
						
			file.add(fopen);   file.add(fsave); 
			file.addSeparator(); //���м� �ֱ�
			file.add(fexit);
			
			sort.add(sname);
			
			bar.add(file);
			bar.add(sort);
			bar.add(help);
			
			//�̺�Ʈ ����
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
			if(e.getActionCommand().equals("����")) save();  //����� ���� �޼ҵ�
			else if(e.getActionCommand().equals("����")) open();  //����� ���� �޼ҵ�
			else if(e.getActionCommand().equals("�ݱ�")) exit();  //����� ���� �޼ҵ�
			
		}
		public void save(){
			saveOpen = new FileDialog(JTableApp.this, "�����ۼ�", FileDialog.SAVE);
			saveOpen.setVisible(true);
			
			fileDir = saveOpen.getDirectory();
			fileName = saveOpen.getFile();
			savefileName = fileDir + "\\" + fileName;
			
			String str = "";
			String temp = "";
			
			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(savefileName));
				
				for(int i=0; i<showTable.table.getRowCount(); i++){ // showTable.table.getRowCount() �����ͰǼ�
					temp = showTable.data.elementAt(i).toString();
					str = str + temp.substring(1,temp.length()-1) + "\n";//[������, �ڼ�ȣ]
				}
				save.write(str);
				save.close();
			} catch(Exception ex){
				System.out.println(ex);
			}
		}// end save()
		public void open(){
			StringTokenizer st;
			Vector<String> vec;
			
			readOpen = new FileDialog(JTableApp.this, "��������", FileDialog.LOAD);
			readOpen.setVisible(true);
			
			fileDir = readOpen.getDirectory();
			fileName = readOpen.getFile();
			readfileName = fileDir + "\\" + fileName;
			
			try {
				BufferedReader read = new BufferedReader(new FileReader(readfileName));
				String line = null;
				while((line = read.readLine()) != null){
					st = new StringTokenizer(line, ", ");
					vec = new Vector<String>();
					
					while(st.hasMoreTokens()){
						vec.add(st.nextToken());
						
					}
					showTable.data.addElement(vec);
					
				}
				//Collection
				showTable.datamodel.fireTableDataChanged();
			}catch(Exception ex){
				System.out.println(ex);
			}
		}//end open
		public void exit(){ //�ݱ�
			System.exit(0);
		}
	} 
	
	
	
	// West ����Ŭ���� ���� ==> ������ �Է¹ޱ� ���� 
	class West extends JPanel{
		//�׸��� ���̾ƿ� 3�� 2��
		//�ʵ弱�� 
		JLabel la;
		JTextField tf[];
		
		//������  ����
		public West(){
			setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2),"�Է�"));
			
			String text[] = {"�̸�","�ڵ�����ȣ","�ֹι�ȣ"};
			tf = new JTextField[3];
			setLayout(new GridLayout(3,2,5,10));
			
			for(int i=0; i< text.length; i++){
				la = new JLabel(text[i]);
				tf[i] = new JTextField(20);
				la.setHorizontalAlignment(JLabel.CENTER);
				add(la); add(tf[i]);
			}
			setPreferredSize(new Dimension(230, 300));
			
		}
	}
	
	
	// Buttons ���� Ŭ���� ���� ==> ��ư �����
	class Buttons extends JPanel implements ActionListener {
		//�ʵ� ����
		Vector<String> vector;
		JButton addBtn, updateBtn, delBtn;
		String juminNo;
		
		
		//������  ����
		public Buttons(){
			setLayout(new GridLayout(1,3));
			
			addBtn = new JButton("�߰�");
			updateBtn = new JButton("����");
			delBtn = new JButton("����");
			
			addBtn.setBackground(Color.GREEN);
			updateBtn.setBackground(Color.YELLOW);
			delBtn.setBackground(Color.CYAN);
			
			add(addBtn); add(updateBtn); add(delBtn);
			//�̺�Ʈ ����
			addBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			delBtn.addActionListener(this);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("�߰�")) AddData();  //����� ���� �޼ҵ�
			else if(e.getActionCommand().equals("����")) UpdateData();  //����� ���� �޼ҵ�
			else if(e.getActionCommand().equals("����")) DelData();  //����� ���� �޼ҵ�
		}
		
		public void AddData(){
			Vector<String> vector = new Vector<String>(); //�⺻ 10��
			vector.add(west.tf[0].getText()); //�̸�
			vector.add(west.tf[1].getText()); //�ڵ�����ȣ
			
			// ���� �������� üũ�� �� ���Ϳ� �����ؾ���!
			juminNo = west.tf[2].getText(); //�ֹι�ȣ
			// ���� ǥ����(regular expression : regex) ����
			String regex = "[0-9]{6}-[0-9]{7}";
			boolean check = Pattern.matches(regex, juminNo); //Ŭ���� �̸��� �ٷ������ϴ� �޼ҵ�� ���� �żҵ� �����Ϳ� ����
			if(check ==false){
				JOptionPane.showMessageDialog(null, 
						"�ֹι�ȣ�� ����ǥ���Ŀ� ���� ����", "���޽���", JOptionPane.ERROR_MESSAGE);
				west.tf[2].setText(null); //��������
				west.tf[2].requestFocus();
				return;
			}
			//����ǥ���Ŀ� ����!
			int sum = 0;
			int weight[] = {2,3,4,5,6,7,0,8,9,2,3,4,5};
			for(int i=0; i<13; i++){
				if(juminNo.charAt(i) == '-') continue;
					sum = sum + (juminNo.charAt(i)-48) * weight[i];
			}
			int temp = 11 - (sum % 11);
			int result = temp %10;
			
			if(result == juminNo.charAt(13) - 48){
				JOptionPane.showMessageDialog(null, 
						"�ֹι�ȣ �����Դϴ�.");  //!
			}
			else {
				JOptionPane.showMessageDialog(null, 
						"�ֹι�ȣ�� �������� ����!", "���޽���", JOptionPane.ERROR_MESSAGE);   // x ǥ��
				return;
			}
			//�ֹι�ȣ �����̹Ƿ� ���Ϳ� ��������!
			vector.add(west.tf[2].getText()); //�ֹι�ȣ üũ������ �־����.
			west.tf[0].setText(null);
			west.tf[1].setText(null);
			west.tf[2].setText(null);
			west.tf[0].requestFocus(); 
			
			//[�߿�] ==>���Ϳ� ����� ���� <Vector<String>>  data�� ����
			showTable.data.addElement(vector);
			
			showTable.datamodel.fireTableDataChanged(); // data table �� ����Ȱ��� �뺸!
		}
		public void UpdateData(){
			updateRow = showTable.table.getSelectedRow();
			showTable.table.setValueAt(west.tf[0].getText(), updateRow, 0);//
			showTable.table.setValueAt(west.tf[1].getText(), updateRow, 1);
			showTable.table.setValueAt(west.tf[2].getText(), updateRow, 2);//
			
			west.tf[0].setText(null);
			west.tf[1].setText(null);
			west.tf[2].setText(null);
			west.tf[0].requestFocus(); 
		}
		public void DelData(){
			int yes_no_selected = JOptionPane.showConfirmDialog(null, 
					"���� �����Ͻðڽ��ϱ�?","���� Ȯ��â", JOptionPane.YES_NO_OPTION);
			if(yes_no_selected == JOptionPane.YES_OPTION ){
				JTable tb = showTable.table;
				int deleteRow = tb.getSelectedRow(); //���þ��ϸ� -1
				if( deleteRow == -1) 
					return;
				else {
					DefaultTableModel model = (DefaultTableModel) tb.getModel();
					model.removeRow(deleteRow);
					
					west.tf[0].setText(null);
					west.tf[1].setText(null);
					west.tf[2].setText(null);
					west.tf[0].requestFocus(); 
				}
				
				
			}
		}
		
	}
	
	// ShowTable ����Ŭ���� ���� ==> Vector�� ����Ǿ� �ִ°�ü�� JTable�� �����ֱ� 
	//class ShowTable extends JPanel implements MouseListener{ // MouseListener �߻�޼ҵ� 5���� 1���� �ʿ� MouseAdapter
		class ShowTable  extends MouseAdapter{ // MouseListener 5���߻�޼ҵ� 5���� ��� ����
		//�ʵ� ����
		DefaultTableModel datamodel;  //���̺� �߰����� ������ �� �� �ʿ��Ѱ�!!
		JTable table;
		JScrollPane scrollPane;
		
		String colName[] = {"�̸�","�ڵ�����ȣ","�ֹι�ȣ"};
		
		//�߿�
		Vector<Vector<String>> data;
		Vector<String> column_name;
		
		
		
		//������ ����
		public ShowTable(){
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0; i<colName.length; i++){
				column_name.add(colName[i]);
			}
			datamodel = new DefaultTableModel(data, column_name); //1�ܰ�
			table = new JTable(datamodel);						  //2�ܰ�
			scrollPane = new JScrollPane(table);				  //3�ܰ�
			
			//�̺�Ʈ ����
			table.addMouseListener(this);
			
		}
		//�������� �������̵� m ctrol+space_bar 
		@Override
		public void mouseClicked(MouseEvent e) {

			updateRow = table.getSelectedRow();
			west.tf[0].setText((String) showTable.table.getValueAt(updateRow,0)); //JTable�� �ִ� ���� get���־����.
			west.tf[1].setText((String) showTable.table.getValueAt(updateRow,1));
			west.tf[2].setText((String) showTable.table.getValueAt(updateRow,2));	
		}
		
	}
	public static void main(String[] args) {
		new JTableApp();

	}

}

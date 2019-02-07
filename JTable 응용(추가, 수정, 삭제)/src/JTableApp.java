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


public class JTableApp extends JFrame{ //외부 클래스
	
	//중요=>내부 클래스 객체 생성==> 미리 생성하면 내부 클래스 간에  상호작용이 가능하다.(전역)
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	int updateRow;    //전역변수 선언
	
	// 생성자 구현
	public JTableApp(){ //외부 클래스 것
		setTitle("JTable 응용(추가, 수정, 삭제)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(menuMain.bar, BorderLayout.NORTH); // menuMain은=>bar 반드시 추가
		add(west, BorderLayout.WEST);
		add(buttons, BorderLayout.SOUTH);
		add(showTable.scrollPane, BorderLayout.CENTER); // showTable은=>scrollPane // 반드시 추가
		
		setSize(600, 300);
		setLocation(700, 200);
		setVisible(true);
	}
	
	
	// MainMenu 내부클래스 구현 => 메뉴 만들기   
	class MenuMain extends JPanel implements ActionListener, ItemListener{
		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fopen, fsave, fexit;
		JCheckBoxMenuItem sname;
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, savefileName, readfileName;
		
		//생성자 구현
		public MenuMain(){
			bar = new JMenuBar();
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			fopen = new JMenuItem("열기");
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			
			sname = new JCheckBoxMenuItem("이름");
						
			file.add(fopen);   file.add(fsave); 
			file.addSeparator(); //구분선 넣기
			file.add(fexit);
			
			sort.add(sname);
			
			bar.add(file);
			bar.add(sort);
			bar.add(help);
			
			//이벤트 연결
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
			if(e.getActionCommand().equals("저장")) save();  //사용자 정의 메소드
			else if(e.getActionCommand().equals("열기")) open();  //사용자 정의 메소드
			else if(e.getActionCommand().equals("닫기")) exit();  //사용자 정의 메소드
			
		}
		public void save(){
			saveOpen = new FileDialog(JTableApp.this, "문서작성", FileDialog.SAVE);
			saveOpen.setVisible(true);
			
			fileDir = saveOpen.getDirectory();
			fileName = saveOpen.getFile();
			savefileName = fileDir + "\\" + fileName;
			
			String str = "";
			String temp = "";
			
			try {
				BufferedWriter save = new BufferedWriter(new FileWriter(savefileName));
				
				for(int i=0; i<showTable.table.getRowCount(); i++){ // showTable.table.getRowCount() 데이터건수
					temp = showTable.data.elementAt(i).toString();
					str = str + temp.substring(1,temp.length()-1) + "\n";//[김진명, 박세호]
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
			
			readOpen = new FileDialog(JTableApp.this, "문서열기", FileDialog.LOAD);
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
		public void exit(){ //닫기
			System.exit(0);
		}
	} 
	
	
	
	// West 내부클래스 구현 ==> 데이터 입력받기 위한 
	class West extends JPanel{
		//그리드 레이아웃 3행 2열
		//필드선언 
		JLabel la;
		JTextField tf[];
		
		//생성자  구현
		public West(){
			setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2),"입력"));
			
			String text[] = {"이름","핸드폰번호","주민번호"};
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
	
	
	// Buttons 내부 클래스 구현 ==> 버튼 만들기
	class Buttons extends JPanel implements ActionListener {
		//필드 선언
		Vector<String> vector;
		JButton addBtn, updateBtn, delBtn;
		String juminNo;
		
		
		//생성자  구현
		public Buttons(){
			setLayout(new GridLayout(1,3));
			
			addBtn = new JButton("추가");
			updateBtn = new JButton("수정");
			delBtn = new JButton("삭제");
			
			addBtn.setBackground(Color.GREEN);
			updateBtn.setBackground(Color.YELLOW);
			delBtn.setBackground(Color.CYAN);
			
			add(addBtn); add(updateBtn); add(delBtn);
			//이벤트 연결
			addBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			delBtn.addActionListener(this);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("추가")) AddData();  //사용자 정의 메소드
			else if(e.getActionCommand().equals("수정")) UpdateData();  //사용자 정의 메소드
			else if(e.getActionCommand().equals("삭제")) DelData();  //사용자 정의 메소드
		}
		
		public void AddData(){
			Vector<String> vector = new Vector<String>(); //기본 10개
			vector.add(west.tf[0].getText()); //이름
			vector.add(west.tf[1].getText()); //핸드폰번호
			
			// 먼저 정상인지 체크한 후 벡터에 저장해야함!
			juminNo = west.tf[2].getText(); //주민번호
			// 정규 표현식(regular expression : regex) 적용
			String regex = "[0-9]{6}-[0-9]{7}";
			boolean check = Pattern.matches(regex, juminNo); //클래스 이름을 바로접근하는 메소드는 정적 매소드 빅데이터에 적용
			if(check ==false){
				JOptionPane.showMessageDialog(null, 
						"주민번호가 정규표현식에 맞지 않음", "경고메시지", JOptionPane.ERROR_MESSAGE);
				west.tf[2].setText(null); //내용지움
				west.tf[2].requestFocus();
				return;
			}
			//정규표현식에 맞음!
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
						"주민번호 정상입니다.");  //!
			}
			else {
				JOptionPane.showMessageDialog(null, 
						"주민번호가 정상이지 않음!", "경고메시지", JOptionPane.ERROR_MESSAGE);   // x 표시
				return;
			}
			//주민번호 정상이므로 벡터에 저장하자!
			vector.add(west.tf[2].getText()); //주민번호 체크했으니 넣어야함.
			west.tf[0].setText(null);
			west.tf[1].setText(null);
			west.tf[2].setText(null);
			west.tf[0].requestFocus(); 
			
			//[중요] ==>벡터에 저장된 값을 <Vector<String>>  data에 저장
			showTable.data.addElement(vector);
			
			showTable.datamodel.fireTableDataChanged(); // data table 이 변경된것을 통보!
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
					"정말 삭제하시겠습니까?","삭제 확인창", JOptionPane.YES_NO_OPTION);
			if(yes_no_selected == JOptionPane.YES_OPTION ){
				JTable tb = showTable.table;
				int deleteRow = tb.getSelectedRow(); //선택안하면 -1
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
	
	// ShowTable 내부클래스 구현 ==> Vector에 저장되어 있는개체를 JTable에 보여주기 
	//class ShowTable extends JPanel implements MouseListener{ // MouseListener 추상메소드 5개중 1개만 필요 MouseAdapter
		class ShowTable  extends MouseAdapter{ // MouseListener 5개추상메소드 5개를 모두 포함
		//필드 선언
		DefaultTableModel datamodel;  //테이블에 추가삭제 수정할 때 꼭 필요한것!!
		JTable table;
		JScrollPane scrollPane;
		
		String colName[] = {"이름","핸드폰번호","주민번호"};
		
		//중요
		Vector<Vector<String>> data;
		Vector<String> column_name;
		
		
		
		//생성자 구현
		public ShowTable(){
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0; i<colName.length; i++){
				column_name.add(colName[i]);
			}
			datamodel = new DefaultTableModel(data, column_name); //1단계
			table = new JTable(datamodel);						  //2단계
			scrollPane = new JScrollPane(table);				  //3단계
			
			//이벤트 연결
			table.addMouseListener(this);
			
		}
		//수동으로 오버라이드 m ctrol+space_bar 
		@Override
		public void mouseClicked(MouseEvent e) {

			updateRow = table.getSelectedRow();
			west.tf[0].setText((String) showTable.table.getValueAt(updateRow,0)); //JTable에 있는 것은 get해주어야함.
			west.tf[1].setText((String) showTable.table.getValueAt(updateRow,1));
			west.tf[2].setText((String) showTable.table.getValueAt(updateRow,2));	
		}
		
	}
	public static void main(String[] args) {
		new JTableApp();

	}

}

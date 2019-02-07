import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class JTableTest extends JFrame{

	String tiltle[]={"번호","이름","연락처","이메일"};
	String data[][]={{"1","박찬호","010-123-1234","park123@naver.com"},
					 {"2","김연아","010-234-2345","Kim123@naver.com"},
					 {"3","이외수","010-345-3456","Lee123@naver.com"}};
	
				 
	JTable table;
	JScrollPane scroll;
	
	public JTableTest(){
		setTitle("JTable 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable(data, tiltle);
		scroll = new JScrollPane(table);
		//셀크기 조정!!
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		//추가+ 셀의 데이터값이 중앙정렬 시키기
		DefaultTableCellRenderer tablecall = new DefaultTableCellRenderer();
		tablecall.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel callModel = table.getColumnModel();
		for(int i=0;i<callModel.getColumnCount();i++)
		{
			callModel.getColumn(i).setCellRenderer(tablecall);
		}
		
		
		add(scroll);
		
		setSize(450,200);
		setLocation(700,150);
		setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		new JTableTest();
		
		
	}

}

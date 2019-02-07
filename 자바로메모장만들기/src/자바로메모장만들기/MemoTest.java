package 자바로메모장만들기;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.attribute.standard.Fidelity;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MemoTest extends JFrame implements ActionListener {

	
	JFrame main_fr = new JFrame("메모장 만들기");
	FileDialog readopen;
	FileDialog saveopen;
	JTextArea area;
	
	public MemoTest()
	{
		JMenuBar main_bar = new JMenuBar();
		JMenu main_file = new JMenu("파일");
		JMenuItem file_load = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		area=new JTextArea();
		
		main_file.add(file_load);
		main_file.add(file_save);
		main_bar.add(main_file);
		main_fr.setJMenuBar(main_bar);
		main_fr.add(area);
		
		
		//이벤트 연결 -> 리스너!!
		file_load.addActionListener(this);
		file_save.addActionListener(this);
		
		main_fr.setBounds(700,150,300,300);		//setsize, setlocation 한번에 하기
		main_fr.setVisible(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//->형태!!	
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String itemPressed = e. getActionCommand();	//위의 열기저장창 얻어오는 메소드 열기누르면 열기를 얻어오고 저장 누르면 저장 얻어옴
		
		if(itemPressed.equals("저장"))
		{
			String name = saveName();	//사용자 정의 메소드
			
			//예외처리!!!!
			try
			{
				save(name);
			}
			catch(Exception a)
			{
				System.out.println("예외가 발생하였습니다");
			}
			
			
		}
		else if(itemPressed.equals("열기"))
		{
			String name = readName();	//사용자 정의 메소드
			try
			{
				read(name);
			}
			catch(Exception a)
			{
				System.out.println("예외가 발생하였습니다");
			}
			
		}	
				
			
	}
	public void save(String savefile) throws IOException	//꼭 throws 붙여줘야 한다!!!!!!!
	{
		BufferedWriter save = new BufferedWriter(new FileWriter(savefile));
		String line = area.getText();
		save.write(line);
		save.close();
	}
	public void read(String readfile) throws IOException	//꼭 throws 붙여줘야 한다!!!!!!!
	{
		BufferedReader read = new BufferedReader(new FileReader(readfile));
		String line = read.readLine();
		
		while(line!=null)
		{
			area.append(line+"\n");
			line = read.readLine();
		}
		
		read.close();
	}

	//사용자 정의 메소드 구현
	public String saveName()
	{
		saveopen = new FileDialog(main_fr, "문서저장", FileDialog.SAVE);
		saveopen.setVisible(true);
		String fileDir = saveopen.getDirectory();
		String filename = saveopen.getFile();
		String savefilename = fileDir +"\\"+filename;
		return savefilename;
	}
	public String readName()
	{
		readopen = new FileDialog(main_fr, "문서열기", FileDialog.LOAD);
		readopen.setVisible(true);
		String fileDir = readopen.getDirectory();
		String filename = readopen.getFile();
		String readfilename = fileDir +"\\"+filename;
		return readfilename;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MemoTest();
		

	}


}

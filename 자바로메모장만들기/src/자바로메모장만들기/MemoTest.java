package �ڹٷθ޸��常���;

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

	
	JFrame main_fr = new JFrame("�޸��� �����");
	FileDialog readopen;
	FileDialog saveopen;
	JTextArea area;
	
	public MemoTest()
	{
		JMenuBar main_bar = new JMenuBar();
		JMenu main_file = new JMenu("����");
		JMenuItem file_load = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		area=new JTextArea();
		
		main_file.add(file_load);
		main_file.add(file_save);
		main_bar.add(main_file);
		main_fr.setJMenuBar(main_bar);
		main_fr.add(area);
		
		
		//�̺�Ʈ ���� -> ������!!
		file_load.addActionListener(this);
		file_save.addActionListener(this);
		
		main_fr.setBounds(700,150,300,300);		//setsize, setlocation �ѹ��� �ϱ�
		main_fr.setVisible(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//->����!!	
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String itemPressed = e. getActionCommand();	//���� ��������â ������ �޼ҵ� ���⴩���� ���⸦ ������ ���� ������ ���� ����
		
		if(itemPressed.equals("����"))
		{
			String name = saveName();	//����� ���� �޼ҵ�
			
			//����ó��!!!!
			try
			{
				save(name);
			}
			catch(Exception a)
			{
				System.out.println("���ܰ� �߻��Ͽ����ϴ�");
			}
			
			
		}
		else if(itemPressed.equals("����"))
		{
			String name = readName();	//����� ���� �޼ҵ�
			try
			{
				read(name);
			}
			catch(Exception a)
			{
				System.out.println("���ܰ� �߻��Ͽ����ϴ�");
			}
			
		}	
				
			
	}
	public void save(String savefile) throws IOException	//�� throws �ٿ���� �Ѵ�!!!!!!!
	{
		BufferedWriter save = new BufferedWriter(new FileWriter(savefile));
		String line = area.getText();
		save.write(line);
		save.close();
	}
	public void read(String readfile) throws IOException	//�� throws �ٿ���� �Ѵ�!!!!!!!
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

	//����� ���� �޼ҵ� ����
	public String saveName()
	{
		saveopen = new FileDialog(main_fr, "��������", FileDialog.SAVE);
		saveopen.setVisible(true);
		String fileDir = saveopen.getDirectory();
		String filename = saveopen.getFile();
		String savefilename = fileDir +"\\"+filename;
		return savefilename;
	}
	public String readName()
	{
		readopen = new FileDialog(main_fr, "��������", FileDialog.LOAD);
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

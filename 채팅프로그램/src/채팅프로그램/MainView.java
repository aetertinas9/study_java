package chat;


import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainView extends JFrame{
	//�ʵ� ����
	private JPanel contentPane;
	private JTextField textField;
	private String id;
	private String ip;
	private int port;
	
	JButton sendBtn;
	JTextArea textArea;
	
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	 
	//������ ����
	public MainView(String id, String ip, int port){
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		init();
		start();
		
		textArea.append("�Ű������� �Ѿ�� ��: "+id+" "+ip+" "+port+"\n");
		network();
		
		
	}
	public void network(){
		//������ �����ϴ� �޼ҵ�
		
		try{
			socket = new Socket(ip,port);
			
			if(socket!=null){
				Connection();
			}
		}catch(UnknownHostException e){
			Connection();
			
		}catch(IOException er){
			Connection();
			textArea.append("���� ���� ����!!\n");
		}
		
		
	}
	//
	
public void Connection(){
		
		try{
			is = socket.getInputStream();
			dis = new DataInputStream(is);//������Ʈ�� ��ü ����
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		}catch(IOException e){
			textArea.append("��Ʈ��ũ ���� ����!!\n");
			
		}
		send_Message(id);
	}

private void send_Message(String id2) {
	textArea.append("1");
}

Thread th= new Thread(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try{
				String msg= dis.readUTF();
			}
			catch(IOException e){
				textArea.append("�޽��� ���� ����!!");
			try{
				os.close();
				is.close();
				dos.close();
				dis.close();
				socket.close();
				break;
			}catch(IOException er){
				
			}
			
			
			}
		}
		
		
	}
});




	public void init(){
		setTitle("ä�� - Ŭ���̾�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,288,392);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0,0,272,302);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(0,312,155,42);
		textField.setColumns(10);
		contentPane.add(textField);
		
		sendBtn = new JButton("��  ��");
		sendBtn.setBackground(Color.CYAN);
		sendBtn.setBounds(161,312,111,42);
		contentPane.add(sendBtn);
		
		textArea.setEditable(false);
		setVisible(true);
		
	}
	public void start(){
		sendBtn.addActionListener(new Myaction());
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					send_Message(textField.getText());
					textField.setText("");
					textField.requestFocus();
				}
				
			}
		});
	}
	class Myaction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == sendBtn){
				send_Message(textField.getText());
				textField.setText("");
				textField.requestFocus();
			}
			
		}}}


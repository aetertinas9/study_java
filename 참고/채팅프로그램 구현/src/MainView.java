import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainView extends JFrame{
	//필드 선언
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
	 
	//생성자 구현
	public MainView(String id, String ip, int port){
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		init();
		start();
		
		textArea.append("매개변수로 넘어온 값: "+id+" "+ip+" "+port+"\n");
		network();
		
	}
	public void init(){
		setTitle("채팅 - 클라이언트");
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
		
		sendBtn = new JButton("전  송");
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
	class Myaction implements ActionListener

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == sendBtn){
				send_Message(textField.getText());
				textField.setText("");
				textField.requestFocus();
			}
			
		}

}

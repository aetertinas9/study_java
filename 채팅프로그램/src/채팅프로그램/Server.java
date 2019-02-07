package chat;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server extends JFrame{
	//�ʵ� ����
	private JPanel contentPane;
	private JTextField textField;
	private JButton start;
	JTextArea textArea;
	
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	
	//�����尣�� ������ ������ ����
	private Vector vector = new Vector();
	
	//������ ����
	public Server(){
		init();
	}
	private void init(){
		setTitle("ä�� ���α׷� - ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,280,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0,0,264,254);
		contentPane.add(js);
		
		textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setRows(5);
		js.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(98,264,154,37);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Port Number");
		lblNewLabel.setBounds(12,264,98,37);
		contentPane.add(lblNewLabel);
		
		start = new JButton("���� ����");
		start.setBackground(Color.PINK);
		
		//�̺�Ʈ ���� �� �ڵ鷯 ó���� ���ÿ� ...
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField.getText().length() == 0){
					JOptionPane.showMessageDialog(null,
							"��Ʈ��ȣ�� �Է����ּ���.","���޽���",JOptionPane.ERROR_MESSAGE);
					textField.requestFocus();
					return;
				}else{
					try{
						port = Integer.parseInt(textField.getText());
						server_start(port); //����� ���� �޼ҵ� ȣ��
					}catch(Exception er){
						System.out.println(er);
					}
				}
				
			}
		});
			
			
		
		start.setBounds(0,325,264,37);
		contentPane.add(start);
		textArea.setEditable(false);
	}
	private void server_start(int port){
		try{
		serverSocket = new ServerSocket(port);
		start.setText("����������");
		start.setEnabled(false); //��ư�� ��Ȱ��ȭ
		textField.setEditable(false);
		
		if(serverSocket != null){
			Connection(); //����� ���� �޼ҵ�
			}
		}catch(IOException e){
			textArea.append("�������� ���� ����!!!\n");
		}
	}
	private void Connection(){
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() {
				// ������ ���� �ڵ� �ۼ�
				while(true){
					try{
						textArea.append("����� ���� �����...\n");
						socket = serverSocket.accept();
						textArea.append("����� ����!!\n");
						
						UserInfo user = new UserInfo(socket,vector);
						vector.add(user);
						user.start();
					}catch(IOException ex){
						textArea.append("accept ���� �߻�!!!\n");
					}
				}
			}
			
		});
		th.start();
	}
	//������ ��� �����ϸ鼭 ������ �ۼ��� �ϱ� ���ؼ� ������ �ڵ鷯 ��ü ����
	class UserInfo extends Thread{
		//�ʵ� ����
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private Socket user_socket;
		private Vector user_vector;
		private String Nickname = "";
		
		//������ ����
		public UserInfo(Socket socket,Vector vector){
			this.user_socket = socket;
			this.user_vector = vector;
			
			User_network();	//����� ���� �޼ҵ� ȣ��
		}
		public void User_network(){
			try{
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				Nickname = dis.readUTF();//Ŭ���̾�Ʈ���� ���� ���ڿ��� �о� �´�.
				textArea.append("������ ID "+Nickname+"\n");
				
				//send_Message("���� ���� �Ǿ����ϴ�."); //����� ���� �޼ҵ� ȣ��
			}catch(Exception e){
				textArea.append("IO ��Ʈ�� ���� ���� �߻�\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Server frame = new Server();
		frame.setVisible(true);

	}

}

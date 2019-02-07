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
	//필드 선언
	private JPanel contentPane;
	private JTextField textField;
	private JButton start;
	JTextArea textArea;
	
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	
	//스레드간의 정보를 공유할 벡터
	private Vector<String> vector = new Vector<String>();
	
	//생성자 구현
	public Server(){
		init();
	}
	private void init(){
		setTitle("채팅 프로그램 - 서버");
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
		
		start = new JButton("서버 실행");
		start.setBackground(Color.PINK);
		
		//이벤트 연결 및 핸들러 처리를 동시에 ...
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField.getText().length() == 0){
					JOptionPane.showMessageDialog(null,
							"포트번호를 입력해주세요.","경고메시지",JOptionPane.ERROR_MESSAGE);
					textField.requestFocus();
					return;
				}else{
					try{
						port = Integer.parseInt(textField.getText());
						server_start(port); //사용자 정의 메소드 호출
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
		start.setText("서버실행중");
		start.setEnabled(false); //버튼의 비활성화
		textField.setEditable(false);
		
		if(serverSocket != null){
			Connection(); //사용자 정의 메소드
			}
		}catch(IOException e){
			textArea.append("서버소켓 생성 실패!!!\n");
		}
	}
	private void Connection(){
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() {
				// 스레드 실행 코드 작성
				while(true){
					try{
						textArea.append("사용자 접속 대기중...\n");
						socket = serverSocket.accept();
						textArea.append("사용자 접속!!\n");
						
						UserInfo user = new UserInfo(socket,vector);
					}catch(IOException ex){
						textArea.append("accept 에러 발생!!!\n");
					}
				}
			}
			
		});
		th.start();
	}
	//접속을 계속 유지하면서 데이터 송수신 하기 위해서 스레드 핸들러 객체 생성
	class UserInfo extends Thread{
		//필드 선언
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private Socket user_socket;
		private Vector<String> user_vector;
		private String Nickname = "";
		
		//생성자 구현
		public UserInfo(Socket socket,Vector vector){
			this.user_socket = socket;
			this.user_vector = vector;
			
			User_network();	//사용자 정의 메소드 호출
		}
		public void User_network(){
			try{
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				Nickname = dis.readUTF();//클라이언트에서 보낸 문자열을 읽어 온다.
				textArea.append("접속자 ID "+Nickname+"\n");
				
				//send_Message("정상 접속 되었습니다."); //사용자 정의 메소드 호출
			}catch(Exception e){
				textArea.append("IO 스트림 셋팅 에러 발생\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Server frame = new Server();
		frame.setVisible(true);

	}

}

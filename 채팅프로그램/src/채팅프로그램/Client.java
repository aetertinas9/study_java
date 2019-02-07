package chat;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Client extends JFrame{
	//�ʵ� ����
	private JPanel contentPane;
	private JTextField tf_ID;
	private JTextField tf_IP;
	private JTextField tf_PORT;
	
	//������ ����
	public Client(){
		init();
	}
	public void init(){
		setTitle("ä�� - Ŭ���̾�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,288,392);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(53,57,90,34);
		contentPane.add(lblNewLabel);
		
		tf_ID = new JTextField();
		tf_ID.setBounds(92,64,150,21);
		tf_ID.setColumns(10);
		contentPane.add(tf_ID);
		
		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(12,111,90,34);
		contentPane.add(lblServerIp);
		
		tf_IP = new JTextField();
		tf_IP.setBounds(92,118,150,21);
		tf_IP.setColumns(10);
		contentPane.add(tf_IP);
		
		JLabel lblPort = new JLabel("PORT");
		lblPort.setBounds(36,178,90,34);
		contentPane.add(lblPort);
		
		tf_PORT = new JTextField();
		tf_PORT.setBounds(92,185,150,21);
		tf_PORT.setColumns(10);
		contentPane.add(tf_PORT);
		
		JButton btnNewButton = new JButton("��  ��");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(36,266,206,52);
		contentPane.add(btnNewButton);
		
		//��ư �̺�Ʈ ���� �� �ڵ鷯ó��
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_ID.getText().equals("") || tf_ID.getText().length() ==0){
					JOptionPane.showMessageDialog(null, "ID��  �Է��ϼ���","��� �޽���",JOptionPane.ERROR_MESSAGE);
					tf_ID.requestFocus();
					return;
				}
				if(tf_PORT.getText().equals("") || tf_PORT.getText().length() ==0){
					JOptionPane.showMessageDialog(null, "��Ʈ��ȣ��  �Է��ϼ���","��� �޽���",JOptionPane.ERROR_MESSAGE);
					tf_PORT.requestFocus();
					return;
				}else{
					try{
						String _id = tf_ID.getText().trim(); //������ ������ �߶󳻶�!
						String _ip = tf_IP.getText().trim();
						int _port = Integer.parseInt(tf_PORT.getText().trim());
						
						//MainView Ŭ���� ��ü ����
						MainView view = new MainView(_id,_ip,_port);
						setVisible(true);
					}catch(Exception er){
						System.out.println(er);
					}
				}
				
			}
		});
	}

}
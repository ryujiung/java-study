package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import chat02.ChatClientThread;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private String name;
	private BufferedReader br;
	private PrintWriter pw;
	private String message;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name =name;
		this.socket = socket;
				}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
//		buttonSend.addActionListener((ActionEvent actionEvent)->{
//			
//		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
				
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		try {
		//IOStream 받아오기 
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		// ChatClientThread 생성하고 실행 
		ChatClientThread chatClientThread = new ChatClientThread(socket);
        chatClientThread.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private void finish() {
		//quit 프로토콜 구현 
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
				System.out.println("채팅창 종료");
				System.exit(0);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		//exit java(jvm)
		System.exit(0);
	}
	private void sendMessage() {
        message = textField.getText();

        if ((message.trim()).isEmpty() == false) {

            if (message.equals("quit")) {
                finish();
            }
            pw.println("message:" + message);
            textField.setText("");
            textField.requestFocus();

            System.out.println(ChatClientApp.name + "이 보내는 메세지 : " + message);
        } else {
            updateTextArea("메세지는 한글자 이상 입력하셔야 합니다.");
        }
    }
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{
		private Socket socket;


		public ChatClientThread(Socket socket) {
			this.socket = socket;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				
				while(true) {
					String message = br.readLine();
					if(message == null) {
						break;
					}
					updateTextArea(message);
				}
			}catch(SocketException ex) {
				System.out.println("Error"+ex);
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				finish();
			}
		}
		
	}
}
package chat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String Server_Ip ="127.0.0.1";
	private static final int Port = 8887;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
			
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(Server_Ip, Port));
	        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	        System.out.print("닉네임>>");
	        String name = scanner.nextLine();
	        pw.println("Join:"+name);
	        String br1 = br.readLine();
	        if("Join:ok".equals(br1)) {
	        	System.out.println("입장하였습니다.");
	        }
	        ChatClientThread chatClientThread = new ChatClientThread(socket);
	        chatClientThread.start();
	        
	        while(true) {
	        	if(scanner.hasNextLine() == false) {
	        		continue;
	        	}
	        	String message = scanner.nextLine();
	        	if("quit".equals(message)) {
	        		pw.println("Quit");
	        		break;
	        	}
	        	if(" ".equals(message) == false) {
	        		pw.println("Message"+message);
	        	}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		

	}

}
	}

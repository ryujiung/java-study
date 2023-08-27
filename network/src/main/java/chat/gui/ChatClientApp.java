package chat.gui;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	
	public static final String Server_Ip ="127.0.0.1";
	public static final int Port = 8888;

	public static void main(String[] args) {
		
		
		String name = null;
		Socket socket = null;
		Scanner scanner = null;
		
		try {
		scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		
		//1.create socket
		socket = new Socket();
		//2.connect server
		socket.connect(new InetSocketAddress(Server_Ip,Port));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		//3.join protocol
        pw.println("Join"+name);
        String ack = br.readLine();
        if("Join:ok".equals(ack)) {
        	new ChatWindow(name,socket).show();
        }
        
	}catch(ConnectException e) {
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(scanner != null) {
			scanner.close();
		}
	}

	}

}
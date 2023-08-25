package chat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread{
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
				System.out.println(message);
			}
		}catch(SocketException ex) {
			System.out.println("Error"+ex);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
	


}

package chat.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 8888;
	public static void main(String[] args) {
		List<PrintWriter> listPrintWriter = new ArrayList<PrintWriter>();
		ServerSocket serversocket = null;
		
		try {
			serversocket = new ServerSocket();
			
			serversocket.setReuseAddress(true);
			
			String localhost = InetAddress.getLocalHost().getHostAddress();
			serversocket.bind(new InetSocketAddress("0.0.0.0", PORT),10);
			System.out.println("chatserver starts at"+PORT);
			
			while(true) {
				Socket socket = serversocket.accept();
				
				Thread thread = new ChatServerThread(socket,listPrintWriter);
				thread.start();
			}
						
		}catch(SocketException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("error"+e);
		}finally {
			if(serversocket != null && serversocket.isClosed() == false) {
				try {
					serversocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
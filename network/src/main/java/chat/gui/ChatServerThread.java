package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;


public class ChatServerThread extends Thread{
	private Socket socket;
	private String name;
	private List<PrintWriter> listPrintWriter;
	
	public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriter) {
		this.socket = socket;
		this.listPrintWriter = listPrintWriter;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
		InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
		
		while(true) {
			String line = br.readLine();
			String[] tokens =null;
			if(line !=null) {
				tokens = line.split(":");
			}else {
			doQuit(pw);
			System.out.println("closed by client");
			break;
			}		
			if("Join".equals(tokens[0])) {
				doJoin(tokens[1],pw);
			}else if("Message".equals(tokens[0])){
				doMessage(tokens[1]);
			}else if("quit".equals(tokens[0])) {
				doQuit(pw);
				break;
			}
			
		}
		}catch(SocketException e){
			doQuit(pw);
			System.out.println("abnormal finish");			
		}catch(IOException e) {
			doQuit(pw);
			System.out.println("error"+e);
		}finally{
			try {
			if(socket != null && socket.isClosed()==false) {
				socket.close();
			}
			}catch(IOException e) {
				System.out.println("error"+e);
			}
		}
	}

	private void doMessage(String message) {
		broadcastMessage(name + ":"+message);
		
	}

	private void broadcastMessage(String message) {
		synchronized(listPrintWriter) {
			for(PrintWriter printwriter: listPrintWriter) {
				printwriter.println(message);
			}
		}
		
	}

	private void doJoin(String name , PrintWriter pw) {
		this.name = name;
		String message = name + "님이 입장했습니다.";
		broadcastMessage(message);
		synchronized(listPrintWriter) {
		listPrintWriter.add(pw);}
		pw.println("Join:ok");
		
	}

	private void doQuit(PrintWriter pw) {
		synchronized(listPrintWriter) {
		listPrintWriter.remove(pw);}
		if(name != null) {
			broadcastMessage(name+"님이 퇴장했습니다. ");
		}
		
	}
	

}
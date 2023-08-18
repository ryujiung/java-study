package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	
	private static final int PORT = 8300;

	public static void main(String[] args) {
		ServerSocket serverSocket= null;
		try {
			//1.Server Socket
			serverSocket= new ServerSocket();
			//2.Binding
			//Socket에 InetSocketAddress(IPAddress+port)	를 바인딩한다.
			//IPAddress: 0.0.0.0:특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8300),10);
			log("starts...[port:" + PORT + "]");
			
			Socket socket = serverSocket.accept(); // blocking
			
			
		try {	
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			log("[server] connected bt client[" + remoteHostAddress+":"+remotePort);
			
			//4.IO Stream 받아오기
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os,"utf-8"),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			
			pw.print("안녕");
			
			while(true) {
				//5.데이터 읽기 
				String data = br.readLine();
				if(data == null) {
					log("closed by client");
					break;
				}
				
				log("received:"+data);
				pw.println(data);
				
			}
//			catch(SocketException e) {
//			log("[server] suddenly closed by client");
//		}
		}catch (IOException e) {
			System.out.println("[server] eerror: "+e);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			}catch(IOException e) {
				System.out.println("[server] eerror: "+e);
				
			}
		}
			
		} catch (IOException e) {
			System.out.println("[server] eerror: "+e);
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				};
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static void log(String message) {
		System.out.println("[EchoServer]" + message);
	}

}

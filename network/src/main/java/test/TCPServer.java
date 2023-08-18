package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket= null;
		try {
			//1.Server Socket
			serverSocket= new ServerSocket();
			
			//2.Binding
			//Socket에 InetSocketAddress(IPAddress+port)	를 바인딩한다.
			//IPAddress: 0.0.0.0:특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8300),10);
			
			//3.accept
			Socket socket = serverSocket.accept(); // blocking
			
			
		try {	
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server] connected bt client[" + remoteHostAddress+":"+remotePort);
			
			//4.IO Stream 받아오기
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			while(true) {
				//5.데이터 읽기 
				byte[] buffer = new byte[256];
				int readByteCount = is.read(buffer);	//blocking
				
				if(readByteCount == -1) {
					System.out.println("[server] closed by client");
					break;
					
				}
				
				String data = new String(buffer, 0, readByteCount,"utf-8");
				System.out.println("[server] received:"+data);
				
				//6. 데이터 쓰기
				os.write(data.getBytes("utf-8"));
			}
			
//		}catch(SocketException e) {
//			System.out.println("[server] suddenly closed by client");
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
			
			
			
			System.out.println("연결되었습니다.");
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

}

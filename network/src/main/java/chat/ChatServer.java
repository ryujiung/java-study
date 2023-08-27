package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args){
       try {
           ServerSocket serverSocket = new ServerSocket(9750);
           serverSocket.setReuseAddress(true);

           List<ChatServerThread> list = Collections.synchronizedList(new ArrayList<>());
           while (true) {
               Socket socket = serverSocket.accept();
               ChatServerThread chatClient = new ChatServerThread(socket, list);
               chatClient.start();
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}

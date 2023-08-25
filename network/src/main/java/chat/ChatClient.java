package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
    	
    	System.out.print("닉네임>>");
    	Scanner scanner = new Scanner(System.in);
    	String name = scanner.nextLine();
        Socket socket = new Socket("127.0.0.1",9850);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        pw.println(name);
        pw.flush();
       
        
        
        ChatClientThread chatClientThread = new ChatClientThread(br);
        chatClientThread.start();

        try {
            String line = null;
            while ((line = keyboard.readLine()) != null) {
                if ("quit".equals(line)) {
                    // 서버에게 메세지를 보낸다.
                    pw.println("quit");
                    pw.flush();
                    break; // while 문을 빠져나간다.
                }
                pw.println(line);
                pw.flush();
            }
        } catch (Exception ex) {
            System.out.println("....");
        }

        // close 작업을 해준다.
        try {
            br.close();
        } catch (Exception ex) {
        }

        try {
            pw.close();
        } catch (Exception ex) {
        }

        try {
            socket.close();
        } catch (Exception ex) {
        }

    }

    }




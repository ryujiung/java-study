package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServerThread extends Thread{
    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    List<ChatServerThread> list;

    public ChatServerThread(Socket socket, List<ChatServerThread> list)throws Exception{
        this.socket =socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
        this.br =br;
        this.pw = pw;
        this.name = br.readLine();
        this.list= list;
        this.list.add(this);
    }
    public void sendMessage(String msg){
    	
        pw.println(msg);
        pw.flush();
    }
    @Override
    public void run() {
        try {
            broadcast(name+"님이 연결되었습니다.", false);

            String line = null;

            while ((line = br.readLine()) != null) {
                if ("/quit".equals(line)) {
                    break;
                }
                broadcast(name +" : " + line, true);
            }
        } catch (Exception ex) { // ChatThread가 연결이 끊어 졌다.

        } finally {
            broadcast(name+"님이 연결이 끊어졌습니다.", false);
            this.list.remove(this);
            try {
                br.close();
            } catch (Exception ex) {}

            try {
                pw.close();
            } catch (Exception ex) {}

            try {
                socket.close();
            } catch (Exception ex) {}
        }
    }
    private void broadcast(String msg,boolean includeMe){
            List<ChatServerThread> chatThreads = Collections.synchronizedList(new ArrayList<>());
            for (int i = 0; i< this.list.size();i++){
                chatThreads.add(list.get(i));
            }

            try{
                for (int i = 0; i<chatThreads.size();i++){
                    ChatServerThread ct = chatThreads.get(i);
                    if (! includeMe){
                        if(ct == this){
                            continue;
                        }
                    }
                    ct.sendMessage(msg);
                }
            }catch(Exception ex){
                System.out.println("///");
            }

        }
    }





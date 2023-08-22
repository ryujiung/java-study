package chat;

import java.io.BufferedReader;
import java.io.IOException;

class ChatClientThread extends Thread{
   BufferedReader br;
   public ChatClientThread(BufferedReader br){
       this.br =br;
   }
   @Override
    public void run(){
       try{
           String line = null;
           while ((line = br.readLine())!= null){
               System.out.println(line);
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }finally {
           System.exit(0);
       }
   }
       }

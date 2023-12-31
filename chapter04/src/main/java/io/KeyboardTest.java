package io;

import java.io.*;

public class KeyboardTest {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = null;
		try {
			//1. 기반 스트림(표준입력,stdin,System.in)
			
			//2. 보조스트림1
			InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
			
			//3.보조스트림2
			br = new BufferedReader(isr);
			
			//4.처리
			String line = null;
			while((line = br.readLine()) !=null) {
				if("quit".equals(line)) {
					break;
				}
				
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error: "+e);
		}finally {
			try {
				if(br != null) {
				br.close();
				}
			}catch(IOException e) {
				System.out.println("Error: "+e);
			}
		}
	

	}

}

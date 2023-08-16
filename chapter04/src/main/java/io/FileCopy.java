package io;

import java.io.*;
import java.util.*;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		InputStream is = null;
		OutputStream os = null;
		
		try{
			is = new FileInputStream("loopy.jpeg");
			os = new FileOutputStream("loopy.copy.jpeg");
			
			int data = -1;
			while((data = is.read()) != -1) {
				os.write(data);
				data = is.read();
			}
			
			}catch(FileNotFoundException e) {
				System.out.println("file not foud: "+e);
			}finally {
				try {
					if(is != null) {
						is.close();
					}
					if(os != null) {
						os.close();
						}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				}
			}

	}



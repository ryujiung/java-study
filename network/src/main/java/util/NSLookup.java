package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String line = scanner.nextLine();
			try {
				InetAddress[] Ipaddresses = InetAddress.getAllByName(line);
				
				for(InetAddress Ipaddress : Ipaddresses) {
					System.out.println(line+": "+Ipaddress.getHostAddress());
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			if("quit".equals(line)) {
				break;
			}
			
			
		}

	}

}

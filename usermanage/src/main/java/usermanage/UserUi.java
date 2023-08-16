package usermanage;

import java.io.*;
import java.util.*;

public class UserUi {
	private BufferedReader br;
	
	public UserUi() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public int menu() {
		System.out.println("1.회원등록 ");
		System.out.println("2.회원목록 보기 ");
		System.out.println("3.회원정보 수정하기");
		System.out.println("4.회원정보 삭제하기");
		System.out.println("5. 종료 ");
		
		int menuId = -1;
		try{
			String line = br.readLine();
			menuId = Integer.parseInt(line);  //문자열을 정수로 변환
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return menuId;
		}
	public String inputEmail() {
		System.out.println("email을 입력하세요");
		String email = "";
		try {
			email = br.readLine();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return email;
	}
	public User inputUser(String email) {
		try {
			System.out.println(email+"회원의 정보를 수정합니다.");
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println("생년을 입력하세요");
			String strbirthYear = br.readLine();
			int birthYear = Integer.parseInt(strbirthYear);
			
			User user = new User(name,email,birthYear);
			return user;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	public User regUser() {
		try {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println("e-mail을 입력하세요");
			String email = br.readLine();
			System.out.println("생년을 입력하세요");
			String strbirthYear = br.readLine();
			int birthYear = Integer.parseInt(strbirthYear);
			
			User user = new User(name,email,birthYear);
			return user;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void printuserList(Iterator<User> iter) {
		System.out.println("이름     email     생년");
		System.out.println("---------------------");
		
		while(iter.hasNext()){
			User user = iter.next();
			System.out.print(user.getName());
			System.out.print("     ");
			System.out.print(user.getEmail());
			System.out.print("     ");
			System.out.print(user.getBirthYear());
			System.out.println();
		}
		
	}

}

package usermanage;

import java.io.*;
import java.util.*;

public class UserMain {

	public static void main(String[] args) {
		UserUi userUi = new UserUi();
		UserDao userDao = new UserDao("/tmp/users.dat");
		UserService userService = new UserServiceInMemory(userDao.getUsers());
		while(true) {
			int menuId = userUi.menu();
			if(menuId == 5) {
				System.out.println("종료합니다.");
				userDao.saveUser(userService.getUser());
				break;
			}else if(menuId == 1) {
				User user = userUi.regUser();
				userService.addUser(user);
				System.out.println("등록되었습니다.");
			}else if(menuId == 2) {
				userUi.printuserList(userService.getUser());
			}else if(menuId == 3) {
				String email = userUi.inputEmail();
				boolean isFindEmail = userService.exists(email);
				if(isFindEmail) {
					User updateUser = userUi.inputUser(email);
					userService.updateUser(updateUser);
					System.out.println("수정되었습니다.");
				}
				else {
					System.out.println("수정할 회원 정보가 없습니다.");
				}
			}
			else if(menuId == 4){
				String email = userUi.inputEmail();
				boolean isFindEmail = userService.exists(email);
				if(isFindEmail) {
					userService.deleteUser(email);
				}
				else {
					System.out.println("삭제할 회원 정보가 없습니다.");
				}
			}
		}

	}

}

package usermanage;

import java.io.*;
import java.util.*;

public class UserServiceInMemory implements UserService{
	
	private List<User> users;
	
	public UserServiceInMemory() {
		this.users = new ArrayList<>();
	}
	public UserServiceInMemory(List<User> users) {
		this.users = users;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean deleteFlag = deleteUser(user.getEmail());
		if(deleteFlag) {
			users.add(user);
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		int findIndex = findIndex(email);
		if(findIndex != -1) {
			users.remove(findIndex);
			return true;
		}
		else {
		return false;
	}
		}

	@Override
	public Iterator<User> getUser() {
		// TODO Auto-generated method stub
		return users.iterator();
	}
	
	private int findIndex(String email) {
		int findIndex = -1;
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getEmail().equals(email)) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}

	@Override
	public boolean exists(String email) {
		// TODO Auto-generated method stub
		if(findIndex(email)!= -1) {
			return true;
		}
		else {
		return false;
		}
	}
	

}

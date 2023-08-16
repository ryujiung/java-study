package usermanage;

import java.util.*;
public interface UserService {
	
	public void addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(String email);
	
	public Iterator<User> getUser();
	
	public boolean exists(String email);

}

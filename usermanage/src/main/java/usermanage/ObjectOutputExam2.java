package usermanage;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.util.*;

public class ObjectOutputExam2 {

	public static void main(String[] args) throws Exception {
		
		User user1 = new User("홍길동","hong@example.com",1992);
		User user2 = new User("고길동","hong@example.com",1972);
		User user3 = new User("둘리","hong@example.com",1002);
		
		ArrayList<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		// /tmp/user.dat
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/tmp/userlist.dat"));
		out.writeObject(list);
		out.close();
		

	}

}

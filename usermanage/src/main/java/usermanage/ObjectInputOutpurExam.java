package usermanage;

import java.util.ArrayList;

import java.io.*;

public class ObjectInputOutpurExam {
	
	public static void main(String[] args) throws Exception {
		
		User user1 = new User("홍길동","hong@example.com",1992);
		User user2 = new User("고길동","hong@example.com",1972);
		User user3 = new User("둘리","hong@example.com",1002);
		
		ArrayList<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		ArrayList<User> list2 = copy(list);
		for(int i =0 ; i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		
	}

	private static ArrayList<User> copy(ArrayList<User> list) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(list);
		bout.close();
		out.close();
		
		byte[] array = bout.toByteArray();
		ObjectInputStream in  = new ObjectInputStream(new ByteArrayInputStream(array));
		ArrayList<User> list2 = (ArrayList)in.readObject();
		in.close();
		return list2;
	}

}

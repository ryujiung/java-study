package collection;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		
		//동질성(내용이 같은지 확인하는 것)
		//동일성(두 객체가 메모리 상에서 정확히 같은 객체인지 확인하는 것)
		s.add(s1);
		s.add(s2);
		
		System.out.println(s.size());
		System.out.println(s.contains(s2));
		//순회1
		for(String str : s) {
			System.out.println(str);
		}

	}

}

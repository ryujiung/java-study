package chapter04;

public class StringTest02 {
	
	public static void main(String[] args) {
		// 불변성(immutability)
		
		String s1 ="abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		String s4= s2.concat("??");
	}
}

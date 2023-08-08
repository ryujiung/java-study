package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i = 0;i<=99;i++) {
			String str = String.valueOf(i);
			if(str.contains("3")||str.contains("6")||str.contains("9")) {
				System.out.println(str+"짝");
			}
		}
	}
}

package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] charArr = str.toCharArray();
		int length = charArr.length;
		char[] reverseArr = new char[length];
		for(int i = 0;i<length;i++) {
			reverseArr[i] = charArr[length-i-1];
		
		}
		
		/* 코드를 완성합니다 */
		return reverseArr;
		
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}
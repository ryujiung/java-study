package exception;

public class Exception {

	public Exception(String message) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int a =10;
		int b = 10-a;
		
		System.out.println("Some code1");
		try {
			System.out.println("Some code2");
			int result = (1+2+3) /b;
			System.out.println("Some code3");
		
		}catch(ArithmeticException ex) {
//			System.out.println("예외 발생: "+ ex);
//			ex.printStackTrace();
			/* 예외 처리 */
			
			//1. 로깅
			System.out.println("error: "+ ex);
			
			//2. 사과
			System.out.println("미안합니다...");
			
			//3.정상종료
			//System.exit(0);
			return ;
		}finally {
			System.out.println("자원정리: file code, soket close,....");
		}
		//원칙적으로 이곳에 코드를 두지 않는다.
			System.out.println("Some code4");
		}

}

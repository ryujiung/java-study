package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int number = scanner.nextInt();
		
		if(number%2==1) {
			int sum = 0;
			for(int i = 1;i<=number;i+=2) {
				sum += i;
			}
			System.out.print("결과 값: "+sum);
		}
		else {
			int sum = 0;
			for(int i = 0; i<= number;i+=2) {
				sum += i;
				
			}
			System.out.print("결과 값: "+sum);
		}

		/* 코드 작성 */
		
		scanner.close();
	}
}

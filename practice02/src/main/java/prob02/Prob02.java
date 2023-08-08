package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("5개의숫자를 입력하세요: ");
		int[] intArray = new int[ 5 ];
		double sum = 0;
		
		
		for(int i = 0;i<5;i++) {
			intArray[i]= scanner.nextInt();
		}
		for(int j :intArray) {
			sum+=j;
			
		}
		System.out.print("평균은 "+sum/5);
		

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		
		/* 배열에 저장된 정수 값 더하기 */
		
		/* 출력 */
		
		/* 자원정리 */
		scanner.close();
	}
}

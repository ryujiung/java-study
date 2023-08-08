package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("수를 결정하였습니. 밎추어 보세요");
		System.out.println("0~100");
		while( true ) {
			
			/* 게임 작성 */
	
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			int low = 0;
			int high = 100;
			int num = 1;
			while(true) {
				System.out.print(num+">>");
				int guess = scanner.nextInt();
				
				if(guess == correctNumber) {
					break;
				}
				else if(guess > correctNumber) {
					System.out.println("더 낮게");
					high = guess;
					System.out.println(low+"~"+high);
					num+=1;
				}
				else if (guess < correctNumber){
					System.out.println("더 높게");
					low = guess;
					System.out.println(low+"~"+high);
					num+=1;
				}
				
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}
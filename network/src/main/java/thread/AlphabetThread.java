package thread;

public class AlphabetThread extends Thread{
	public void run() {
	for(char c = 'a'; c<='z';c++) {
		System.out.print(c);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

}

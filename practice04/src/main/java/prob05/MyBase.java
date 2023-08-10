package prob05;

public class MyBase extends Base {
	
	public void service(String state) {
		if(state.equals("오후")) {
			afternoon();
		}else if(state.equals("낮")) {
			lunch();
		}else{
			night();
		}
	}
	
	public void lunch() {
		System.out.println("낮에는 열심히 일하자");
	}

	public void afternoon() {
		System.out.println("오후도 낮 마찬가지로 해야 합니다.");
	}
	
	@Override
	public void night() {
		System.out.println("night");
	}



}

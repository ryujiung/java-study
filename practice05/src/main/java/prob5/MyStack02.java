package prob5;

public class MyStack02{
	
	static int index = 0;

	private Object[] buffer;
	
	public MyStack02(int i) {
		buffer = new String[i];
	}

	public void push(Object s) {
		
		if (index >= buffer.length){
			Object[] newBuffer = new Object[buffer.length*2];
			for(int i=0;i<buffer.length;i++) {
				newBuffer[i] = buffer[i];
			}
			buffer = null;
			buffer = newBuffer;
			newBuffer = null;
		}
		buffer[index] = s;
		index += 1;
	}

	public boolean isEmpty() {
		return index==0;
	}

	public Object pop() throws MyStackException {
		
		if(isEmpty()) {
			throw new MyStackException();
		}
		index -= 1;
		return buffer[index];
	}

}
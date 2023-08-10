package tv;

public class TV {
	private int channel; //1~255 이 범위를 벗어나면 로테이션
	private int volume;  //0~100 100을 넘으면 로테이션
	private boolean power;  
	
	public void power(boolean on) {
		power = on;
	}
	
	public void channel(int channel) {
		this.channel = channel;
		
	}
	
	public void channel(boolean up) {
		
	}
	
	public void volume(boolean up) {
		
	}
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV[power ="+(power ? "on" : "off" )+", channel"+ channel+", volume"+volume
				);
	}

}

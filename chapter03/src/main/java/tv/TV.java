package tv;

public class TV {
	private int channel; //1~255 이 범위를 벗어나면 로테이션
	private int volume;  //0~100 100을 넘으면 로테이션
	private boolean power;  
	
	public TV(int channel, int volume, boolean power) {
		this.channel =channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		power = on;
	}
	
	public void channel(int channel) {
	
		
		if(channel > 255) {
			channel =1;
		}else if(channel<1) {
			channel = 255;
		}
		if(!power) {
			return;
		}
		this.channel = channel;
		
	}
	
	public void channel(boolean up) {
		if(up) {
			channel(channel+1);
		}else {
			channel(channel-1);
		}
		
	}
	
	public void volume(boolean up) {
		if(up) {
			volume(volume+1);
		}else {
			volume(volume-1);
		}
		
	}
	public void volume(int volume) {
		if(!power) {
			return;
		}
		if(volume>100) {
			volume =0;
		}else if(volume<0) {
			volume = 100;
		}
		this.volume = volume;
	}
	
	public void status() {
		System.out.println("TV[power ="+(power ? "on" : "off" )+", channel = "+ channel+", volume = "+volume+"]"
				);
	}

}

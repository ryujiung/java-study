package prob2;

public class SmartPhone extends MusicPhone {
	@Override
	  public void execute ( String function ) {
	      if (function.equals("앱") ) {
	    	  	run();
	          return;
	      }
	      
	      super.execute( function );
	}

	private void run() {
		System.out.println("앱 실행");
		
	}

}

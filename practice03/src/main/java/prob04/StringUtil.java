package prob04;

public class StringUtil {
    public static String concatenate(String[] str) {
        String result ="";
    	//문자열을 결합하여 리턴 
    	for(String a: str) {
    		result += a;
    	}
    	return result;
    }
}


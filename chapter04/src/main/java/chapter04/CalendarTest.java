package chapter04;

import java.util.Calendar;

public class CalendarTest {
	

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR,2023);
		cal.set(Calendar.MONTH, 11); //12월 month-1
		cal.set(Calendar.DATE,25);
		printDate(cal);
		
		cal.set(1998,12,2);
		cal.add(Calendar.DATE,10000);
		printDate(cal);

	}
	private static void printDate(Calendar cal) {
		final String[] Days = {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); //0~11, 원하는 달을 출력하고 싶다면 +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "/" +
				(month + 1) + "/"+
				date + " " +
				Days[day-1] + "요일 "+
				hour + ":"+
				minute + ":"+
				second);
	}

}

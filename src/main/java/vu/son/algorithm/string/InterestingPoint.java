package vu.son.algorithm.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InterestingPoint {

	public static long compareTime(String startTime, String endTime)  {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		long elapsed = 0;
		try {
			Date d1 = sdf.parse(startTime);
			Date d2 = sdf.parse(endTime);
			elapsed = d2.getTime() - d1.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elapsed;
	}
	
	public static boolean checkInterestingPoint(String time) {
		
		Map<String, String> mapValues = new HashMap<String, String>();
		
		for(int i=0;i<time.length();i++) {
			if(!time.substring(i, i+1).equalsIgnoreCase(":") ) {
				if(!mapValues.containsKey(time.substring(i, i+1))) {
					mapValues.put(time.substring(i, i+1), time.substring(i, i+1));
				}
			}
		}
		
		if(mapValues.size() <= 2) return true;
		return false;
		
	}

	public static int findInterestingPoint(String s, String t) {

		String startTime = s;
		int interestingPoint = 0;
		while(compareTime(startTime, t)>=0) {
			String[] endTimeArray = startTime.split(":");
			if(checkInterestingPoint(startTime)) {
				interestingPoint++;
			}
			int hours = Integer.parseInt(endTimeArray[0]);
			int minutes = Integer.parseInt(endTimeArray[1]);
			int seconds = Integer.parseInt(endTimeArray[2]);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        
	        c.set(Calendar.HOUR_OF_DAY, hours);
	        c.set(Calendar.MINUTE, minutes);
	        c.set(Calendar.SECOND, seconds + 1);
	        Date currentDatePlusOne = c.getTime();
	        String temp = dateFormat.format(currentDatePlusOne);
	        startTime = temp.split(" ")[1];
	        
		}
		return interestingPoint;
	}
	
	
	public static void main(String[] args) {

		String s = "22:22:29";
		String t = "22:22:30";
		
		//Make sure input values to be valid
		System.out.println(findInterestingPoint(s, t));
	}
	 

}

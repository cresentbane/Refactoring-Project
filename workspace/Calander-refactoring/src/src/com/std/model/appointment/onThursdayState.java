package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onThursdayState implements State {

	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub
		if (ptt.onThursday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Thursday";
		}else{
			System.out.println("th");
		}
		return txt;
		
	}

}

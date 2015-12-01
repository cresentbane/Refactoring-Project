package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onSundayState implements State {

	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub
		if (ptt.onSunday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Sunday";
		}else{
			System.out.println("su");
		}
		return txt;
		
	}

}

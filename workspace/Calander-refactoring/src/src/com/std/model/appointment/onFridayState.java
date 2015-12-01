package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onFridayState implements State {

	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub

		if(ptt.onFriday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Friday";
		}else{
			System.out.println("fr");
		}
		return txt;
	}
}

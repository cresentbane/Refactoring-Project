package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onTuesdayState implements State {

	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub

		if(ptt.onTuesday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Tuesday";
		}else{
			System.out.println("tu");
		}
		return txt;
	}

}

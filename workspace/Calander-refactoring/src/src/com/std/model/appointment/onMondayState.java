package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onMondayState implements State {

	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub

		if (ptt.onMonday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Monday";
		}else{
			System.out.println("mo");
		}
		return txt ;
	}

}

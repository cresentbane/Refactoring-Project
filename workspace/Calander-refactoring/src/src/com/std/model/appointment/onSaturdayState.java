package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onSaturdayState implements State {


	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub
	//	return null;
	
	if(ptt.onTuesday()){
		txt += (txt.length() == 0 ? "" : ", ") + "Saturday";
	}else{
		System.out.println("sa");
	}
		return txt;
	}
}

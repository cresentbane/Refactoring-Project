package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onWednesdayState implements State {
     
	@Override
	public String doAction(Context context, DayOfWeekPattern ptt, String txt) {
		// TODO Auto-generated method stub
		
		if(ptt.onWednesday()){
			txt += (txt.length() == 0 ? "" : ", ") + "Wednesday";
		}else{
			System.out.println("we");
		}
		return txt;
		
	}

}

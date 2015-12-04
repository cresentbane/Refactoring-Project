package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;

public class onTuesdayState implements State {
	
	/**
	 * This is the method where it will update the String txt 
	 * that is needed in the getPatternDescription method in AppointmentUtility class.
	 * @param ptt -> this object from the  DayOfWeekPattern class, where it will check if the day is the same as the day of the state.
	 * @param context -> 
	 * @param txt -> it will take this String and update it depending on the ptt object.
	 * @return the updated String txt. 
	 */
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

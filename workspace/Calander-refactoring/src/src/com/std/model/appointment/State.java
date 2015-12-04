package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;
import src.com.std.model.pattern.RecurrencePattern;
import src.com.std.util.range.DateRange;

	/**
	 * 
	 * @author TalalAlsarrani
	 * 
	 * The interface that contains the method that must be implemented by all state classes.
	 */
public interface State {
	/**
	 * This is the method where it will update the String txt 
	 * that is needed in the getPatternDescription method in AppointmentUtility class.
	 * @param context -> 
	 * @param ptt -> 
	 * @param txt -> it will take this String and update it depending on the ptt object, and it will notify the Context object. 
	 * @return
	 */
	public String doAction(Context context, DayOfWeekPattern ptt, String txt);
	
	}

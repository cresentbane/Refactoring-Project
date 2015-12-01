package src.com.std.model.appointment;

import src.com.std.model.pattern.DayOfWeekPattern;
import src.com.std.model.pattern.RecurrencePattern;
import src.com.std.util.range.DateRange;


public interface State {

	public String doAction(Context context, DayOfWeekPattern ptt, String txt);
	
	}

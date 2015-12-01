package src.com.std.model.appointment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JLabel;

import src.com.std.controller.dialog.DatePanel;
import src.com.std.model.pattern.DayOfWeekPattern;
import src.com.std.model.pattern.NDaysPattern;
import src.com.std.model.pattern.RecurrencePattern;
import src.com.std.util.range.DateRange;

/**
 * AppointmentUtility is a utility class for working with Appointments
 * 
 * @author xxx
 */
public class AppointmentUtility {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("EEE, d MMM yyyy 'at' h:mm aa");
	
	public static final String NO_RECUR = "does not recur";
	
	/**
	 * Returns a sorted set of the appointments in set that 
	 * are at least partially contained by range
	 * 
	 * @param set set of all appointments
	 * @param range range to bound by
	 * @return a sorted set of the appointments in set that 
	 * are at least partially contained by range
	 */
	public static SortedSet<RefAppointment> getRange(Set<RefAppointment> set, DateRange range) {
		if(set == null)
			throw new NullPointerException("set");
		if(range == null)
			throw new NullPointerException("range");
		
		TreeSet<RefAppointment> startSet = new TreeSet<RefAppointment>(RefAppointment.COMPARATOR_APPOINTMENT_START);
		startSet.addAll(set);
		
		TreeSet<RefAppointment> endSet = new TreeSet<RefAppointment>(RefAppointment.COMPARATOR_APPOINTMENT_END);
		endSet.addAll(set);
		
		AppointmentTemplate apptTmpl = new AppointmentTemplate("", "", "", 0);
		RefAppointment startAppt = new RefAppointment(range.getStartDate(), apptTmpl);
		RefAppointment endAppt = new RefAppointment(range.getEndDate(), apptTmpl);
		
		SortedSet<RefAppointment> ret = startSet.headSet(endAppt);
		ret.removeAll(endSet.headSet(startAppt));
		
		return ret;
	}
	
	/**
	 * Returns a set of all the associated RefAppointments of a 
	 * AppointmentTemplate according to its RecurrencePattern
	 * 
	 * @param apptTmpl AppointmentTemplate to generate the pattern references of
	 * @return a set of all the associated RefAppointments of a 
	 * AppointmentTemplate according to its RecurrencePattern
	 */
	public static Set<RefAppointment> generatePatternAppointments(AppointmentTemplate apptTmpl) {
		if(apptTmpl == null)
			throw new NullPointerException("set");
		
		Set<RefAppointment> ret = new HashSet<RefAppointment>();
		if(apptTmpl.getPattern() != null)
			for(Date date : apptTmpl.getPattern().getDates())
				ret.add(new RefAppointment(date, apptTmpl));
		
		return ret;
	}
	
	public static String getPatternDescription(RecurrencePattern pattern) {
		// start with a blank string
		String text = "";
		
		if(pattern != null) {
			
			if(pattern instanceof NDaysPattern) {
				
				// generate the description string for NDaysPattern
				NDaysPattern ptt = (NDaysPattern)pattern;
				if(ptt.instanceEvery() == 1)
					text = "recurs every day";
				else if(ptt.instanceEvery() > 1)
					text = "recurs every " + ptt.instanceEvery() + " days ";
				
			} else if(pattern instanceof DayOfWeekPattern) {
				System.out.println("i'm heeeeeeere");
				// generate the description string for DayOfWeekPattern
				
				DayOfWeekPattern ptt = (DayOfWeekPattern)pattern;
				/**
				if(ptt.onSunday())
					text += (text.length() == 0 ? "" : ", ") + "Sunday";
				if(ptt.onMonday())
					text += (text.length() == 0 ? "" : ", ") + "Monday";
				if(ptt.onTuesday())
					text += (text.length() == 0 ? "" : ", ") + "Tuesday";
				if(ptt.onWednesday())
					text += (text.length() == 0 ? "" : ", ") + "Wednesday";
				if(ptt.onThursday())
					text += (text.length() == 0 ? "" : ", ") + "Thursday";
				if(ptt.onFriday())
					text += (text.length() == 0 ? "" : ", ") + "Friday";
				if(ptt.onSaturday())
					text += (text.length() == 0 ? "" : ", ") + "Saturday";
				**/
				Context context = new Context();
				State onMondayState= new onMondayState();
				State onSundayState= new onSundayState();
				State onWednesdayState= new onWednesdayState();
				State onFridayState= new onFridayState();
				State onThursdayState= new onThursdayState();
				State onTuesdayState= new onTuesdayState();
				State onSaturdayState= new onSaturdayState();
				
				context.setState(onMondayState);
				onMondayState.doAction(context, ptt, text);
				
				context.setState(onSundayState);
				onSundayState.doAction(context, ptt, text);
				
				context.setState(onWednesdayState);
				onWednesdayState.doAction(context, ptt, text);
				
				context.setState(onFridayState);
				onFridayState.doAction(context, ptt, text);
				
				context.setState(onThursdayState);
				onThursdayState.doAction(context, ptt, text);
				
				context.setState(onTuesdayState);
				onTuesdayState.doAction(context, ptt, text);
				
				context.setState(onSaturdayState);
				onSaturdayState.doAction(context, ptt, text);
				
				
				if(text.length() > 0)
					text = "recurs on " + text;
			}
			
			// append the RecurrencePattern dateRange data
			if(text.length() > 0)
				text += " from " + FORMAT.format(pattern.getRange().getStartDate())
					+ " to " + FORMAT.format(pattern.getRange().getEndDate());
		}
		
		// if we've come this far and still have an empty string,
		// either the pattern is null, or it otherwise doesn't
		// recur.  so, set the text to reflect that, and replace
		// whatever pattern we had with a null pattern.
		if(text.length() == 0)
			text = NO_RECUR;
		
		return text;
	}
	public static String getDurationDescription(long ms) {
		
		// construct the base conversions
		long min = ms / 1000 / 60;
		long hours = min / 60;
		long days = hours / 24;
		long weeks = days / 7;
		
		// truncate the conversions to get categories
		days %= 7;
		hours %= 24;
		min %= 60;
		
		// construct the string
		String s = "";
		if(weeks != 0)
			s += weeks + " week" + (weeks == 1 ? "" : "s");
		if(days != 0)
			s += (s.length() == 0 ? "" : ", ") + days + " day" + (days == 1 ? "" : "s");
		if(hours != 0)
			s += (s.length() == 0 ? "" : ", ") + hours + " hour" + (hours == 1 ? "" : "s");
		if(min != 0)
			s += (s.length() == 0 ? "" : ", ") + min + " minute" + (min == 1 ? "" : "s");
		if(s.length() == 0)
			s = "instantaneous";
		
		// set the text
		return s;
	}
}

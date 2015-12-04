package src.com.std.view.block;

import java.util.Date;
import java.util.Set;

import src.com.std.model.appointment.RefAppointment;

/**
 * This interface allows the listeners to figure out the date 
 * of the dayblock that was clicked on
 * 
 * @author xxx
 *
 */

public interface DayBlock {

	/**
	 * This method returns the date of the day block
	 * 
	 * @return returns the date 
	 */
	
	public Date getDate();
	void update(Set<RefAppointment> appts, Date d, RefAppointment r );
}

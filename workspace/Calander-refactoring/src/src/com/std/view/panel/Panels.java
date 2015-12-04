package src.com.std.view.panel;

import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Set;

import src.com.std.model.appointment.RefAppointment;

/**
 * An interface implemented by all the panels in the view
 * @author aliqa
 */
public interface Panels{
	
	// methods common to all panels
	public void update(Set<RefAppointment> refSet, Date selectedDate, RefAppointment selectedAppointment);
	public void addAppointmentListener(MouseListener m);
}

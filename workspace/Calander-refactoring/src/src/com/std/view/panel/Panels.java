package src.com.std.view.panel;

import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Set;

import src.com.std.model.appointment.RefAppointment;

public interface Panels{

	public void update(Set<RefAppointment> refSet, Date selectedDate, RefAppointment selectedAppointment);
	public void addAppointmentListener(MouseListener m);
}

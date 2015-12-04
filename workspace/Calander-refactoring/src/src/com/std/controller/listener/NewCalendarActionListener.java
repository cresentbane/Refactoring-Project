package src.com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.std.controller.CalendarController;
import src.com.std.model.Load;


/**
 * 
 * This class represents the listener for the new calendar
 * button.  It resets the calendar to a new one.
 * 
 * @author xxx
 *
 */
public class NewCalendarActionListener implements ActionListener {

	/**
	 * a reference to the controller so that this listener
	 * can access both the model and the view.
	 */
	private CalendarController controller;

	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public NewCalendarActionListener(CalendarController cc){
		controller = cc;
	}
	
	/**
	 * This method resets the calendar to a 
	 * blank one.
	 * 
	 * @param ActionEvent e is the event
	 * spawn when the new calendar button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			controller.getModel().save(null, new Load(null, controller.getModel()));
		} catch(Exception ex) {
			controller.handleException(ex);
		}
	}

}




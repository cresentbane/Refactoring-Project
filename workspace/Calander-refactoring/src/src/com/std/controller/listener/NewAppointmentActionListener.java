package src.com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.com.std.controller.CalendarController;
import src.com.std.controller.dialog.AppointmentDialog;
import src.com.std.model.CalendarModelUtility;
import src.com.std.model.appointment.RefAppointment;

public class NewAppointmentActionListener implements ActionListener {

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
	public NewAppointmentActionListener(CalendarController cc){
		controller = cc;
	}
		
	/**
	 * This whent the user clicks the new appointent button, it creats
	 * a dialogue box that allows the user to enter new information
	 */
	
	public void actionPerformed(ActionEvent e) {
		RefAppointment ref = CalendarModelUtility.getNewAppointment(controller.getModel());
		
		if(AppointmentDialog.changeAppointment(controller.getView(), ref)) {
			CalendarModelUtility.addUsingPattern(controller.getModel(), ref);
		}
	}

}

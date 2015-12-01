package src.com.std.controller;

import src.com.std.controller.listener.AboutActionListener;
import src.com.std.controller.listener.AppointmentSelectionMouseListener;
import src.com.std.controller.listener.DateSelectionActionListener;
import src.com.std.controller.listener.DefaultWindowListener;
import src.com.std.controller.listener.EditAppointmentActionListener;
import src.com.std.controller.listener.EditRecurringAppointmentActionListener;
import src.com.std.controller.listener.ExitApplicationActionListener;
import src.com.std.controller.listener.NewAppointmentActionListener;
import src.com.std.controller.listener.NewCalendarActionListener;
import src.com.std.controller.listener.NextButtonActionListener;
import src.com.std.controller.listener.OpenCalendarActionListener;
import src.com.std.controller.listener.PreferencesActionListener;
import src.com.std.controller.listener.PrevButtonActionListener;
import src.com.std.controller.listener.RemoveAllAppointmentActionListener;
import src.com.std.controller.listener.RemoveAppointmentActionListener;
import src.com.std.controller.listener.SaveAsCalendarActionListener;
import src.com.std.controller.listener.SaveCalendarActionListener;
import src.com.std.controller.listener.ViewHistoryActionListener;

public class ListenerInstantiation {

	CalendarController cc;
	
	ListenerInstantiation(CalendarController c){
		this.cc = c;
	}
	
	public void instantiate(){
		
		// listens for when the view tries to be disposed
		DefaultWindowListener defW = new DefaultWindowListener(cc);
		cc.getView().addWindowListener(defW);
		
		
		// listens for when an appointment is selected
		AppointmentSelectionMouseListener apptSelL = new AppointmentSelectionMouseListener(cc);
		cc.getView().addAppointmentSelectionListener(apptSelL);
		
		ViewHistoryActionListener vv = new ViewHistoryActionListener(cc);
		cc.getView().addViewHistoryActionListener(vv);


		// listens for when a date is selected
		DateSelectionActionListener dateSelL = new DateSelectionActionListener(cc);
		cc.getView().addDateSelectionListener(dateSelL);
		
		
		// listens for when the next button is pressed
		NextButtonActionListener nextL = new NextButtonActionListener(cc);
		cc.getView().addNextButtonActionListener(nextL);

		// listens for when the previous button is pressed
		PrevButtonActionListener prevL = new PrevButtonActionListener(cc);
		cc.getView().addPrevButtonActionListener(prevL);
		
		
		// listens for when the menu item "New Calendar" is selected
		NewCalendarActionListener newCalL = new NewCalendarActionListener(cc);
		cc.getView().addNewCalendarActionListener(newCalL);

		// listens for when the menu item "Open Calendar" is selected
		OpenCalendarActionListener openCalL = new OpenCalendarActionListener(cc);
		cc.getView().addOpenCalendarActionListener(openCalL);

		// listens for when the menu item "Save Calendar" is selected
		SaveCalendarActionListener saveCalL = new SaveCalendarActionListener(cc);
		cc.getView().addSaveCalendarActionListener(saveCalL);

		// listens for when the menu item "Save As Calendar" is selected
		SaveAsCalendarActionListener saveAsCalL = new SaveAsCalendarActionListener(cc);
		cc.getView().addSaveAsCalendarActionListener(saveAsCalL);

		// listens for when the menu item "Exit" is selected
		ExitApplicationActionListener exitAppL = new ExitApplicationActionListener(cc);
		cc.getView().addExitApplicationActionListener(exitAppL);

		// listens for when the menu item "New Appointment" is selected
		NewAppointmentActionListener newApptL = new NewAppointmentActionListener(cc);
		cc.getView().addNewAppointmentActionListener(newApptL);

		// listens for when the menu item "Edit Appointment" is selected
		EditAppointmentActionListener editApptL = new EditAppointmentActionListener(cc);
		cc.getView().addEditAppointmentActionListener(editApptL);

		// listens for when the menu item "Edit Recurring Appointment" is selected
		EditRecurringAppointmentActionListener editRecApptL = new EditRecurringAppointmentActionListener(cc);
		cc.getView().addEditAllAppointmentActionListener(editRecApptL);

		// listens for when the menu item "Remove Appointment" is selected
		RemoveAppointmentActionListener remApptL = new RemoveAppointmentActionListener(cc);
		cc.getView().addRemoveAppointmentActionListener(remApptL);

		// listens for when the menu item "Remove All Occurances" is selected
		RemoveAllAppointmentActionListener remAllApptL = new RemoveAllAppointmentActionListener(cc);
		cc.getView().addRemoveAllAppointmentActionListener(remAllApptL);

		// listens for when the menu item "Preferences" is selected
		PreferencesActionListener prefL = new PreferencesActionListener(cc);
		cc.getView().addPreferencesActionListener(prefL);

		// listens for when the menu item "About" is selected
		AboutActionListener aboutL = new AboutActionListener(cc);
		cc.getView().addAboutActionListener(aboutL);
	}
}

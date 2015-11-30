package src;
import java.io.IOException;

import src.com.std.controller.CalendarController;
import src.com.std.model.CalendarModel;
import src.com.std.view.CalendarView;

/**
 * Load the GUI to run the Calendar application
 * 
 * @author xxx
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		
		CalendarModel model = new CalendarModel();
		CalendarView view = new CalendarView();
		
		CalendarController controler = new CalendarController(model, view);
		view.setVisible(true);	
	}
}

package src.com.std.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

import src.com.std.model.appointment.AppointmentTemplate;
import src.com.std.model.appointment.RefAppointment;

/**
 * This class is responsible for importing a calendar 
 * file into the system.
 * @author aliqa
 */
public class Load implements Persist{

	File file;
	CalendarModel cm;
	
	/**
	 * The constructor takes the file the calendar must be imported 
	 * from and the model to relay the information
	 * @param file
	 * @param c
	 */
	public Load(File file, CalendarModel c) {
		super();
		this.file = file;
		this.cm = c;
	}
	
	/**
	 * The method that saves the calendar file in the model.
	 */
	public void save() throws FileNotFoundException, IOException, ClassNotFoundException {
		Set<AppointmentTemplate> apptTmplSet = new HashSet<AppointmentTemplate>();
		Set<RefAppointment> apptSet = new HashSet<RefAppointment>();
		AppointmentTemplate defaultApptTmpl = cm.getCurrentDefaults();
		if(file != null) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			defaultApptTmpl = (AppointmentTemplate)in.readObject();
			int count = in.readInt();
			while(count-- > 0)
				apptTmplSet.add((AppointmentTemplate)in.readObject());
			count = in.readInt();
			while(count-- > 0)
				apptSet.add((RefAppointment)in.readObject());
		}
		cm.getCurrentDefaults().setFields(defaultApptTmpl);
		cm.getAppointmentSet().clear();
		cm.getAppointmentTemplateSet().clear();
		cm.getAppointmentTemplateSet().addAll(apptTmplSet);
		cm.getAppointmentSet().addAll(apptSet);
		
	}

}

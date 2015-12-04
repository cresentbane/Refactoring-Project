package src.com.std.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import src.com.std.model.appointment.AppointmentTemplate;
import src.com.std.model.appointment.RefAppointment;

/**
 * This class is responsible for exporting a calendar 
 * file out of the system.
 * @author aliqa
 */
public class Save implements Persist{

	File file;
	CalendarModel cm;
	
	/**
	 * The constructor takes the file the calendar must be exported 
	 * to and the model to obtain the information
	 * @param file
	 * @param c
	 */
	public Save(File file, CalendarModel c) {
		super();
		this.file = file;
		this.cm = c;
	}

	/**
	 * The method that saves the calendar to the file.
	 */
	public void save() throws IOException {
		if(file == null)
			throw new NullPointerException("file");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(cm.getDefaultApptTmpl());
		out.writeInt(cm.getAppointmentTemplateSet().size());
		for(AppointmentTemplate apptTmpl : cm.getAppointmentTemplateSet())
			out.writeObject(apptTmpl);
		out.writeInt(cm.getApptSet().size());
		for(RefAppointment appt : cm.getApptSet()){
			out.writeObject(appt);
		}
	}

}

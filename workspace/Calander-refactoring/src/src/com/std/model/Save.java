package src.com.std.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import src.com.std.model.appointment.AppointmentTemplate;
import src.com.std.model.appointment.RefAppointment;

public class Save implements Persist{

	File file;
	CalendarModel cm;
	
	public Save(File file, CalendarModel c) {
		super();
		this.file = file;
		this.cm = c;
	}

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

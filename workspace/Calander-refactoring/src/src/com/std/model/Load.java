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

public class Load implements Persist{

	File file;
	CalendarModel cm;
	
	public Load(File file, CalendarModel c) {
		super();
		this.file = file;
		this.cm = c;
	}
	
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

package src.com.std.controller.listener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.com.std.controller.CalendarController;
import src.com.std.model.appointment.RefAppointment;
import src.com.std.util.ObservableSet;

/**
 * This occurs when the user clicks the "view appointment history"
 * on the appointment panel, a new window is displayed with a table of 
 * all the appointments and an option to filter the displayed appointments
 * through search.
 * 
 * @author Qasim Ali
 *
 */

public class ViewHistoryActionListener implements ActionListener {

	/**
	 * a reference to the controller so that this listener
	 * can access both the model and the view.
	 */
	private CalendarController controller;
    private JFrame frame = new JFrame();


    
	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public ViewHistoryActionListener(CalendarController cc){
		controller = cc;
	}
	
	/**
	 * This occurs when the user clicks the "view appointment history"
	 * on the appointment panel, a new window is displayed with a table of 
	 * all the appointments and an option to filter the displayed appointments
	 * through search.
	 * @param e is the action event, it is not used
	 */
	public void actionPerformed(ActionEvent e) {

		 getAll();

	    JButton search = new JButton("Search");
	    JButton all = new JButton("All Appointments");
	    
		JPanel bottomPanel = new JPanel();

		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JTextField txt = new JTextField(12);
		bottomPanel.add(txt);
		bottomPanel.add(search);
		bottomPanel.add(all);
		
		frame.add(bottomPanel, BorderLayout.NORTH);
	    
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getSearch(txt.getText());
			}
		});
	    
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getAll();
			}
		});
	   

	}
	
	/**
	 * searches for a match between the search string and
	 * appointment attributes and displays the results.
	 * @param search
	 */
	private void getSearch(String search){
		
		//frame.removeAll();
	    // create object of table and table model
	    JTable table = new JTable();
	    DefaultTableModel dtm = new DefaultTableModel(0, 0);
	   // add header of the table
	   String header[] = new String[] {"Title", "Location", "Start Date", "End Date", "Duration", "Description"};
	   // add header in table model     
	    dtm.setColumnIdentifiers(header);
	          table.setModel(dtm);
	        // add row dynamically into the table   
	    table.getColumnModel().getColumn(5).setPreferredWidth(300);
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    table.setEnabled(false);
	    
	    ObservableSet<RefAppointment> set = new ObservableSet<RefAppointment>();
		for (RefAppointment r: controller.theModel.getAppointmentSet()){
			if (r.getTitle().toLowerCase().contains(search.toLowerCase())||r.getDescription().toLowerCase().contains(search.toLowerCase()) || r.getLocation().toLowerCase().contains(search.toLowerCase())){
				set.add(r);
			}
		}
		
		for (RefAppointment r : set){
			String dur = "";
		    if (Long.toString(r.getDuration()/86400000).equals("0")){
		    	dur = Long.toString(r.getDuration()/3600000)+ " hour(s)";
		    }
		    else{
		    	dur = Long.toString(r.getDuration()/86400000) + " day(s)";
		    }
			dtm.addRow(new Object[] { r.getTitle(), r.getLocation(), r.getStartDate().toGMTString().substring(0, 17), r.getEndDate().toGMTString().substring(0, 17), dur, r.getDescription() });
		}

	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(1000, 700);
	    frame.setVisible(true);
	}
	
	/**
	 * Changes the frame to display all the appointments
	 */
	private void getAll(){

	    // create object of table and table model
	    JTable table = new JTable();
	    DefaultTableModel dtm = new DefaultTableModel(0, 0);
	   // add header of the table
	   String header[] = new String[] {"Title", "Location", "Start Date", "End Date", "Duration", "Description"};
	   // add header in table model     
	    dtm.setColumnIdentifiers(header);
	          table.setModel(dtm);
	        // add row dynamically into the table   
	    table.getColumnModel().getColumn(5).setPreferredWidth(300);
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    table.setEnabled(false);

		for (RefAppointment r: controller.theModel.getAppointmentSet()){
			String dur = "";
		    if (Long.toString(r.getDuration()/86400000).equals("0")){
		    	dur = Long.toString(r.getDuration()/3600000) + " hour(s)";
		    }
		    else{
		    	dur = Long.toString(r.getDuration()/86400000) + " day(s)";
		    }
			dtm.addRow(new Object[] { r.getTitle(), r.getLocation(), r.getStartDate().toGMTString().substring(0, 17), r.getEndDate().toGMTString().substring(0, 17), dur, r.getDescription() });
		}
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(1000, 700);
		frame.setVisible(true);
	}
	
}

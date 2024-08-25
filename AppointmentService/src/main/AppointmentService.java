package main;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	 private Map<String, Appointment> appointments = new HashMap<>();
	 
	 //Method to add an appointment by unique ID
	 public boolean addAppointment(Appointment appointment) {
		 if(appointments.containsKey(appointment.getAppointmentID())) {
			 throw new IllegalArgumentException("Appointment ID already exists");
		 }
		 appointments.put(appointment.getAppointmentID(), appointment);
		 return true;
	 }
	 
	 //Method to delete an appointment by ID
	 public boolean deleteAppointment(String appointmentID) {
		 if(!appointments.containsKey(appointmentID)) {
			 throw new IllegalArgumentException("Appointment ID not found");
		 }
		 appointments.remove(appointmentID);
		 return true;
	 }
}

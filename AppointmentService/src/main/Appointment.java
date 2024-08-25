package main;
import java.util.Date;


public class Appointment {
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment (String appointmentID,Date appointmentDate, String appointmentDescription){
		//Validate and set appointmentId
		if(appointmentID == null || appointmentID.length() >10) {
			throw new IllegalArgumentException("Invalid appointmentID");
		}
		this.appointmentID = appointmentID;
		
		// Validate and set appointmentDate
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		this.appointmentDate = appointmentDate;
		
		// Validate and set appointmentDescription
		if(appointmentDescription == null || appointmentDescription.length() >50) {
			throw new IllegalArgumentException("Invalid appointmentDescription");
		}
		this.appointmentDescription = appointmentDescription;
	}
	
	
	//Getters and Setters and validation 
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate){
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		this.appointmentDate = appointmentDate;
		
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if(appointmentDescription == null || appointmentDescription.length() >50) {
			throw new IllegalArgumentException("Invalid appointmentDescription");
		}
		this.appointmentDescription = appointmentDescription;
	}
}

/**
 * 
 */
package test;
import org.junit.jupiter.api.Test;
import java.util.Date;

import main.Appointment;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

/**
 * 
 */
public class AppointmentTest {
	
	@Test
	@DisplayName("Test appointment creation with invlaid inputs")
	public void testAppointmentCreation() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);//1 day in the future
		Appointment appointment = new Appointment("001", futureDate, "This is a test appointment.");
		assertEquals("001", appointment.getAppointmentID());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("This is a test appointment.", appointment.getAppointmentDescription());
	}
	
	@Test
	@DisplayName("Test appointment creation for today")
	public void testAppointmentForToday() {
	    // Create a date object representing the current date and time
	    Date today = new Date();
	    
	    // Create an appointment for today
	    Appointment appointment = new Appointment("003", today, "This is a test appointment for today.");
	    
	    // Verify the appointment details
	    assertEquals("003", appointment.getAppointmentID());
	    assertEquals(today, appointment.getAppointmentDate());
	    assertEquals("This is a test appointment for today.", appointment.getAppointmentDescription());
	}
	
	@Test
	@DisplayName("Test appoinmtent with invalid appointmentID")
	public void testAppointmentInvalidID() {
		Date futureDate = new Date(System.currentTimeMillis()+ 86400000);//future appointment 
		
		//Test null appointment ID
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, futureDate, "This is a test appointment.");//AppointmentID null
		});
		
		//Test appointment ID too long
				assertThrows(IllegalArgumentException.class, () ->{
					new Appointment("12345678912", futureDate, "This is a test appointment.");//AppointmentID too long
				});
	}
	
	@Test
	@DisplayName("Test appointment with invalid date")
	public void testAppointmentInvalidDate() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); //in the past
		
		// Test null date
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("001", null, "This is a test appointment." );//appointment null
		});
		
		//Test date in the past
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("001", pastDate, "This is a test appointment.");
		});
	}
	
	@Test
	@DisplayName("Test appointment with invalid description")
	public void testAppointmentInvalidDescription() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);//Future appointment
		
		//Test null description
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("001", futureDate, null);
		});
		
		//Test too long description
		assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("001", futureDate, "This is a test appointment description "
					+ "that is too long 123456789101112131415161718192021222324252627282930.");			
		});
	}
	@Test
	@DisplayName("Test setters with valid inputs")
	public void testSettersValid() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);//Future Date
		Appointment appointment = new Appointment("001", futureDate, "This is a test appointment.");
		
		//Set new Date
		Date newFutureDate = new Date(System.currentTimeMillis() + 86400000);//new Future date
		appointment.setAppointmentDate(newFutureDate);
		assertEquals(newFutureDate, appointment.getAppointmentDate());
		
		
		//Set new description
		appointment.setAppointmentDescription("Update appointment description.");
		assertEquals("Update appointment description.", appointment.getAppointmentDescription());
		
	}
	
	@Test
	@DisplayName("Test setters with invald inputs")
	public void testSettersInvalid() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);//Day in the future
		Appointment appointment = new Appointment("001", futureDate, " This is a test appoinment.");
		
		//Test setting date to past date
		Date pastDate =  new Date(System.currentTimeMillis() - 86400000);//Day in the past
		assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentDate(pastDate);
		});
		
		//Test setting Description too long
		assertThrows(IllegalArgumentException.class, () ->{
			appointment.setAppointmentDescription("This is a test appointment description "
					+ "that is way too long 23456789101112131415161718192021222324252627282930.");	
		});
	}
}
	

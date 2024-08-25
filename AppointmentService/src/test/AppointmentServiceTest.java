package test;

import main.Appointment;
import main.AppointmentService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Appointment Service Test")
public class AppointmentServiceTest {
	
	@Test
	@DisplayName("Should add a new appointment successfully")
	void testAddAppointment() {
		AppointmentService appointmentservice = new AppointmentService();
		Appointment appointment = new Appointment("001", new Date(), "Client's appointment");
		assertTrue(appointmentservice.addAppointment(appointment));
	}
	
	@Test
	@DisplayName("Should throw a exception when trying to add a duplicate appointment ID")
	void testAddDuplicateAppointment() {
		AppointmentService appointmentservice = new AppointmentService();
		Appointment appointment = new Appointment("001", new Date(), "Client's appointment");
		appointmentservice.addAppointment(appointment);
		
		assertThrows(IllegalArgumentException.class, () ->{
			appointmentservice.addAppointment(appointment);//Attempt to add the same appointment again
		});
	}
	
	@Test
    @DisplayName("Should delete an existing appointment successfully")
    void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("002", futureDate, "Client's appointment");
        appointmentService.addAppointment(appointment);

        // Test successful deletion
        assertTrue(appointmentService.deleteAppointment("002"));
        
         // Verify that the appointment was removed
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("002"); // Attempting to delete again should fail
        });
    }

    @Test
    @DisplayName("Should throw an exception when trying to delete a non-existent appointment")
    void testDeleteNonExistentAppointment() {
        AppointmentService appointmentService = new AppointmentService();

        // Test exception for non-existent appointment ID
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("003"); // Attempt to delete an appointment that doesn't exist
        });
    }
}

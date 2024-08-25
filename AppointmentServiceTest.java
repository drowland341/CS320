package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Appointment;
import main.AppointmentService;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("1234567890", futureDate, "Whatever appointment");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("1234567890"));
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("1234567890", futureDate, "Whatever appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1234567890");
        assertNull(appointmentService.getAppointment("1234567890"));
    }

    @Test
    public void testAddDuplicateAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment1 = new Appointment("1234567890", futureDate, "Whatever appointment");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Dentist's appointment");
        appointmentService.addAppointment(appointment1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
        assertEquals("Appointment ID already exists", exception.getMessage());
    }

    @Test
    public void testDeleteNonExistentAppointmentID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistent");
        });
        assertEquals("Appointment ID does not exist", exception.getMessage());
    }
}

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Appointment;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("1234567890", futureDate, "Whatever appointment");
        assertAll("appointment",
                () -> assertEquals("1234567890", appointment.getAppointmentID()),
                () -> assertEquals(futureDate, appointment.getAppointmentDate()),
                () -> assertEquals("Whatever appointment", appointment.getDescription()));
    }

    @Test
    public void testAppointmentIDNotNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Whatever appointment");
        });
        assertEquals("Invalid appointment ID", exception.getMessage());
    }

    @Test
    public void testAppointmentIDTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Whatever appointment"); // 11 characters
        });
        assertEquals("Invalid appointment ID", exception.getMessage());
    }

    @Test
    public void testAppointmentDateNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Whatever appointment");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testAppointmentDateNotPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Whatever appointment");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testDescriptionNotNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, null);
        });
        assertEquals("Invalid description", exception.getMessage());
    }

    @Test
    public void testDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This is a very long appointment description that exceeds fifty characters.");
        });
        assertEquals("Invalid description", exception.getMessage());
    }
}

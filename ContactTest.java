package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Contact;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Tony", "Stark", "0123456789", "12340 Malibu Point");
        assertAll("contact",
                () -> assertEquals("1234567890", contact.getContactID()),
                () -> assertEquals("Tony", contact.getFirstName()),
                () -> assertEquals("Stark", contact.getLastName()),
                () -> assertEquals("0123456789", contact.getPhone()),
                () -> assertEquals("12340 Malibu Point", contact.getAddress()));
    }

    @Test
    public void testContactIDNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tony", "Stark", "0123456789", "12340 Malibu Point");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testFirstNameNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Stark", "0123456789", "12340 Malibu Point");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }
}

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Tony", "Stark", "0123456789", "12340 Malibu Point");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Tony", "Stark", "0123456789", "12340 Malibu Point");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "Tony", "Stark", "0123456789", "12340 Malibu Point");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Peter", "Parker", "0987654321", "20 Ingram Street");
        Contact updatedContact = contactService.getContact("1234567890");
        assertAll("updatedContact",
                () -> assertEquals("Peter", updatedContact.getFirstName()),
                () -> assertEquals("Parker", updatedContact.getLastName()),
                () -> assertEquals("0987654321", updatedContact.getPhone()),
                () -> assertEquals("20 Ingram Street", updatedContact.getAddress()));
    }
}

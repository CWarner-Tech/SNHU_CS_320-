package test;

import main.ContactService;
import main.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService(); // Initialize the service before each test
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Courtney", "Warner", "1234567891", "10 CandyCane Lane");
        contactService.addContact(contact); // Add new contact
        assertEquals(contact, contactService.getContact("1234567890"));// Verify new contact
    }

    @Test
    public void testAddContactDuplicate() {
        Contact contact1 = new Contact("1234567890", "Courtney", "Warner", "1234567891", "10 CandyCane Lane");
        Contact contact2 = new Contact("1234567890", "Sally", "Pheuy", "1234567891", "10 CandyRoad");
        contactService.addContact(contact1);// Add first contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);// try adding duplicate contact
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567891", "Courtney", "Warner", "1234567891", "10 CandyCane Lane");
        contactService.addContact(contact);// Add a contact
        contactService.deleteContact("1234567891");// Delete the contact
        assertNull(contactService.getContact("1234567891"));//Verify contact deleted
    }

    @Test
    public void testDeleteContactNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567896");// Try deleting non-existing contact
        });
    }
    
    @Test
    public void testUpdateContactFirstNameValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contactService.addContact(contact);// Add contact
        contactService.updateContactFirstName("001", "Voradet");//Update first name
        assertEquals("Voradet", contactService.getContact("001").getFirstName());//Verify 
    }

    @Test
    public void testUpdateContactFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("999", "Voradet");  // Try updating non-existing contact
        });
    }
   
    @Test
    public void testUpdateContactLastNameValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contactService.addContact(contact);// Add contact
        contactService.updateContactLastName("001", "Samsung");// Update last name
        assertEquals("Samsung", contactService.getContact("001").getLastName()); // Verify 
    }

    @Test
    public void testUpdateContactLastNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactLastName("999", "Smith");  // Try updating non-existing contact
        });
    }
    @Test
    public void testUpdateContactNumberValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contactService.addContact(contact); // Add contact
        contactService.updateContactNumber("001", "1234567890");// Update number
        assertEquals("1234567890", contactService.getContact("001").getNumber());// Verify
    }

    @Test
    public void testUpdateContactNumberInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactNumber("999", "1234567890");  // Non-existent contact ID
        });
    }
    
    @Test
    public void testUpdateContactAddressValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contactService.addContact(contact);
        contactService.updateContactAddress("001", "20 New Road");
        assertEquals("20 New Road", contactService.getContact("001").getAddress());
    }

    @Test
    public void testUpdateContactAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactAddress("999", "20 New Road");  // Non-existent contact ID
        });
    }
    @Test
    public void testSetFirstNameValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contact.setFirstName("Voradet");
        assertEquals("Voradet", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameInvalidNull() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetFirstNameInvalidTooLong() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("FirstNameIsTooLong");
        });
    }
    @Test
    public void testSetLastNameValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetLastNameInvalidNull() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testSetLastNameInvalidTooLong() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("LastNameIsTooLong");
        });
    }
    
    @Test
    public void testSetNumberValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contact.setNumber("1234567890");
        assertEquals("1234567890", contact.getNumber());
    }

    @Test
    public void testSetNumberInvalidNull() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber(null);
        });
    }

    @Test
    public void testSetNumberInvalidFormat() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber("1234");
        });
    }
    @Test
    public void testSetAddressValid() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        contact.setAddress("20 New Road");
        assertEquals("20 New Road", contact.getAddress());
    }

    @Test
    public void testSetAddressInvalidNull() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void testSetAddressInvalidTooLong() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("ThisAddressIsWayTooLongForTheProgram");
        });
    }
}
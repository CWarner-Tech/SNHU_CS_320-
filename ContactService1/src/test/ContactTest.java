package test;

import main.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Helper method to create a default valid contact for reuse in tests
    private Contact createDefaultContact() {
        return new Contact("001", "Courtney", "Warner", "5555555555", "10 CandyCane Lane");
    }

    //Constructor tests
    // Test to verify that creating a contact with null arguments throws an exception
    @Test
    void testContactNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, null, null, null, null),
                     "Creating a contact with null arguments should throw IllegalArgumentException");
    }

    // Test creating a contact with all valid parameters
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("002", "Alice", "Johnson", "0987654321", "123 Elm Street");
        assertEquals("002", contact.getContactId(), "Contact ID should match");
        assertEquals("Alice", contact.getFirstName(), "First name should match");
        assertEquals("Johnson", contact.getLastName(), "Last name should match");
        assertEquals("0987654321", contact.getNumber(), "Phone number should match");
        assertEquals("123 Elm Street", contact.getAddress(), "Address should match");
    }

    //Getter Test
    // Test for valid contact creation and getters
    @Test
    void testContactAndGetters() {
        Contact contact = createDefaultContact();
        assertEquals("001", contact.getContactId(), "Contact ID should match");
        assertEquals("Courtney", contact.getFirstName(), "First name should match");
        assertEquals("Warner", contact.getLastName(), "Last name should match");
        assertEquals("5555555555", contact.getNumber(), "Phone number should match");
        assertEquals("10 CandyCane Lane", contact.getAddress(), "Address should match");
    }

    //Boundary tests
    // Test for firstName of exactly 10 characters
    @Test
    void testFirstNameExactLength() {
        Contact contact = new Contact("001", "abcdefghij", "Warner", "5555555555", "10 CandyCane Lane");
        assertEquals("abcdefghij", contact.getFirstName(), "First name should be exactly 10 characters");
    }

    // Test for lastName of exactly 10 characters
    @Test
    void testLastNameExactLength() {
        Contact contact = new Contact("001", "Courtney", "abcdefghij", "5555555555", "10 CandyCane Lane");
        assertEquals("abcdefghij", contact.getLastName(), "Last name should be exactly 10 characters");
    }

    // Test for number of exactly 10 digits
    @Test
    void testNumberExactLength() {
        Contact contact = new Contact("001", "Courtney", "Warner", "1234567890", "10 CandyCane Lane");
        assertEquals("1234567890", contact.getNumber(), "Phone number should be exactly 10 digits");
    }

    // Test for address of exactly 30 characters
    @Test
    void testAddressExactLength() {
        Contact contact = new Contact("001", "Courtney", "Warner", "5555555555", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", contact.getAddress(), "Address should be exactly 30 characters");
    }

	//Setter Tests
    
 // Test to verify that setting empty strings does not throw an exception but should handle gracefully
    @Test
    void testSetEmptyFirstName() {
        Contact contact = createDefaultContact();
        contact.setFirstName("");
        assertEquals("", contact.getFirstName(), "First name should be set to empty string");
    }

    @Test
    void testSetEmptyLastName() {
        Contact contact = createDefaultContact();
        contact.setLastName("");
        assertEquals("", contact.getLastName(), "Last name should be set to empty string");
    }

    @Test
    void testSetEmptyAddress() {
        Contact contact = createDefaultContact();
        contact.setAddress("");
        assertEquals("", contact.getAddress(), "Address should be set to empty string");
    }

    // Test setting a valid firstName
    @Test
    void testSetFirstNameValid() {
        Contact contact = createDefaultContact();
        contact.setFirstName("Sally");
        assertEquals("Sally", contact.getFirstName(), "First name should be updated successfully");
    }

    // Test setting firstName longer than 10 characters
    @Test
    void testSetFirstNameTooLong() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstNameIsTooLong"),
                     "Setting first name should throw exception if length is greater than 10");
    }

    // Test setting firstName to null
    @Test
    void testSetFirstNameNull() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null),
                     "Setting first name should throw exception if it is null");
    }

    // Test setting a valid lastName
    @Test
    void testSetLastNameValid() {
        Contact contact = createDefaultContact();
        contact.setLastName("Day");
        assertEquals("Day", contact.getLastName(), "Last name should be updated successfully");
    }

    // Test setting lastName longer than 10 characters
    @Test
    void testSetLastNameTooLong() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastNameIsTooLong"),
                     "Setting last name should throw exception if length is greater than 10");
    }

    // Test setting lastName to null
    @Test
    void testSetLastNameNull() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null),
                     "Setting last name should throw exception if it is null");
    }

    // Test setting a valid number
    @Test
    void testSetNumberValid() {
        Contact contact = createDefaultContact();
        contact.setNumber("1234567890");
        assertEquals("1234567890", contact.getNumber(), "Phone number should be updated successfully");
    }

    // Test setting number with invalid length
    @Test
    void testSetNumberInvalidLength() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber("12345"),
                     "Setting number should throw exception if length is not 10");
    }

    // Test setting number with invalid format
    @Test
    void testSetNumberInvalidFormat() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber("12345678901"),
                     "Setting number should throw exception if not 10 digits");
    }

    // Test setting number to null
    @Test
    void testSetNumberNull() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber(null),
                     "Setting number should throw exception if it is null");
    }

    // Test setting a valid address
    @Test
    void testSetAddressValid() {
        Contact contact = createDefaultContact();
        contact.setAddress("20 New Address");
        assertEquals("20 New Address", contact.getAddress(), "Address should be updated successfully");
    }

    // Test setting address longer than 30 characters
    @Test
    void testSetAddressTooLong() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("ThisAddressIsWayTooLongForTheProgram"),
                     "Setting address should throw exception if length is greater than 30");
    }

    // Test setting address to null
    @Test
    void testSetAddressNull() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null),
                     "Setting address should throw exception if it is null");
    }

    //Invalid value tests

    // Test creating a contact with one invalid field (firstName)
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("004", "TooLongFirstNameForTest", "Smith", "5555555555", "456 Oak Avenue"),
                     "Creating contact with too long first name should throw exception");
    }

    // Test creating a contact with one invalid field (lastName)
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("005", "Emma", "TooLongLastNameForTest", "5555555555", "789 Pine Road"),
                     "Creating contact with too long last name should throw exception");
    }

    // Test creating a contact with one invalid field (number)
    @Test
    void testInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("006", "Oliver", "Brown", "12345678", "101 Maple Lane"),
                     "Creating contact with invalid number should throw exception");
    }

    // Test creating a contact with one invalid field (address)
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("007", "Sophia", "Williams", "5555555555", "ThisAddressIsWayTooLongForThisTestCaseToHandleProperly"),
                     "Creating contact with too long address should throw exception");    
    }
 // Test setting special characters in firstName
    @Test
    void testSetSpecialCharactersFirstName() {
        Contact contact = createDefaultContact();
        contact.setFirstName("Alice@#%");
        assertEquals("Alice@#%", contact.getFirstName(), "First name with special characters should be set correctly");
    }

    // Test setting special characters in lastName
    @Test
    void testSetSpecialCharactersLastName() {
        Contact contact = createDefaultContact();
        contact.setLastName("Johnson!@#");
        assertEquals("Johnson!@#", contact.getLastName(), "Last name with special characters should be set correctly");
    }

    // Test setting special characters in number
    @Test
    void testSetSpecialCharactersNumber() {
        Contact contact = createDefaultContact();
        assertThrows(IllegalArgumentException.class, () -> contact.setNumber("1234!@#678"), 
                     "Setting number with special characters should throw exception");
    }

    // Test setting special characters in address
    @Test
    void testSetSpecialCharactersAddress() {
        Contact contact = createDefaultContact();
        contact.setAddress("123 Elm@# Street!");
        assertEquals("123 Elm@# Street!", contact.getAddress(), "Address with special characters should be set correctly");
    }
}
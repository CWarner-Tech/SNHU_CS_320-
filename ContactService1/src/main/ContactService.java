package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Store contacts using a HashMap where the key is the contactId
    private Map<String, Contact> contacts = new HashMap<>();
    
    // Add a new contact
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact with the same ID already exists
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }
    
    // Delete a contact by contactId
    public boolean deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact ID does not exist
        }
        contacts.remove(contactId);
        return true;
    }
    
    // Update the first name of a contact
    public boolean updateContactFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact ID does not exist
        }
        contact.setFirstName(firstName);
        return true;
    }
    
    // Update the last name of a contact
    public boolean updateContactLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact ID does not exist
        }
        contact.setLastName(lastName);
        return true;
    }
    
    // Update the phone number of a contact
    public boolean updateContactNumber(String contactId, String Number) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact ID does not exist
        }
        contact.setNumber(Number);
        return true;
    }
    
    // Update the address of a contact
    public boolean updateContactAddress(String contactId, String Address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid contactId."); // Contact ID does not exist
        }
        contact.setAddress(Address);
        return true;
    }
    
    // Retrieve a contact by its ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
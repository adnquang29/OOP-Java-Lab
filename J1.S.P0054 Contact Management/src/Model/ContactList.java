package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The ContactList class represents a list of contacts.
 * It extends the Contact class and contains methods to manage a list of contacts.
 */
public class ContactList extends Contact {

    List<Contact> list;

    /**
     * Constructs a new ContactList object with an empty list.
     */
    public ContactList() {
        list = new ArrayList<Contact>();
    }

    /**
     * Constructs a new ContactList object with the specified list of contacts.
     * @param list The list of contacts.
     * @param ID The ID of the contact.
     * @param fullname The full name of the contact.
     * @param firstname The first name of the contact.
     * @param lastname The last name of the contact.
     * @param group The group to which the contact belongs.
     * @param address The address of the contact.
     * @param phone The phone number of the contact.
     */
    public ContactList(List<Contact> list, int ID, String fullname, String firstname,
                       String lastname, String group, String address, String phone) {
        super(ID, fullname, firstname, lastname, group, address, phone);
        this.list = list;
    }
}

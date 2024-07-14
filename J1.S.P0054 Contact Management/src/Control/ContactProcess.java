package Control;

import Model.Contact;
import Validate.CheckDuplicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The ContactProcess class provides methods for managing contact operations such as adding, displaying, and deleting contacts.
 */
public class ContactProcess {

    /**
     * Adds a contact to the list of contacts.
     * @param list The list of contacts.
     * @param contact The contact to be added.
     * @return True if the contact is successfully added, false if the contact already exists in the list.
     */
    public boolean addContact(List<Contact> list, Contact contact) {
        boolean isDuplicate = CheckDuplicate.checkDuplicateAdd(list, contact);
        //When contact information exists in the list
        if (isDuplicate) {
            System.out.println(" Contact already exists");
            return false;
        } 
        //Add contact information to the list 
        else {
            int counter = 0;
            for (int i = 0; i < list.size(); i++) {
                Contact existingContact = list.get(i);
                //When ID of current contact is greater than the counter
                if (existingContact.getID() > counter) {
                    counter = existingContact.getID();
                }
            }
            //Set and increase new contact ID than the max existed contact ID
            contact.setID(counter + 1);
            list.add(contact);
            //Save the updated list to file
            saveToFile(list, "contact_data.txt");
            return true;
        }
    }

    /**
     * Displays all contacts in the list.
     * @param list The list of contacts to be displayed.
     */
    public void displayAll(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("\n Contact not found.");
        } else {
            System.out.println("\n --------------------------- Display all Contacts -------------------------\n");
            System.out.format(" %-4s %-14s %-10s %-10s %-6s %-13s %-13s\n",
                    "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            System.out.println(" --------------------------------------------------------------------------");
            //Use loop to display all contacts in the list
            for (int i = 0; i < list.size(); i++) {
                Contact contact = list.get(i);
                System.out.print(contact.toString());
            }
        }
    }

    /**
     * Deletes a contact from the list.
     * @param list The list of contacts.
     * @param contact The contact to be deleted.
     * @return True if the contact is successfully deleted, false if the contact is not found in the list.
     */
    public boolean deleteContact(List<Contact> list, Contact contact) {
        boolean deletionResult = list.remove(contact);
        //When contact not being deleted in the list
        if (!deletionResult) {
            for (int i = 0; i < list.size(); i++) {
                Contact c = list.get(i);
                if (c.getID() == contact.getID()) {
                    list.remove(c);
                    deletionResult = true;
                    break;
                }
            }
        }
        //Warning when the contact being deleted
        if (deletionResult) {
            saveToFile(list, "contact_data.txt");
            System.out.println(" Successful");
        } 
        //When contact not found from user's input
        else {
            System.out.println(" Contact not found");
        }
        return deletionResult;
    }

    /**
     * Saves the list of contacts to a file.
     * @param list The list of contacts.
     * @param filename The name of the file to which the contacts are saved.
     */
    public void saveToFile(List<Contact> list, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            //Use loop to write objects list of data to a file
            for (Contact contact : list) {
                //Fetching variables and formatting to be written
                writer.write(contact.getID() + "," + contact.getFullname() + "," +
                        contact.getFirstname() + "," + contact.getLastname() +
                        "," + contact.getGroup() + "," + contact.getAddress()
                        + "," + contact.getPhone() + "\n");
            }
        } 
        //Handling IOException if file writing fails
        catch (IOException e) {
        }
    }

    /**
     * Loads contacts from a file into the list.
     * @param list The list of contacts.
     * @param filename The name of the file from which contacts are loaded.
     */
    public void loadFromFile(List<Contact> list, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            //Use loop to read each line of data in file
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    //Extracting data to recreate objects
                    int ID = Integer.parseInt(data[0]);
                    String fullname = data[1];
                    String firstname = data[2];
                    String lastname = data[3];
                    String group = data[4];
                    String address = data[5];
                    String phone = data[6];
                    Contact contact = new Contact(ID, fullname, firstname, lastname, group, address, phone);
                    //Adding recreated objects to a record
                    list.add(contact);
                }
            }
        } 
        //Handling various exceptions that might occur during file reading
        catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
        }
    }
}

package View;

import Control.ContactProcess;
import Model.Contact;
import Validate.InputValidate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The ContactProgram class provides methods for managing contact-related operations in the user interface.
 */
public class ContactProgram {

    public static ContactProcess contact = new ContactProcess();
    public static Scanner sc = new Scanner(System.in);
    public static List<Contact> list = new ArrayList<Contact>();
    
    /**
     * Displays the main menu of the contact program.
     */
    public static void menu() {
        System.out.print("\n +");
        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("+");
            System.out.println(" |                            Contact program                             |");
            System.out.printf(" |%-72s|\n", " 1. Add a Contact");
            System.out.printf(" |%-72s|\n", " 2. Display all Contact");
            System.out.printf(" |%-72s|\n", " 3. Delete a Contact");
            System.out.printf(" |%-72s|\n", " 4. Exit");
        System.out.print(" +");
        for(int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("+");            
            System.out.print("\n Select an option: ");           
    }
    
    /**
     * Adds a contact to the contact list.
     * @param options The selected option.
     */
    public static void addContact(int options) { 
        System.out.println("\n -------- Add a Contact --------");        
        System.out.print(" Enter Name: ");
        String fullname = InputValidate.getInputString();        
        System.out.print(" Enter Group: ");
        String group = InputValidate.getInputString(); 
        System.out.print(" Enter Address: ");
        String address = InputValidate.getInputString(); 
        System.out.print(" Enter Phone: ");
        String phone = InputValidate.getInputPhone();
        
            String firstname = "", lastname = "";
            String[] parts = fullname.split("\\s");
            if(parts.length == 2) {
                firstname = parts[0];
                lastname = parts[1];
            }
        
        Contact C = new Contact();
        C.setFullname(fullname);
        C.setFirstname(firstname);
        C.setLastname(lastname);
        C.setGroup(group);
        C.setAddress(address);
        C.setPhone(phone);
        contact.addContact(list, C);
    }

    /**
     * Displays all contacts in the contact list.
     * @param options The selected option.
     */
    public static void displayAll(int options) {
        contact.displayAll(list);
    }

    /**
     * Deletes a contact from the contact list.
     * @param options The selected option.
     */
    public static void deleteContact(int options) {
        System.out.println("\n ------- Delete a Contact -------");
        System.out.print(" Enter ID: ");
        int ID = InputValidate.getInputInt();

        Contact deleteContact = new Contact(); 
        deleteContact.setID(ID);
        contact.deleteContact(list, deleteContact);
    }        
        
    /**
     * Exits the contact program.
     * @param options The selected option.
     */
    public static void exit(int options) {
        System.exit(0);
    }
    
    /**
     * Saves contact data to a file.
     * @param filename The name of the file to save the data to.
     */
    public static void saveDataToFile(String filename) {
        contact.saveToFile(list, filename);
    }
    
    /**
     * Loads contact data from a file.
     * @param filename The name of the file from which to load the data.
     */
    public static void loadDataFromFile(String filename) {
        contact.loadFromFile(list, filename);
    }    
}

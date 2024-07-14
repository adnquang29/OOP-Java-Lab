package Validate;

import Model.Contact;
import java.util.List;

/**
 * The CheckDuplicate class provides methods for checking duplicate contacts.
 */
public class CheckDuplicate {
    
    /**
     * Checks if a contact already exists in the list.
     * @param list The list of contacts to be checked.
     * @param contact The contact to be checked for duplication.
     * @return True if the contact already exists in the list, false otherwise.
     */
    public static boolean checkDuplicateAdd(List<Contact> list, Contact contact) {
        boolean isDuplicate = false;
        // Use loop to find the existed contact in the list
        for (int i = 0; i < list.size(); i++) {
            Contact duplicate = list.get(i);
            // When the input matches the contact in the list
            if (contact.getFullname().equals(duplicate.getFullname())) {
                isDuplicate = true;
                break;
            }
        }  
        return isDuplicate;
    }
}

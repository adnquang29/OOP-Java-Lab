package Model;

/**
 * The Contact class represents a contact with various attributes such as ID, name, group, address, and phone number.
 */
public class Contact {
    
    protected int ID;
    protected String fullname;
    protected String firstname;
    protected String lastname;
    protected String group;
    protected String address;
    protected String phone;

    public Contact() {
        ID = 0;
        fullname = "";
        firstname = "";
        lastname = "";
        group = "";
        address = "";
        phone = "";
    }

    public Contact(int ID, String fullname, String firstname, String lastname, String group, String address, String phone) {
        this.ID = ID;
        this.fullname = fullname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    } 
    
    /**
     * Returns a string representation of the contact.
     * @return A string containing the contact details.
     */
    @Override
    public String toString() {
        return String.format(" %-4d %-14s %-10s %-10s %-6s %-13s %-13s\n", 
                getID(), 
                getFullname(), 
                getFirstname(), 
                getLastname(), 
                getGroup(), 
                getAddress(), 
                getPhone());
    }
}

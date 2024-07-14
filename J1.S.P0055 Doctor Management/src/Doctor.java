
public class Doctor {
    String code;
    String name;
    String specialization;
    int availability;

    public Doctor() {
        code = "";
        name = "";
        specialization = "";
        availability = 0;
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return String.format(" %-7s %-20s %-15s %-12d\n",
                getCode(),
                getName(),
                getSpecialization(),
                getAvailability()
                );
    }
}

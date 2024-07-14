
import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DoctorList extends Doctor {
    
    ArrayList<Doctor> t;

    public DoctorList() {
        t = new ArrayList<Doctor>();
    }

    public DoctorList(ArrayList<Doctor> t, String code, String name, 
            String specialization, int availability) {
        super(code, name, specialization, availability);
        this.t = t;
    }
    
    public void addDoctor(Doctor doctor) {
        boolean isDuplicate = false;
        //Use loop to find the doctor in the list
        for(int i = 0; i < t.size(); i++) {
            Doctor duplicate = t.get(i);
            //When the input match the doctor in the list
            if(doctor.getCode().equals(duplicate.getCode())
               || doctor.getName().equals(duplicate.getName())) {
                isDuplicate = true;
                break;
            }
        }
        //When doctor information exists in the list
        if(isDuplicate) {
            System.out.println(" Doctor already exists");
        } 
        //Add doctor information to the list 
        else {
            t.add(doctor);
            System.out.println(" Doctor added successfully");
            //Save the updated list to file
            saveToFile("doctor_data.txt");            
        }
    }  
    
    public void updateDoctor(String code, String name, String specialization,
            int availability) {
        //Use loop to find the doctor in the list
        for(int i = 0; i < t.size(); i++) {
            Doctor updateDoctor = t.get(i);
            //When the input match the doctor in the list
            if(updateDoctor.getCode().equals(code)) {
                //Update the doctor information
                updateDoctor.setName(name);
                updateDoctor.setSpecialization(specialization);
                updateDoctor.setAvailability(availability);
                // Save the updated list to file
                saveToFile("doctor_data.txt");                  
                System.out.println(" Doctor updated successfully");
                return;
            }
        }   
        System.out.println(" Doctor not found");
    }
    
    public void deleteDoctor(String code) {
        //Use loop to find the doctor in the list
        for(int i = 0; i < t.size(); i++) {
            Doctor doctor = t.get(i);
            //When the input match the doctor in the list
            if(doctor.getCode().equals(code)) {
                t.remove(doctor); 
                // Save the updated list to file
                saveToFile("doctor_data.txt");                   
                System.out.println(" Doctor deleted successfully");
                return;                
            }
        }
        System.out.println(" Doctor not found");
    }
    
    public void searchDoctor(String text) {
        boolean found = false;
        String searchText = text.toLowerCase(); 
        //When doctor not existed in the list
//        if(t.isEmpty()) {
//            System.out.println("\n Doctor not found");
//        } else {
            //Use loop to find doctor in the list
            for(int i = 0; i < t.size(); i++) {
                Doctor doctor = t.get(i);
                    String code = doctor.getCode().toLowerCase();
                    String name = doctor.getName().toLowerCase();
                    String specialization = doctor.getSpecialization().toLowerCase(); 
                    String availability = String.valueOf(doctor.getAvailability()).toLowerCase(); 
                //When user type match the doctor information in the list
                if(code.contains(searchText)
                || name.contains(searchText)
                || specialization.contains(searchText)
                || availability.contains(searchText)) {
                    if(!found) {                        
                        System.out.format("\n %-7s %-20s %-15s %-12s\n",
                                "Code", "Name", "Specialization", "Availability");
                        System.out.println(" ---------------------------------------------------------");
                    }
                    System.out.print(doctor.toString());
                    found = true;
                }
            }
            //When doctor not existed in the list
            if(!found) {
                System.out.println("\n Doctor not found");
//            }
        }
    }   

    public static int getInputInt() {
        Scanner sc = new Scanner(System.in);
        //Use loop until user input value correctly
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } 
            //Require enter again when enter incorrect format
            catch(Exception e) {
                System.out.print(" Enter again: ");
            }
        }
    }

    public static String getInputCode() {
        Scanner sc = new Scanner(System.in);
        String input;
        //Use loop until user input value correctly
        while(true) {
            input = sc.nextLine().trim();
            //Require enter again when enter incorrect format
            if(input.isEmpty() || input.matches(".*[+\\-*/].*")) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    } 
    
    public static String getInputString() {
        Scanner sc = new Scanner(System.in);
        String input;
        //Use loop until user input value correctly
        while(true) {
            input = sc.nextLine().trim();
            //Require enter again when enter incorrect format
            if(input.isEmpty() || (input.matches(".*\\d+.*") || input.matches(".*[+\\-*/].*"))) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    } 

    public static String getInputSearch() {
        Scanner sc = new Scanner(System.in);
        String input;
        //Use loop until user input value correctly
        while(true) {
            input = sc.nextLine().trim();
            //Require enter again when enter incorrect format
            if(input.matches(".*[+\\-*/].*")) {
                System.out.print(" Enter again: ");
            } else {
                return input;
            }
        }
    }  

    //File IO
    public void saveToFile(String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            //Use loop to write objects list of data to a file
            for(Doctor doctor : t) {
                //Fetching variables and formatting to be written
                writer.write(doctor.getCode() + "," + doctor.getName() + "," +
                        doctor.getSpecialization() + "," + doctor.getAvailability() + "\n");
            }
            //System.out.println(" Data saved to \n " + filename);
        } 
        //Handling IOException if file writing fails
        catch(IOException e) {
            //System.out.println(" Error saving data to file: \n " + e.getMessage());
        }
    }    
    
    public void loadFromFile(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            //Use loop to read each line of data in file
            while((line = reader.readLine()) != null) {
                //Extracting data to recreate objects
                    String[] data = line.split(",");
                    String code = data[0];
                    String name = data[1];
                    String specialization = data[2];
                    int availability = Integer.parseInt(data[3]);
                Doctor doctor = new Doctor(code, name, specialization, availability);
                //Adding recreated objects to a record
                t.add(doctor);
            }
            //System.out.println(" Data loaded from \n " + filename);
        } 
        //Handling various exceptions that might occur during file reading
        catch(IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            //System.out.println(" Error loading data from file: \n " + e.getMessage());
        }
    }
}


import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

class DoctorManagement {
    
    public static DoctorList doctorList = new DoctorList();
    public static Scanner sc = new Scanner(System.in);    

    public static void menu() {
        System.out.print("\n +");
        for(int i = 0; i < 73; i++) {
            System.out.print("-");
        }
        System.out.println("+");
            System.out.println(" |                            Doctor Management                            |");
            System.out.printf(" |%-73s|\n", "  1. Add Doctor");
            System.out.printf(" |%-73s|\n", "  2. Update Doctor");
            System.out.printf(" |%-73s|\n", "  3. Delete Doctor");
            System.out.printf(" |%-73s|\n", "  4. Search Doctor");
            System.out.printf(" |%-73s|\n", "  5. Exit");
        System.out.print(" +");
        for(int i = 0; i < 73; i++) {
            System.out.print("-");
        }
        System.out.println("+");            
            System.out.print("\n Select an option: ");           
    }

    //Check user input number limit
    public static int input() {
        Scanner sc = new Scanner(System.in);
        //Use loop until user input correctly
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 5) {
                    throw new NumberFormatException();
                }
                return result;
            } 
            //When user not input correctly
            catch (NumberFormatException e) {
                System.out.println(" Please input number in rage [1, 5]");
                System.out.print(" Enter again: ");
            }
        }
    } 
    
    //1. Add Doctor
    static void addDoctor(int options) {
        System.out.println("\n --------- Add Doctor ----------");
        System.out.print(" Enter Code: ");
        String code = DoctorList.getInputCode();
        System.out.print(" Enter Name: ");
        String name = DoctorList.getInputString();
        System.out.print(" Enter Specialization: ");
        String specialization = DoctorList.getInputString();
        System.out.print(" Enter Availability: ");
        int availability = DoctorList.getInputInt();
        
        Doctor doctor = new Doctor();
        doctor.setCode(code);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        doctorList.addDoctor(doctor);
    }

    static void updateDoctor(int options) {
        System.out.println("\n --------- Update Doctor -------");
        System.out.print(" Enter Code: ");
        String code = DoctorList.getInputCode();
        System.out.print(" Enter Name: ");
        String name = DoctorList.getInputString();
        System.out.print(" Enter Specialization: ");
        String specialization = DoctorList.getInputString();
        System.out.print(" Enter Availability: ");
        int availability = DoctorList.getInputInt();
        doctorList.updateDoctor(code, name, specialization, availability);        
    }

    static void deleteDoctor(int options) {
        System.out.println("\n --------- Delete Doctor -------");
        System.out.print(" Enter Code: ");
        String code = DoctorList.getInputCode();
        doctorList.deleteDoctor(code);
    }

    static void searchDoctor(int options) {
        System.out.println("\n ---------- Search Doctor --------");
        System.out.print(" Enter text: ");
        String text = DoctorList.getInputSearch();
        System.out.println(" Result for '" + text + "':");
        doctorList.searchDoctor(text);
    }

    //5. Exit 
    public static void exit(int options) {
        System.exit(0);
    }  
    
    //File IO
    public static void saveDataToFile(String filename) {
        doctorList.saveToFile(filename);
    }
    public static void loadDataFromFile(String filename) {
        doctorList.loadFromFile(filename);
    }    
}

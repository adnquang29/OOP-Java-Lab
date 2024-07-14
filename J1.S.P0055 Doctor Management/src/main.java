
import java.util.Scanner;
public class main {
    
    public static void Menu() {
        //Use loop to select option multiple times
        while(true) {
            //Step 1. Display GUI
            DoctorManagement.menu();
            
            //Step 2. Input Data
            int options = DoctorManagement.input();
            
            //Step 3. Perform function based on the selected option
            switch(options) {
                //Add Doctor
                case 1: cls(); DoctorManagement.addDoctor(options);
                break;
                //Update Doctor
                case 2: cls(); DoctorManagement.updateDoctor(options);
                break;
                //Delete Doctor
                case 3: cls(); DoctorManagement.deleteDoctor(options);
                break;
                //Search Doctor
                case 4: cls(); DoctorManagement.searchDoctor(options);
                break;
                //Exit
                case 5: DoctorManagement.exit(options);
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\n Press 'Enter' key to continue . . .");
            sc.nextLine();            
            cls(); //Clear console                     
        }
    }
    
    public static void cls() { //Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }    
    
    public static void main(String[] args) {
        DoctorManagement.loadDataFromFile("doctor_data.txt");

        Menu();

        DoctorManagement.saveDataToFile("doctor_data.txt");
    }   
}

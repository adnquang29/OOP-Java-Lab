
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
    public static void display(ArrayList<CSV> list) throws Exception {
        while (true) {
            //Step 1. Display a menu
            FormatCSV.displayMenu();

            //Step 2. Ask users to select an option
            int options = FormatCSV.input();

            //Step 3. Perform function based on the selected option
            switch (options) {
                //Import CSV
                case 1: cls(); FormatCSV.importFile(); 
                    break;
                //Format Address
                case 2: cls(); FormatCSV.formatAddress(list);
                    break;
                //Format Name
                case 3: cls(); FormatCSV.formatName(list);
                    break;
                //Export CSV
                case 4: cls(); FormatCSV.exportFile();
                    break;
                //Exit
                case 5:
                    FormatCSV.exit(list);
                    break;
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
    
    public static void main(String[] args) throws Exception {
        ArrayList<CSV> list = new ArrayList<>();
        list.add(new CSV(2, "NGUyen hai         nAM   ", "namhai@gmail.com", "'0984481345", "ThaCH  HOA - thach that   -   Ha noI"));
        list.add(new CSV(3, "Nguyen   van a      	", "nuyenthao@gmail.com", "'0986246814", "Cau Giay     - Ha    Noi    - Viet Nam    "));
        display(list);
    }      
}
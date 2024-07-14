
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FormatCSV {
    
    public static Scanner sc = new Scanner(System.in);
    public static String COMMA_DELIMITER = ",";
    public static String NEW_LINE_SEPARATOR = "\n";    
    
    public static void displayMenu() {
        System.out.print("\n +");
        for(int i = 0; i < 73; i++) {
            System.out.print("-");
        }
        System.out.println("+");
            System.out.println(" |                            Format CSV Program                           |");                                 
            System.out.printf(" |%-73s|\n", "  1. Import CSV");
            System.out.printf(" |%-73s|\n", "  2. Format Address");
            System.out.printf(" |%-73s|\n", "  3. Format Name");
            System.out.printf(" |%-73s|\n", "  4. Export CSV");
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
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1 || result > 5) {
                    throw new NumberFormatException();
                }
                return result;
            } 
            //Handle exception when user not input correctly
            catch(NumberFormatException e) {
                System.out.println(" Please input number in rage [1, 5]");
                System.out.print(" Enter again: ");
            }
        }
    } 
 
    
    public static void importFile() throws Exception {
        System.out.println("\n ------------ Import CSV ------------");
        System.out.print(" Enter Path: ");
        String path = FormatCSV.sc.nextLine().trim();
        FormatCSV.importCSV(path);        
    }
    public static void importCSV(String path) throws Exception {
        ArrayList<CSV> list = new ArrayList<>();        
        String line = "";
        BufferedReader fileReader = null;
        System.out.print(" Enter Path: ");
        String fileName = sc.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            //Use loop to read each line of data in file
            while((line = fileReader.readLine()) != null) {
                String[] splitCSV = line.split(COMMA_DELIMITER);
                //Adding recreated objects to a record
                list.add(new CSV(Integer.parseInt(splitCSV[0]), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.out.println(" Import: Done");
        } 
        //Handle exception when file not existed
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } 
        //Handle exception when file cannot be readed
        catch(IOException e) {
            e.printStackTrace();
        } 
        //Handle exception when file can be readed
        finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //Print the list
        FormatCSV.print(list);
    }  
 
    
    public static void formatAddress(ArrayList<CSV> list) throws Exception {
    //public static void formatAddress(String dataCSV) throws Exception {
    //ArrayList<CSV> list = new ArrayList<>();
        System.out.println("\n ------------ Format Address ------------");
        //Use loop to find address from the dataCSV
        for(int i = 0; i < list.size(); i++) {
            String address = list.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            //Use loop to format the address string
            for(int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            list.get(i).setAddress(sb.toString().trim());
        }
        System.out.println(" Format: Done");
        //Print the list
        FormatCSV.print(list);
    }      

    
    public static String formatName(ArrayList<CSV> list) throws Exception {
    //public static String formatName(String dataCSV) throws Exception {
    //ArrayList<CSV> list = new ArrayList<>();
        System.out.println("\n ------------ Format Name ------------");
        //Use loop to find name from the dataCSV
        for(int i = 0; i < list.size(); i++) {
            String name = list.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();            
            //Use loop to format the name string
            for(int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            list.get(i).setName(sb.toString().trim());
        }
        System.out.println(" Format: Done");
        //Print the list
        FormatCSV.print(list);
        return null;
    }  

    
    public static void exportFile() throws Exception {
        System.out.println("\n ------------ Export File ------------");
        System.out.print(" Enter Path: ");
        String exportPath = FormatCSV.sc.nextLine().trim();
        FormatCSV.exportCSV(exportPath); 
    }   
    public static void exportCSV(String path) throws Exception {
        ArrayList<CSV> list = new ArrayList<>();        
        FileWriter fileWriter = null;
        System.out.print(" Enter Path: ");
        String fileName = sc.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            //Use loop to write objects list of data to a file
            for(CSV listCSV : list) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println(" Export Done!!!");
        } 
        //Handle exception when file cannot be written
        catch(IOException ex) {
            ex.printStackTrace();
        } 
        //Handle exception when file can be written
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    
    public static void exit(ArrayList<CSV> list) throws Exception {
        System.exit(0);
    }    

    
    public static void print(ArrayList<CSV> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.printf(" %d, %s, %s, %s, %s\n", list.get(i).getId(),
                    list.get(i).getName(), list.get(i).getEmail(), list.get(i).getPhone(),
                    list.get(i).getAddress());
        }
    } 
}

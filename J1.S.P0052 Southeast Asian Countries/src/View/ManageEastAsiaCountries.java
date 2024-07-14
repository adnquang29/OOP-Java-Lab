package View;

import Control.CountriesInfo;
import Model.EastAsiaCountries;
import Validate.InputValidate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ManageEastAsiaCountries class provides methods for managing operations related to East Asian countries.
 */
public class ManageEastAsiaCountries { 
    
    public static CountriesInfo country = new CountriesInfo();
    public static List<EastAsiaCountries> list = new ArrayList<EastAsiaCountries>();

    /**
     * Displays the menu options.
     */
    public static void menu() {
        System.out.println("\n\t\t\t\t   MENU");
        System.out.print("  ");
        for(int i = 0; i < 73; i++) {
            System.out.print("_");
        }       
        System.out.println();                                                             
        System.out.printf(" |%-73s|\n", " ");
        System.out.printf(" |%-73s|\n", " 1. Input the information of 11 countries in Southeast Asia");
        System.out.printf(" |%-73s|\n", " 2. Display the information of country you've just input");
        System.out.printf(" |%-73s|\n", " 3. Search the information of country by user-entered name");
        System.out.printf(" |%-73s|\n", " 4. Display the information of countries sorted name in ascending order");
        System.out.printf(" |%-73s|\n", " 5. Exit");                                                                
        System.out.print(" |");
        for(int i = 0; i < 73; i++) {
            System.out.print("_");
        }       
        System.out.println("|");
        System.out.print("\n Select an option: ");        
    } 
    
    /**
     * Adds information of countries.
     * @param options The user's choice.
     */
    public static void addCountryInformation(int options) {  
        System.out.print("\n Enter number of countries to add: ");
        int number = InputValidate.getInputInt();
        for(int i = 0; i < number; i++) {
            System.out.print("\n Enter code of country: ");
            String countryCode = InputValidate.getInputString();
            System.out.print(" Enter name of country: ");
            String countryName = InputValidate.getInputString();
            System.out.print(" Enter total Area: ");
            float totalArea = InputValidate.getInputFloat();
            System.out.print(" Enter terrain of country: ");
            String terrain = InputValidate.getInputString();

            EastAsiaCountries C = new EastAsiaCountries(countryCode, countryName, totalArea);
            country.setTerrain(terrain);
            country.addCountryInformation(list, C);
        }
    }
    
    /**
     * Displays the recently entered country information.
     * @param options The user's choice.
     */
    public static void getRecentlyEnteredInformation(int options) {
        country.getRecentlyEnteredInformation(list);
    }
    
    /**
     * Searches for country information by name.
     * @param options The user's choice.
     */
    public static void searchInformationByName(int options) { 
        System.out.print("\n Enter the name you want to search for: ");
        String countryName = InputValidate.getInputString();
        country.searchInformationByName(list, countryName);
    }
    
    /**
     * Sorts country information by name in ascending order and displays it.
     * @param options The user's choice.
     */
    public static void sortInformaionByAscendingOrder(int options) {
        country.sortInformationByAscendingOrder(list);
        country.displayAll(list); 
    }
    
    /**
     * Exits the program.
     * @param options The user's choice.
     */
    public static void exit(int options) {
        System.exit(0);
    }  
    
    /**
     * Clears the console.
     */
    public static void cls() { //Clear console
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
    }     
}

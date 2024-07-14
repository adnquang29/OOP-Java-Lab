package Control;

import Model.Country;
import Model.EastAsiaCountries;
import Validate.CheckDuplicate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * The CountriesInfo class provides methods for managing information about countries in East Asia.
 */
public class CountriesInfo extends Country {
    
    /**
     * Adds country information to the list of East Asia countries.
     * @param t The list of East Asia countries.
     * @param country The country information to be added.
     */
    public void addCountryInformation(List<EastAsiaCountries> t, EastAsiaCountries country) {
        boolean isDuplicate = CheckDuplicate.checkDuplicate(t, country);       
        //When country information exists in the list
        if(isDuplicate) {
            System.out.println(" Country already exists.");
        } 
        //When the list already have 11 countries
        else if(t.size() >= 11) {
            System.out.println(" Cannot input more than 11 countries.");
        } else {
            t.add(country);
        }       
    }     
    
    /**
     * Retrieves the most recently entered country information.
     * @param t The list of East Asia countries.
     * @return The most recently entered country information.
     */
    public EastAsiaCountries getRecentlyEnteredInformation(List<EastAsiaCountries> t)  {
        if(t.isEmpty()) {
            System.out.print("\n Country not found.");
        } else {
            System.out.format("\n %-10s %-15s %-15s %-15s", "ID", "Name", "Total Area", "Terrain");
            System.out.print("\n ----------------------------------------------------------");
            EastAsiaCountries C = t.get(t.size() - 1);
            System.out.format("\n %-10s %-15s %-15.1f %-15s", C.getCountryCode(), 
                    C.getCountryName(), C.getTotalArea(), getTerrain());
        }
        System.out.println();
        return null;        
    }  
    
    /**
     * Searches for country information by name.
     * @param t The list of East Asia countries.
     * @param name The name of the country to search for.
     * @return An array of East Asia countries matching the search criteria.
     */
    public EastAsiaCountries[] searchInformationByName(List<EastAsiaCountries> t, String name) {
        boolean found = false; 
        //When the country list is empty
        if(t.isEmpty()) {
            System.out.print("\n Country not found.");
        } else {
            //Use loop to find countries in the list corresponding to input character
            for(int i = 0; i < t.size(); i++) {
                EastAsiaCountries C = t.get(i);
                String countryName = C.getCountryName();
                if(countryName.contains(name)) {
                    if(!found) { 
                        System.out.format("\n %-10s %-15s %-15s %-15s", "ID", "Name", "Total Area", "Terrain");
                        System.out.print("\n ----------------------------------------------------------");
                    }
                    System.out.format("\n %-10s %-15s %-15.1f %-15s", C.getCountryCode(), 
                            C.getCountryName(), C.getTotalArea(), getTerrain());
                    found = true;
                }
            }
            if(!found) { 
                System.out.print("\n Country not found.");
            }
        }
        System.out.println();
        return null;
    }

    /**
     * Sorts country information in ascending order by country name.
     * @param t The list of East Asia countries.
     * @return An array of East Asia countries sorted in ascending order by country name.
     */
    public EastAsiaCountries[] sortInformationByAscendingOrder(List<EastAsiaCountries> t) {
        Collections.sort(t, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareTo(o2.getCountryName());
            }
        });
        return null;
    }    
    
    /**
     * Displays all country information.
     * @param t The list of East Asia countries.
     * @return An array of East Asia countries displayed.
     */
    public EastAsiaCountries[] displayAll(List<EastAsiaCountries> t) {
        //When the country list is empty
        if(t.isEmpty()) {
            System.out.print("\n Country not found.");
        } else {
            System.out.format("\n %-10s %-15s %-15s %-15s", "ID", "Name", "Total Area", "Terrain");
            System.out.print("\n ----------------------------------------------------------");
            //Use loop to display list of countries
            for(int i = 0; i < t.size(); i++) {
                EastAsiaCountries C = t.get(i);  
                System.out.format("\n %-10s %-15s %-15.1f %-15s", C.getCountryCode(), 
                        C.getCountryName(), C.getTotalArea(), getTerrain());
            }
        }
        System.out.println();
        return null;
    } 
}

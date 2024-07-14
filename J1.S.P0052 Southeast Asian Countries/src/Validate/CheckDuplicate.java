package Validate;

import Model.EastAsiaCountries;
import java.util.List;

/**
 * The CheckDuplicate class provides methods to check for duplicate entries in a list of East Asia countries.
 */
public class CheckDuplicate {
    
    /**
     * Checks for duplicate entries in the list of East Asia countries.
     * @param t The list of East Asia countries to check.
     * @param country The country to check for duplication.
     * @return True if the country is a duplicate, false otherwise.
     */
    public static boolean checkDuplicate(List<EastAsiaCountries> t, EastAsiaCountries country) {
        boolean isDuplicate = false;
        // Use loop to find country in the list
        for(int i = 0; i < t.size(); i++) {
            EastAsiaCountries duplicate = t.get(i);
            // When the input matches the country in the list
            if(country.getCountryCode().equals(duplicate.getCountryCode()) 
                    || country.getCountryName().equals(duplicate.getCountryName())) {
                isDuplicate = true; 
                break;
            }
        }  
        return isDuplicate;
    }
}

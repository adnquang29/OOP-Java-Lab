package Model;

import java.util.List;
import java.util.ArrayList;

/**
 * The Country class represents information about a country, including its country code, name, total area, and terrain.
 */
public class Country extends EastAsiaCountries {
    
    protected List<EastAsiaCountries> t; 
    protected String countryTerrain; 
    
    public Country() {
        t = new ArrayList<>();
    }    

    /**
     * Constructs a Country object with the specified attributes.
     * @param t The list of terrains.
     * @param countryCode The country code of the country.
     * @param countryName The name of the country.
     * @param totalArea The total area of the country.
     * @param countryTerrain The terrain of the country.
     */
    public Country(List<EastAsiaCountries> t, String countryCode, 
           String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.t = t;
        this.countryTerrain = countryTerrain;
    }
    
    /**
     * Gets the terrain of the country.
     * @return The country terrain.
     */
    public String getTerrain() {
        return countryTerrain;
    }

    /**
     * Sets the terrain of the country.
     * @param countryTerrain The terrain to set.
     */
    public void setTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }    

    /**
     * Returns a string representation of the Country object, including its terrain.
     * @return A string containing the country information and terrain.
     */
    @Override
    public String display() {
        return String.format(super.display() + " " + getTerrain());        
    }           
}

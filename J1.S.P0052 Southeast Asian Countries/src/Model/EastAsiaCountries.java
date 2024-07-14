package Model;

/**
 * The EastAsiaCountries class represents information about countries in East Asia, including their country code, name, and total area.
 */
public class EastAsiaCountries {
    
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public EastAsiaCountries() {
        countryCode = "";
        countryName = "";
        totalArea = 0;
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    
    /**
     * Returns a string representation of the EastAsianCountries object.
     * @return A string containing the country code, country name, and total area.
     */
    public String display() {
        return String.format("\n %-10s %-15s %-15.1f", 
                this.getCountryCode(), 
                this.getCountryName(), 
                this.getTotalArea());
    }    
}

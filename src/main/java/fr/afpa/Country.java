package fr.afpa;

public class Country {
    private String name;
    private String isoCode;

    public Country(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    // GETTERS & SETTERS

    // NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ISOCODE
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    // METHOD

    @Override
    public String toString() {
        return "Country [name = " + name + ", isoCode = " + isoCode + "]";
    }

}

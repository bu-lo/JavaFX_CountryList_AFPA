package fr.afpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    // METHODS

    @Override
    public String toString() {
        return name + " | " + isoCode ;
    }

    //FCT INSTANCIATION COUNTRIES LIST
    public static List<Country> getCountriesList() {
        ArrayList<Country> countries = new ArrayList<>();
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale obj = Locale.of("", countryCode);
            countries.add(new Country(obj.getDisplayCountry(), obj.getISO3Country()));
        }
        return countries;
    }

}

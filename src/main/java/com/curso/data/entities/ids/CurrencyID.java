package com.curso.data.entities.ids;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CurrencyID implements Serializable {
    private String name;
    private String countryName;

    public CurrencyID() {

    }
    public CurrencyID(String name, String countryName) {
        this.name = name;
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }
}

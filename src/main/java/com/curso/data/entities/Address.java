package com.curso.data.entities;
public class Address{
@jakarta.persistence.Column(name = "ADDRESS_LINE_1")
    private java.lang.String addressLine1;@jakarta.persistence.Column(name = "ADDRESS_LINE_2")
    private java.lang.String addressLine2;@jakarta.persistence.Column(name = "CITY")
    private java.lang.String city;@jakarta.persistence.Column(name = "STATE")
    private java.lang.String state;@jakarta.persistence.Column(name = "ZIP_CODE")
    private java.lang.String zipCode;public Address() {
}
}
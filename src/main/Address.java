package main;

import javax.persistence.*;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipCode;

    public Address() {
    }
}

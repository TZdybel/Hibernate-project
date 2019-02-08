package main;

import javax.persistence.Entity;

@Entity
public class Customer extends Company {
    private String discount;

    public Customer() {
    }

    public Customer(String companyName, String street, String city, String zipcode, String discount) {
        super(companyName, street, city, zipcode);
        this.discount = discount;
    }
}

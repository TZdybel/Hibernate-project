package main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Company {
    @Id
    private String companyName;
    private String street;
    private String city;
    private String zipcode;

    public Company() {
    }

    public Company(String companyName, String street, String city, String zipcode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }
}

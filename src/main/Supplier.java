package main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Suppliers")
public class Supplier extends Company {
    private String bankAccountNumber;

    @OneToMany
    @JoinColumn(name = "SupplierID")
    private Set<Product> suppliedProducts;

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city, String zipcode, String bankAccountNumber) {
        super(companyName, street, city, zipcode);
        this.bankAccountNumber = bankAccountNumber;
        suppliedProducts = new HashSet<>();
    }

    public void addToSuppliedProducts(Product product) {
        product.setSupplier(this);
    }

    public Set<Product> getSuppliedProducts() {
        return suppliedProducts;
    }
}
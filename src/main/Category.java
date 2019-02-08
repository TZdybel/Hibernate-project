package main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CategoryID;
    private String Name;

    @OneToMany
    @JoinColumn(name = "CategoryID")
    private Set<Product> products;

    public Category() {
    }

    public Category(String name) {
        Name = name;
        products = new HashSet<>();
    }

    public void addToProductSet(Product product) {
        products.add(product);
    }

    public Product getProduct(String Name) {
        Product p = null;
        for (Product prod: products) {
            if (prod.getProductName().equals(Name)) p = prod;
        }
        return p;
    }
}

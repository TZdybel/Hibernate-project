package main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceNumber;
    private int Quantity;

    @ManyToMany(mappedBy = "invoices", cascade = CascadeType.PERSIST)
    private Set<Product> products;

    public Invoice() {}

    public Invoice(int quantity) {
        products = new HashSet<>();
        Quantity = quantity;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.getInvoices().add(this);
    }

    public Set<Product> getProducts() {
        return products;
    }
}

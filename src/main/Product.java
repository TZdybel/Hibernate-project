package main;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
@SecondaryTable(name = "Addresses")
public class Product {
    @Id
    private String ProductName;
    private int UnitOnStock;

    @Column(table = "Addresses")
    private String street;
    @Column(table = "Addresses")
    private String city;
    @Column(table = "Addresses")
    private String zipCode;

//    @Embedded
//    private Address address;

    @ManyToOne
    @JoinColumn(name="SupplierID")
    private Supplier supplier;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Invoice> invoices = new HashSet<>();

    public Product() {
    }

    public Product(String productName, int unitOnStock) {
        ProductName = productName;
        UnitOnStock = unitOnStock;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        supplier.getSuppliedProducts().add(this);
    }

    public void addToInvoice(Invoice invoice) {
        invoices.add(invoice);
        invoice.getProducts().add(this);
    }

    public String getProductName() {
        return ProductName;
    }

    public int getUnitOnStock() {
        return UnitOnStock;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }
}
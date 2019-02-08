package main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

//        Invoice inv = new Invoice(50);
//        Product product = new Product("Ser biały", 100);
//        em.persist(inv);
//        inv.addProduct(product);

        etx.commit();
        em.close();
        emf.close();
    }
}

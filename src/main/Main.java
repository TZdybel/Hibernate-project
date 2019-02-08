//package main;
//
//import org.hibernate.*;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Scanner;
//
//public class Main {
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(String[] args) {
//        Session session = getSession();
//        Transaction tx = session.beginTransaction();
//
//        Product p1 = session.get(Product.class, "Banan");
//        Product p2 = session.get(Product.class, "Marchewka");
//        Product p3 = session.get(Product.class, "Chleb");
//        Product p4 = session.get(Product.class, "Paluszki");
//        Product p5 = session.get(Product.class, "Cytryna");
//        Invoice inv1 = new Invoice(50);
//        Invoice inv2 = new Invoice(10);
//        session.save(inv1);
//        session.save(inv2);
//        inv1.addProduct(p1);
//        inv1.addProduct(p2);
//        inv1.addProduct(p3);
//        inv2.addProduct(p4);
//        inv2.addProduct(p5);
//
//        tx.commit();
//        session.close();
//        ourSessionFactory.close();
//    }
//}
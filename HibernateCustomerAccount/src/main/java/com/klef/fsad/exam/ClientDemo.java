package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // I. INSERT RECORD
        CustomerAccount acc = new CustomerAccount(
                "Ravi Kumar",
                "Savings Account",
                new Date(),
                "Active",
                5000.0
        );

        session.save(acc);
        System.out.println("Record Inserted Successfully");

        tx.commit();

        // II. UPDATE RECORD
        Transaction tx2 = session.beginTransaction();

        CustomerAccount ca = session.get(CustomerAccount.class, acc.getId());

        if(ca != null)
        {
            ca.setName("Ravi Kumar Updated");
            ca.setStatus("Inactive");

            session.update(ca);

            System.out.println("Record Updated Successfully");
        }

        tx2.commit();

        session.close();
        factory.close();
    }
}
package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer_account")
public class CustomerAccount 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    private double balance;

    public CustomerAccount() {}

    public CustomerAccount(String name, String description, Date date, String status, double balance) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
        this.balance = balance;
    }

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
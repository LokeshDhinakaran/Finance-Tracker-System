package Models;

import java.util.UUID;

public class Account {
    private static final long serialVersionUId= 1L;
    private String accountName;
    private double balance;
    private UUID accountId;

    //Parameterized constructor
    public Account(String accountName, double balance) {
        this.accountId = UUID.randomUUID(); 
        this.accountName = accountName;
        this.balance = balance;
    }

    // Getters and Setters

    public UUID getAccountId() {
        return accountId;
    }
    
    public String getAccountName() {    
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }   

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}

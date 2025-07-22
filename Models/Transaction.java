package Models;


import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private UUID transactioId,cateogryId,accountid;
    private String description;
    private double amount;
    private LocalDate transactionDate;
    private String transactionName;

    // Constructor
    public Transaction(UUID transactioId, UUID cateogryId, String description, double amount        
, LocalDate transactionDate, String transactionName, UUID accountid) {
        this.transactioId = UUID.randomUUID();
        this.cateogryId = cateogryId;
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionName = transactionName;
        this.accountid = accountid;
    }   
    // Getters and Setters

    public UUID getTransactioId() {
        return transactioId;
    }
    
    public UUID getCateogryId() {
        return cateogryId;
    }
    public UUID getAccountid() {
        return accountid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getTransactionName() {
        return transactionName;
    }
    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactioId=" + transactioId +
                ", cateogryId=" + cateogryId +
                ", accountid=" + accountid +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionName='" + transactionName + '\'' +
                '}';
    }


}

package Models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Budget {
     private static final long serialVersionUId= 1L;
    private String budgetName;
    private UUID budgetId , cateogryId;
    private double budgetAmount;
    private double progressAmount;
    private String budgetDescription;
    private LocalDate starDate , endDate;
    private List<Transaction> transactions;

    // Parameterized constructor
    public Budget(String budgetName, UUID cateogryId, double budgetAmount, double progressAmount, String budgetDescription, LocalDate starDate, LocalDate endDate) {
        this.budgetId = UUID.randomUUID(); // Generate a unique ID for the budget
        this.budgetName = budgetName;
        this.cateogryId = cateogryId;
        this.budgetAmount = budgetAmount;
        this.progressAmount = progressAmount;
        this.budgetDescription = budgetDescription;
        this.starDate = starDate;
        this.endDate = endDate;
        this.transactions = new ArrayList<>(); // Initialize with null or an empty list if needed
    }

    // Getters and Setters
    public UUID getBudgetId() {
        return budgetId;
    }
    public String getBudgetName() {
        return budgetName;
    }
    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }
    public UUID getCateogryId() {
        return cateogryId;
    }
    
    public double getBudgetAmount() {
        return budgetAmount;
    }
    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }
    public double getProgressAmount() {
        return progressAmount;
    }
    public void setProgressAmount(double progressAmount) {
        this.progressAmount = progressAmount;
    }
    public String getBudgetDescription() {
        return budgetDescription;
    }
    public void setBudgetDescription(String budgetDescription) {
        this.budgetDescription = budgetDescription;
    }
    public LocalDate getStarDate() {
        return starDate;
    }
    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }   
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    @Override
    public String toString() {  
        return "Budget{" +
                "budgetId=" + budgetId +
                ", budgetName='" + budgetName + '\'' +
                ", cateogryId=" + cateogryId +
                ", budgetAmount=" + budgetAmount +
                ", progressAmount=" + progressAmount +
                ", budgetDescription='" + budgetDescription + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", transactions=" + transactions +
                '}';
    }
}

package Models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Models.Transaction;
import Models.Category;
import Models.Account;
import Models.enums.UserType;


public class User {
    private static final long serialVersionUId= 1L;

    private UUID id;
    private UserType usertype; // Assuming UserType is an enum defined in enums package
    private UserProfile profile;
    private List<Account> accounts;
    private List<Category> categories;
    private List<Transaction> transactions;
    private List<Budget> budgets;
    private Map<String,List<String>> categoryMap; // Map of category type to list of category names

    // Constructor

    public User(UserProfile userProfile , UserType type) {
        this.id = UUID.randomUUID();
        this.profile = userProfile;
        this.accounts = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.categoryMap = new HashMap<>();
        this.usertype = type; // Initialize usertype
    }       
    // Getters and Setters
    public UserType getUsertype() {
        return usertype;
    }
    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }
    

   public UUID getUserId() {
        return id;
    }
   

    public UserProfile getProfile() {
        return profile;
    }   

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }   
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Category> getCategories() {
        return categories;
    }   

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }   

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }
    public Map<String, List<String>> getCategoryMap() {
        return categoryMap;
    }
    public void setCategoryMap(Map<String, List<String>> categoryMap) {
        this.categoryMap = categoryMap;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profile=" + profile +
                ", accounts=" + accounts +
                ", categories=" + categories +
                ", transactions=" + transactions +
                ", budgets=" + budgets +
                ", categoryMap=" + categoryMap +
                '}'
                + ", usertype=" + usertype ;
    }
}
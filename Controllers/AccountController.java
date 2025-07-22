package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Models.Account;
import Models.User;
import static Controllers.UserController.currentUser;

public class AccountController {

    public static boolean addAccount(String accountName, double initialBalance) {
        if (currentUser != null) {
            Account newAccount = new Account(accountName, initialBalance);
            currentUser.getAccounts().add(newAccount);
            if (UserController.saveUsersDetails()) {
                System.out.println("Account added successfully!");
                return true;
            } else {
                System.out.println("Failed to save user details after adding account.");
                return false;
            }
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public static void viewAccounts() {
        if (currentUser != null) {
            if(currentUser.getAccounts().isEmpty()){
                System.out.println("no accounts found");
            }else{
                System.out.println("User Accounts: ");
                for( Account account : currentUser.getAccounts()){
                    System.out.println(account);
                }
            }
        }else{
            System.out.println("User not founnd");
        }
    }

    public static boolean editAccount(String accountName, String newAccountName, double newBalance) {
        if (currentUser != null) {
            List<Account> accounts = currentUser.getAccounts();
            for (Account account : accounts) {
                if (account.getAccountName().equals(accountName)) {
                    account.setAccountName(newAccountName);
                    account.setBalance(newBalance);
                    if (UserController.saveUsersDetails()) {
                        System.out.println("Account updated successfully!");
                        return true;
                    } else {
                        System.out.println("Failed to save user details after updating account.");
                        return false;
                    }
                }
            }
            System.out.println("Account not found.");
            return false;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }
     public static boolean deleteAccount(String accountName) {
        if (currentUser != null) {
            List<Account> accounts = currentUser.getAccounts();
            for (Account account : accounts) {
                if (account.getAccountName().equals(accountName)) {
                    accounts.remove(account);
                    if (UserController.saveUsersDetails()) {
                        System.out.println("Account deleted successfully!");
                        return true;
                    } else {
                        System.out.println("Failed to save user details after deleting account.");
                        return false;
                    }
                }
            }
            System.out.println("Account not found.");
            return false;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public static boolean transferFunds(String SourceName , String DestName , double amount){
        if(currentUser != null ){
            Account sourceAccountName = null;
            Account destinationAccountName = null;
            for(Account account : currentUser.getAccounts()){
                if(account.getAccountName().equals(SourceName)){
                    sourceAccountName = account;
                }
                else{
                    destinationAccountName = account;
                }

            }
            if(sourceAccountName == null || destinationAccountName == null){
                System.out.println("Source or destination account not found");
                return false;
            }
            if(sourceAccountName.getBalance() < amount){
                System.out.println("insufficeient amount for ttrasfer");
                return false;
            }

            sourceAccountName.setBalance(sourceAccountName.getBalance()-amount);
            destinationAccountName.setBalance(destinationAccountName.getBalance()+amount);
            
            if (UserController.saveUsersDetails()) {
                System.out.println("Funds transferred successfully!");
                return true;
            } else {
                System.out.println("Failed to save user details after transferring funds.");
                return false;
            }
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public static UUID getAccountId(String accountName) {
        if (currentUser != null) {
            for (Account account : currentUser.getAccounts()) {
                if (account.getAccountName().equals(accountName)) {
                    return account.getAccountId();
                }
            }
            System.out.println("Account not found.");
            return null;
        } else {
            System.out.println("User not found.");
            return null;
        }
    }   

}


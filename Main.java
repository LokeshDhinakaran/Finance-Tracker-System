import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;
import java.util.Locale.Category;

import Controllers.UserController;
import Models.Account;
import Models.Transaction;
import Models.enums.UserType;
import Menus.ProfileMenu;
import Menus.AccountMenu;
import Menus.CategoryMenu;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu(){
        System.out.print("Welcome to Budget management system");
        System.out.print("\n1.Create User Profile");
        System.out.print("\n2.Login to User Profile");
        System.out.print("\n3.Exit");

        int userOption = sc.nextInt();
        sc.nextLine();

        switch (userOption) {
            case 1 -> RegisterMenu();
            case 2 -> loginMenu();
            case 3 -> {
                System.out.println("Exitting thee system");
                return;
            }
        }

    }

    public static void RegisterMenu(){
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter your address: ");
        String address = sc.nextLine();
        System.out.print("\nEnter your phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("\nEnter your date of birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());
        System.out.print("\nEnter user type (ADMIN/REGULAR): ");
        String userTypeInput = sc.nextLine().toUpperCase();
        UserType userType;
        try {
            userType = UserType.valueOf(userTypeInput);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid admin type . Please enter Admin or regular");
            return;
        }
         UUID userId = UserController.createUserProfile(name, address, phoneNumber, dob, userType);
        if (userId != null) {
            System.out.println("User profile created successfully with ID: " + userId);
            if (userType == UserType.ADMIN) {
                // Show admin features if the user is an admin
                System.out.printf("\nWelcome, Admin - %s! You can manage users and budgets.", name);
                showAdminFeaturesMenu(userId);
            } else if (userType == UserType.REGULAR) {
                // Show regular user features
                System.out.printf("\nWelcome, User - %s! You can manage your budgets and transactions.", name);
                showUserFeaturesMenu(userId);
            }
        } else {
            System.out.println("Failed to create user profile.");
            return;
        }
    }
        
    

    public static void loginMenu(){
        System.out.print("\nEnter Your name: ");
        String userName = sc.nextLine();
        System.out.print("\nEnter Your Dob (yyyy-mm-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());
        System.out.print("\nEnter Your User Type (ADMIN/REGULAR): ");
        String UserInputType = sc.nextLine().toUpperCase();
       String userTypeInput = sc.nextLine().toUpperCase();
        UserType userType;
        try {
            userType = UserType.valueOf(userTypeInput);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid admin type . Please enter Admin or regular");
            return;
        }
        UUID userId = UserController.getUserIdByProfile(userName, dob, userType);
        if (userId != null) {
            System.out.println("User profile found with ID: " + userId);
            if (userType == UserType.ADMIN) {
                // Show admin features if the user is an admin
                System.out.printf("\nWelcome, Admin - %s! You can manage users and budgets.", userName);
                showAdminFeaturesMenu(userId);
            } else if (userType == UserType.REGULAR) {
                // Show regular user features
                System.out.printf("\nWelcome, User - %s! You can manage your budgets and transactions.", userName);
                showUserFeaturesMenu(userId);
            }
        } else {
            System.out.println("User profile not found.");
            return;
        }
    }

    public static void showAdminFeaturesMenu(UUID userId) {

    }

    public static void showUserFeaturesMenu(UUID userId){
        System.out.print("\nUser Features menu: ");
        while (true) {

            System.out.print("\n1.Mange Profiles");
            System.out.print("\n2.Mange Accounts");
            System.out.print("\n3. Manage Categories");
            System.out.print("\n4. Manage Transactions");
            
            int userOption = sc.nextInt();
                switch (userOption) {
                    case 1 -> ProfileMenu.menu(userId);
                    case 2 -> AccountMenu.menu(userId);
                    case 3 -> CategoryMenu.menu(userId);
                  
                    case 7 ->{
                        System.out.println("user logged out");
                        UserController.currentUser = null;
                    }
                }
        }

    }
}
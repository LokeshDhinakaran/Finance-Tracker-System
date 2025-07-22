package Menus;

import java.util.Scanner;
import java.util.UUID;
import java.util.Locale.Category;

import Controllers.AccountController;
import Controllers.CateogryController;
import Models.enums.CategoryType;

public class CategoryMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu(UUID userId) {
        System.out.print("\nCategory Management Menu:");
        while (true) {
            System.out.print("\n1. Add Category");
            System.out.print("\n2. View Categories");
            System.out.print("\n3. Edit Category");
            System.out.print("\n4. Delete Category");
            System.out.print("\n5. Back to Main Menu");
            int userOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (userOption) {
                case 1 -> {
                    System.out.print("\nEnter category name: ");
                    String categoryName = scanner.nextLine();
                    System.out.print("\nEnter category type (INCOME/EXPENSE): ");
                    String categoryTypeInput = scanner.nextLine().toUpperCase();
                    CategoryType categoryType;
                    try {
                        categoryType = CategoryType.valueOf(categoryTypeInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category type. Please enter INCOME or EXPENSE.");
                        continue;
                    }
                    System.out.print("\n is this a subcateogry (yse/no):");
                    String isSubCategory = scanner.nextLine().toLowerCase();
                    if(isSubCategory == "yes"){
                        System.out.print("\nEnter parrent Category name:");
                        String ParentCategory = scanner.nextLine();
                        CateogryController.addSubCategory(categoryType,categoryName,ParentCategory);
                        System.out.println("sub category added successfully");
                    }
                    else if (isSubCategory.equals("no")) {
                        CateogryController.addCategory(categoryType, categoryName);
                        System.out.println("Category added successfully: " + categoryName);
                    }
                }
                case 2 -> CateogryController.viewCategories();

                case 4 -> {
                    System.out.print("\nEnter a Category name to delete:");
                    String CategoryName = scanner.nextLine(); 
                    CateogryController.deleteCategory(CategoryName);
                }


            }
        }
    }
 }

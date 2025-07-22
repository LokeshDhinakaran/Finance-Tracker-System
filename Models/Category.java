package Models;
import Models.enums.CategoryType;
import java.util.UUID;

public class Category {
    private UUID categoryId;
    private CategoryType cateogryType;
    private String categoryName;
    private boolean isSubCategory;
    private String parentCategory; 

    // Parameterized constructor
    public Category(CategoryType cateogryType, String categoryName, boolean isSubCategory, String parentCategory) {
        this.categoryId = UUID.randomUUID(); // Generate a unique ID for the category
        this.cateogryType = cateogryType;
        this.categoryName = categoryName;
        this.isSubCategory = isSubCategory;
        this.parentCategory = parentCategory;
    }
    // Getters and Setters  
    public UUID getCategoryId() {
        return categoryId;
    }
    public CategoryType getCateogryType() {
        return cateogryType;
    }
    public void setCateogryType(CategoryType cateogryType) {
        this.cateogryType = cateogryType;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public boolean isSubCategory() {
        return isSubCategory;
    }

    public void setSubCategory(boolean subCategory) {
        isSubCategory = subCategory;
    }
    public String getParentCategory() {
        return parentCategory;
    }
    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }
    @Override
    public String toString() {
        return "Cateogry{" +
                "categoryId=" + categoryId +
                ", cateogryType=" + cateogryType +
                ", categoryName='" + categoryName + '\'' +
                ", isSubCategory=" + isSubCategory +
                ", parentCategory='" + parentCategory + '\'' +
                '}';
    }
}
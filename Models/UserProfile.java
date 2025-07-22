package Models;

import java.time.LocalDate;

public class UserProfile {
    private String name , address , phoneNumber;
    private LocalDate dob;

    // Constructor
    public UserProfile(String name, String address, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }
    // Getters and Setters  

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    // Method to display user profile information
    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }   
    
}

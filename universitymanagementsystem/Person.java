package universitymanagementsystem;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable{
//attributes
    private String name;
    private String fatherName;
    private String dateOfBirth;
    private String phoneNo;
    private String CNIC;
    private String email;
    private String gender;
    private String homeAddress;

//getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getCNIC() {
        return CNIC;
    }
    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }   

//toString method()
    @Override
    public String toString(){
        return  "Name :" + this.name+ "\n"+
                "Father Name :" + this.fatherName+"\n"+
                "Date of Birth :" + this.dateOfBirth+"\n"+
                "Phone Number :" + this.phoneNo+"\n"+
                "CNIC :" + this.CNIC+"\n"+
                "Email :" + this.email+"\n"+
                "Gender :" + this.gender+"\n"+
                "Home Address :" + this.homeAddress+"\n";
    }
}

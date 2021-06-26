package universitymanagementsystem;

import java.io.Serializable;
import java.util.Date;

public class Teacher extends Person implements Serializable{
//attributes
    private String employ_id;
    private String education;
    private String department;
    private String specialization;
    private String employmentRecord;
    private Date joinDate;

//getter and setter methods
    public String getEmploy_id() {
        return employ_id;
    }
    public void setEmploy_id(String employ_id) {
        this.employ_id = employ_id;
    }
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getEmploymentRecord() {
        return employmentRecord;
    }
    public void setEmploymentRecord(String employmentRecord) {
        this.employmentRecord = employmentRecord;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
//toString method
    @Override
    public String toString(){
        return  super.toString()+
                "Employee ID :" + this.employ_id+ "\n"+
                "Education :" + this.education+"\n"+
                "Department :" + this.department+"\n"+
                "Specialization :" + this.specialization+"\n"+
                "Employment Record :" + this.employmentRecord+"\n"+
                "Joining Date :" + this.joinDate+"\n";
    }
}

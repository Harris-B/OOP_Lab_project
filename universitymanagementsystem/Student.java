package universitymanagementsystem;

import java.io.Serializable;

public class Student extends Person implements Serializable{
//attributes
    private String rollNo;
    private String department;
    private String program;
    private String inter_Marks;
    private String NTS_Marks;
    private String year;
    private boolean gradesSet;
    private String[] subjects;
    private float[][] chrsandGrades;

//constructor    
    public Student() {
	gradesSet = false;
	subjects = new String[5];
	chrsandGrades = new float[5][2]; //creating a 2d array to store subjects
	subjects[0] = "Data Structures and Algorithms";
	subjects[1] = "Object Oriented Programming";
	subjects[2] = "Introduction to SE";
	subjects[3] = "Communication Skills";
	subjects[4] = "Pak Studies";
        
//setting grades for each subject
	chrsandGrades[0][0] = 4;
	chrsandGrades[1][0] = 4;
	chrsandGrades[2][0] = 4;
	chrsandGrades[3][0] = 3;
	chrsandGrades[4][0] = 3;
    }

//method to set grades
    public void setGrades(float s1, float s2, float s3, float s4, float s5) {
	gradesSet = true;
        //setting setgrade parameters to store grades from user
	chrsandGrades[0][1] = s1;
	chrsandGrades[1][1] = s2;
	chrsandGrades[2][1] = s2;
	chrsandGrades[3][1] = s3;
	chrsandGrades[4][1] = s4;
    }
    public String getGrades() {
	float CGPA = 0;
	String x= "";
	if(!gradesSet) return "Grades not set\n";
	for(int i = 0; i < 5; i++)  {
            x   += subjects[i] + ": " + chrsandGrades[i][1]+"\n";
            CGPA += chrsandGrades[i][0] *  chrsandGrades[i][1];
	}
         x += "CGPA = " + CGPA + "\n";
	return x;
	}

//setter and getter methodss
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getInter_Marks() {
        return inter_Marks;
    }
    public void setInter_Marks(String inter_Marks) {
        this.inter_Marks = inter_Marks;
    }
    public String getNTS_Marks() {
        return NTS_Marks;
    }
    public void setNTS_Marks(String NTS_Marks) {
        this.NTS_Marks = NTS_Marks;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

//toString method
    @Override
    public String toString(){
        return  super.toString()+
                "Admission Year:" + this.year+ "\n"+
                "Roll Number :" + this.rollNo+"\n"+
                "Department :" + this.department+"\n"+
                "Program :" + this.program+"\n"+
                "Intermediate Marks :" + this.inter_Marks+"\n"+
                "NTS Marks :" + this.NTS_Marks+"\n"+ getGrades();
    }
}

package universitymanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
//attributes    
    private final int noOfStudent;
    private final int noOfTeacher;
    private final ArrayList<Student> studentList;
    private final ArrayList<Teacher> TeacherList;
    private final Scanner scanner;
    private String type;
    private int sCount=0;   //to keep track of number of students
    private int tCount=0;   //to keep track of number of teachers
    private int counter=0;
//constructor
    public Manager(int noOfStudent, int noOfTeacher) {
        this.noOfStudent = noOfStudent;
        this.noOfTeacher = noOfTeacher;
        studentList = new ArrayList<>();
        TeacherList = new ArrayList<>();
        scanner = new Scanner(System.in);
        displaymenu();
    }
//toString method
    @Override
    public String toString(){
        String student ="";
        String teacher = "";
        for (int i=0;i<studentList.size();i++){
            student = student + "\n"+ studentList.get(i).toString();
        }
        for (int i=0;i<TeacherList.size();i++){
            teacher = teacher + "\n"+ TeacherList.get(i).toString();
        }
        return student+teacher;
    }
//method for displaying main menu    
    private void displaymenu(){
        while (true){
             System.out.println("Select your preffered option:"+"\n");
            System.out.println("1.  to Add New Student/Teacher.");
            System.out.println("2.  to Delete Student/Teacher.");
            System.out.println("3.  to update Student/Teacher Details.");
            System.out.println("4.  to read Student/Teacher Information from Files.");
            System.out.println("5.  to view Student/Teacher Records.");
            System.out.println("6.  to exit the program");
           
            String line = scanner.nextLine();
            int command = 0;
            try{
                command = Integer.parseInt(line);
            } catch(Exception e){
                 e.printStackTrace();
            }
            switch(command){
                //Add Either New Student / Teacher
                case 1:
                    System.out.println("Enter the type ( either 'Student' or 'Teacher' ):");
                    type = scanner.nextLine();
                    if (type.equalsIgnoreCase("Student")){
                        addStudent();  
                    }
                    else if (type.equalsIgnoreCase("Teacher")){
                        addTeacher();
                    }
                    break;
                //Delete Either New Student / Teacher
                case 2:
                    System.out.println("Enter the type ( either 'Student' or 'Teacher' ) :");
                    type = scanner.nextLine();
                    if (type.equalsIgnoreCase("Student")){
                        deleteStudent();
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        delFile(filename);     
                    }
                    else if (type.equalsIgnoreCase("Teacher")){
                        deleteTeacher();
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        delFile(filename);
                    }
                    break;
                //Delete Existing Either Student or Teacher Files and update their details 
                case 3:
                    System.out.println("Enter the type ( either 'Student' or 'Teacher' ):");
                    type = scanner.nextLine();
                    if (type.equalsIgnoreCase("Student")){
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        delFile(filename);
                        addStudent();
                    }
                    else if (type.equalsIgnoreCase("Teacher")){
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        delFile(filename);
                        addTeacher();
                    }
                    break;
                case 4:
                    System.out.println("Enter the type ( either 'Student' or 'Teacher' ) :");
                    type = scanner.nextLine();
                    if (type.equalsIgnoreCase("Student")){
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        readStudentFromFile(filename);
                    }
                    else if (type.equalsIgnoreCase("Teacher")){
                        System.out.println("Enter file name :");
                        String filename = scanner.nextLine();
                        readTeacherFromFile(filename);  
                    }
                    break;
                case 5:
                    System.out.println("Enter the type ( either 'Student' or 'Teacher' ) :");
                    type = scanner.nextLine();
                    if (type.equalsIgnoreCase("Student")){
                        displayStudentRecord();
                        saveStudentRecords();
                    }
                    else if (type.equalsIgnoreCase("Teacher")){
                        displayTeacherRecord();
                        saveTeacherRecords();
                    }
                    break;
                case 6:
                        exit(0);
                default:
                    System.out.println("Invalid option.");        
                }
            }
            
        }
//method for adding new students  
    private void addStudent(){
        if (studentList.size()==noOfStudent){
           System.out.println("Can't add more Students. Please increase your size.");
           return;
        }
        Student student = new Student();
        System.out.println("Enter Student's ID:");
        String line = scanner.nextLine();
        student.setRollNo(line);
        
        if (studentList.contains(student)){
            System.out.println("The Student is already present in the record.");
            return;
        }
        System.out.println("===Enter Student's Detailed Information===");
        System.out.println("Enter Student's Year of Admission:");
        line = scanner.nextLine();
        student.setYear(line);
        
        System.out.println("Enter Student's Name:");
        line = scanner.nextLine();
        student.setName(line);
        
        System.out.println("Enter Student's Father Name:");
        line = scanner.nextLine();
        student.setFatherName(line);
        
        System.out.println("Enter Student's Date of Birth: format (dd-mm-yy)");
        line = scanner.nextLine();
        student.setDateOfBirth(line);
        
        System.out.println("Enter Student's CNIC/B-Form Number: format (xxxxx-xxxxxxx-x)");
        line = scanner.nextLine();
        student.setCNIC(line);
        
        System.out.println("Enter Student's Phone Number: ");
        line = scanner.nextLine();
        student.setPhoneNo(line);
        
        System.out.println("Enter Student's Email Address:");
        line = scanner.nextLine();
        student.setEmail(line);
        
        System.out.println("Enter Student's Gender:");
        line = scanner.nextLine();
        student.setGender(line);
        
        System.out.println("Enter Student's Address:");
        line = scanner.nextLine();
        student.setHomeAddress(line);
        
        System.out.println("Enter Student's Department:");
        line = scanner.nextLine();
        student.setDepartment(line);
        
        System.out.println("Enter Student's Program:");
        line = scanner.nextLine();
        student.setProgram(line);
        
        System.out.println("Enter Students Intermediate Marks:");
        line = scanner.nextLine();
        student.setInter_Marks(line);
        
        System.out.println("Enter Student's NTS Marks:");
        line = scanner.nextLine();
        student.setNTS_Marks(line);
      
        
        System.out.println("Enter Student's Grades");
        System.out.print("DSA : ");
        float dsa = scanner.nextFloat();
        System.out.print("OOP : ");
        float oop= scanner.nextFloat();
        System.out.print("ISE : ");
        float ise = scanner.nextFloat();
        System.out.print("Communication : ");
        float cps = scanner.nextFloat();
        System.out.print("Pak Study : ");
        float ps = scanner.nextFloat();
        student.setGrades(dsa, oop, ise, cps, ps);
        
        //saving the file 
        try{
        File f = new File(student.getName()+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(student);
        oos.flush();
        oos.close();
        System.out.println("Data Saved successfully.\n");

        }catch( Exception e){
            e.printStackTrace();
        }
        
        studentList.add(student);//adding new student to the studentList
        System.out.println("New Student "+student.getName() + " added Successfully.\n");
 
    }
//method for adding new Teacher    
    private void addTeacher(){
        if (TeacherList.size()==noOfTeacher){
           System.out.println("Can't add more Teachers. Please increase your size.");
           return;
        }
        Teacher tea = new Teacher();
        System.out.println("Enter Teacher's Employee ID:");
        String line = scanner.nextLine();
        tea.setEmploy_id(line);
        
        if (TeacherList.contains(tea)){
            System.out.println("The Teacher is already present in the record.");
            return;
        }
        System.out.println("===Enter Teacher's Detailed Information===");
        System.out.println("Joining Date:");
        line = scanner.nextLine();
        
        System.out.println("Enter Teacher's Name:");
        line = scanner.nextLine();
        tea.setName(line);
        
        System.out.println("Enter Teacher's Father Name:");
        line = scanner.nextLine();
        tea.setFatherName(line);
        
        System.out.println("Enter Teacher's Date of Birth:");
        line = scanner.nextLine();
        tea.setDateOfBirth(line);
        
        System.out.println("Enter Teacher's CNIC Number:");
        line = scanner.nextLine();
        tea.setCNIC(line);
        
        System.out.println("Enter Teacher's Phone Number:");
        line = scanner.nextLine();
        tea.setPhoneNo(line);
        
        System.out.println("Enter Teacher's Email Address:");
        line = scanner.nextLine();
        tea.setEmail(line);
        
        System.out.println("Enter Teacher's Gender:");
        line = scanner.nextLine();
        tea.setGender(line);
        
        System.out.println("Enter Teacher's Address:");
        line = scanner.nextLine();
        tea.setHomeAddress(line);
        
        System.out.println("Enter Teacher's Department:");
        line = scanner.nextLine();
        tea.setDepartment(line);
        
        System.out.println("Enter Teacher's Education");
        line = scanner.nextLine();
        tea.setEducation(line);
        
        System.out.println("Enter Teacher's Specialization:");
        line = scanner.nextLine();
        tea.setSpecialization(line);
        
        System.out.println("Enter Teacher's Employment Record:");
        line = scanner.nextLine();
        tea.setEmploymentRecord(line);
        //saving new teacher
        try{    
        File f = new File(tea.getName()+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(tea);
        oos.flush();
        oos.close();
        System.out.println("Data Saved successfully.\n");

        }catch( Exception e){
            e.printStackTrace();
        }
        //saving teacher in teacherList
        TeacherList.add(tea);
        System.out.println("New Teacher "+tea.getName() + " added Successfully.\n");
    }
//method for deleting student    
    private void deleteStudent(){
        System.out.println("Enter Student's ID:");
        String line = scanner.nextLine();
        for (Student student : studentList){
            if (student.getRollNo().equals(line)){
                studentList.remove(student);
                System.out.println("Student: "+ student.getRollNo()+"\t"+student.getName()+"\t" + "removed successfully.");
                return;
            }
            System.out.println("No such Student is present in the record.");
        }
   
    }
//method for deleting teacher    
    private void deleteTeacher(){
        System.out.println("Enter Teacher's Employee ID:");
        String line = scanner.nextLine();
        for (Teacher tea : TeacherList){
            if (tea.getEmploy_id().equals(line)){
                studentList.remove(tea);
                System.out.println("Teacher: "+ tea.getEmploy_id()+"\t"+tea.getName()+"\t" +"removed successfully.");
                return;
            }
            System.out.println("No such Teacher is present in the record.");
        }
    }
//method for displaying student record   
    private void displayStudentRecord(){
        for (Student student : studentList){//for each student in student list
            System.out.println("===== STUDENT : "+sCount++ + " RECORD =====");
            System.out.println(student);
        }
    }
//method for displaying teacher record    
    private void displayTeacherRecord(){
        for (Teacher teach : TeacherList){
            System.out.println("===== TEACHER : "+tCount++ + " RECORD =====");
            //System.out.println(teach);
            System.out.println(teach.toString());
        }
    }
//method for reading from a file    
    private void readStudentFromFile(String filename){
        try{
           FileInputStream fin = new FileInputStream(filename);
           ObjectInputStream ois = new ObjectInputStream(fin);
           if (filename=="StudentRecord.txt"){
               for (int i=0;i<studentList.size();i++){
                    while(true){
                        String n = (String) ois.readObject();
                        System.out.println(n.toString());
                        System.out.println("successfully read.");
                    }
               }    
           }
           else{
           Student student = (Student) ois.readObject();
           System.out.println(student.toString());
           System.out.println("Successfully read from the file.\n");
           }
            
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
 //method for reading from a file     
    private void readTeacherFromFile(String filename){
        try{
           FileInputStream fin = new FileInputStream(filename);
           ObjectInputStream ois = new ObjectInputStream(fin);
           if (filename=="TeacherRecord.txt"){
               for (int i=0;i<TeacherList.size();i++){
                    while(true){            
                        String n = (String) ois.readObject();
                        System.out.println(n.toString());
                        System.out.println("successfully read.");
                    }
               }
           }
           else{
           Teacher teacher = (Teacher) ois.readObject();
           System.out.println(teacher.toString());
           System.out.println("Successfully read from the file.\n");
           }
           
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
 //method for deleting a file   
    private void delFile(String filename){
        File f = new File(filename);
        if (f.exists()){
            f.delete();
            System.out.println("File deleted Successfully."); 
        }
        else{
            System.out.println("Failed to delete the file");
        }
    }
//method for saving a record 
    private void saveStudentRecords(){
        try {
        File f = new File("StudentRecord.txt");

        f.createNewFile();
        boolean result = f.createNewFile();
        if (result==true){
            System.out.println(" New File Created.");
        }
        else{
            System.out.println(" File Already Existed.");
        }
        ObjectOutputStream oos= !f.exists() ?
        new ObjectOutputStream(new FileOutputStream(f)):
        new ObjectOutputStream(new FileOutputStream(f,true)){@Override public void writeStreamHeader(){}};
        for ( int i = 0; i<studentList.size() ; i++){
                oos.writeObject(studentList.get(i).toString());
        }
        oos.flush();
        oos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
//method for saving a record    
    private void saveTeacherRecords(){
        try {
        File f = new File("TeacherRecord.txt");

        f.createNewFile();
        boolean result = f.createNewFile();
        if (result==true){
            System.out.println(" New File Created.");
        }
        else{
            System.out.println(" File Already Existed.");
        }
        ObjectOutputStream oos= !f.exists() ?
        new ObjectOutputStream(new FileOutputStream(f)):
        new ObjectOutputStream(new FileOutputStream(f,true)){@Override public void writeStreamHeader(){}};
        for ( int i = 0; i<TeacherList.size() ; i++){
                oos.writeObject(TeacherList.get(i).toString());
        }
        oos.flush();
        oos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

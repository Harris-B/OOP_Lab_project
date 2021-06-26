package universitymanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        
        System.out.println("===== University Management System =====");
        System.out.println("");
        System.out.println("===== Comsats University Islamabad =====");
        System.out.println();        System.out.println();

        login l = new login();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Sign_In details");
        System.out.println("Username: ");
        String user = input.nextLine();
        l.setUsername(user);
        System.out.println("Password: ");
        String pass = input.nextLine();
        l.setPassword(pass);
        System.out.println("Press:\n '1' to sign Up\n '2' to continue with Sign In with entered credentials");
        int num = input.nextInt();
        
        if (num==1){
            l.saveToFile(l);    //to save new login credentials
        }
        
        else{
            try{
            File file = new File("login.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while(true){
            login n = (login) ois.readObject();
            System.out.println(n.toString());
            System.out.println("*Read successfully.");
                if (user.equals(n.getUsername())&& pass.equals(n.getPassword())){ //matches the user entered name and password with the saved ones
                    System.out.println("***login Successful***");
                    System.out.println("");
                    System.out.println("Welcome to the Portal");
                    Manager m = new Manager(10,10); // creating manager class with 10 students and 10 teachers
                }else{
                    System.out.println("Invalid Username/password. Try again");//in case user enters invalid credentials
                }
            }
            } catch ( Exception e){
                e.printStackTrace();
            }
        }

    }
    
}

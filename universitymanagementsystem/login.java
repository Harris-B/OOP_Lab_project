package universitymanagementsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class login implements Serializable{
//attributes
    private String username;
    private String password;

//GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  
//toString()method        
    public String toString(){
        return "\n";
    }
//method to save a login credentials file
    public void saveToFile( Object o){ //this methods creates and saves a new login file of username and password
        File f = new File("Login.txt");
        try{
        ObjectOutputStream oos =  !f.exists() ?
        new ObjectOutputStream(new FileOutputStream(f)):
        new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(o);
        oos.flush();
        oos.close();
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
   
}

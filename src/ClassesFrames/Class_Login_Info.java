package ClassesFrames;

import Exceptions.Exception_InvalidPassword;
import java.io.Serializable;

public class Class_Login_Info implements Serializable{
    private String username;
    private String password;

    public Class_Login_Info(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
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
    
    public void changePassword(String name,String pass) throws Exception_InvalidPassword{
    if(name.equals(username) && pass.equalsIgnoreCase(password)){
    username=name;
    password=pass;
    }else{
    throw new Exception_InvalidPassword();
    }
    }
    public static void main(String[] args) {
        Class_Login_Info in=new Class_Login_Info("admin","admin");
        Generic_Methods.writeObjectToFile(in, "Password.ser");
    }
}

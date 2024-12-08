import java.io.Serializable;
import java.util.Scanner;
public abstract class User implements Serializable {
   private  String userName;
   private  String password;
   private String dateOfBirth;

   public User(){}
   public User(String userName,String password, String dateOfbIrth){
    this.userName = userName;
    this.password = password;
    this.dateOfBirth = dateOfbIrth;
   }
   public String getUserName(){
    return userName;
   }
   public String getDateOfBirth(){
    return dateOfBirth;
   }
   public String getPassword(){
    return password;
   }
   public void setUserName(String userName){
    this.userName = userName;
   }
   public void setPassword(String password){
    this.password = password;
   }
   public void setDateOfBirth(String dateOfBirth){
    this.dateOfBirth = dateOfBirth;
   }

   public abstract void displayMenu();
   public abstract void displayProfile();
   public abstract boolean deleteAccount(Database database);
   public abstract void updateProfile(String field, String newValue);
   public abstract void signup(Scanner scanner , Database database);
   
}

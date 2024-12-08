import java.util.Scanner;
public class Admin extends User implements Authentication{
    private String role, workingHours;

    public Admin(){}

    public Admin(String userName,String password,String dateOfBirth,String role,String workingHours){
        super(userName,password,dateOfBirth);
        this.role = role;
        this.workingHours = workingHours;
    }
   
    public void setRole(String role){
        this.role = role;
    }
    public void setWorkingHours(String workingHours){
        this.workingHours = workingHours;
    }
    public String getRole(){
        return role;
    }
    public String getWorkingHours(){
        return workingHours;
    }
 
    public void displayCustomerInfo(User user){
        if(user instanceof Customer){
            System.out.println("Customer Name: "+user.getUserName());
        }else{
            System.out.println("No Customers Found");
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nAdmin Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. View Customers");
            System.out.println("4. Add Product");
            System.out.println("5. Manage a Product");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
    
    }

    @Override
    public void displayProfile() {
     System.out.println("Admin Profile");
     System.out.println("UserName: "+getUserName());
     System.out.println("Date Of Birth: "+getDateOfBirth());
     System.out.println("Role: "+getRole());
     System.out.println("Working Hours: " +getWorkingHours());
    }
    @Override
    public void login(String userName, String password,Database database) {
        if(database.checkUser(userName,password)){
            System.out.println("Login Successful");
            System.out.println("Welcome "+userName);
            System.out.println("You are logged in as an Admin");
            System.out.println("You can now access the admin menu");
            displayMenu();
        }
        else{
           System.out.println("Invalid Credentials");
        }
    }

    
    @Override
    public boolean deleteAccount(Database database) {
        return database.removeUser(getUserName());
    }
    @Override
    public void updateProfile(String field, String newValue) {
        switch (field) {
            case "username" -> setUserName(newValue);
            case "date of birth" -> setDateOfBirth(newValue);
            case "role" -> setRole(newValue);
            case "working hours" -> setWorkingHours(newValue);
            default -> System.out.println("Invalid field");
        
        }
    }




    @Override
    public void logout() {
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }
    @Override
    public void signup(Scanner scanner, Database database) {
        System.out.println("Enter your username: ");
        String Uname = scanner.nextLine().trim();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine().trim();
        System.out.println("Enter your date of birth (DD-MM-YYYY): ");
        String dob = scanner.nextLine().trim();
        System.out.println("Enter your role: ");
        String Role = scanner.nextLine().trim();
        System.out.println("Enter your working hours: ");
        String WH = scanner.nextLine().trim();
        
        Admin newAdmin= new Admin(Uname,pass,dob,Role,WH);
        database.addUser(newAdmin);

    }
}

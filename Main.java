import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!startProgram(scanner)) break;

            String userType = getUserType(scanner);
            handleUserLoginOrSignup(scanner, userType, database);
        }
    }

    private static boolean startProgram(Scanner scanner) {
        System.out.println("Start Program (yes or no):");
        String start = scanner.nextLine().trim().toLowerCase();
        while (!start.equals("no") && !start.equals("yes")) {
            System.out.println("Invalid input. Please enter yes or no");
            start = scanner.nextLine().trim().toLowerCase();
        }
        return start.equals("yes");
    }

    private static String getUserType(Scanner scanner) {
        String choice;
        do {
            System.out.println("Admin or Customer (A for Admin or C for Customer): ");
            choice = scanner.nextLine().trim().toUpperCase();
            if (!choice.equals("A") && !choice.equals("C")) {
                System.out.println("Invalid input. Please enter A or C.");
            }
        } while (!choice.equals("A") && !choice.equals("C"));
        return choice;
    }

    private static void handleUserLoginOrSignup(Scanner scanner, String userType, Database database) {
        System.out.println("Log-In/Sign-Up");
        String action = getAction(scanner);

        if (action.equals("login")) {
            loginUser(scanner, userType, database);
        } else if (action.equals("signup")) {
            signupUser(scanner, userType, database);
        }
    }

    private static String getAction(Scanner scanner) {
        String action;
        do {
            action = scanner.nextLine().trim().toLowerCase();
            if (!action.equals("login") && !action.equals("signup")) {
                System.out.println("Invalid input. Please enter login or signup.");
            }
        } while (!action.equals("login") && !action.equals("signup"));
        return action;
    }

    private static void loginUser(Scanner scanner, String userType, Database database) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.println("Enter password: ");
        String password = scanner.nextLine().trim();

        if (userType.equals("A")) {
            Admin admin = (Admin) database.getUserByUsername(username);
            if (admin != null && admin.getPassword().equals(password)) {
                System.out.println("Admin login successful!");
                handleAdminMenu(scanner, admin);
            } else {
                System.out.println("Invalid credentials for Admin.");
            }
        } else if (userType.equals("C")) {
            Customer customer = (Customer) database.getUserByUsername(username);
            if (customer != null && customer.getPassword().equals(password)) {
                System.out.println("Customer login successful!");
                handleCustomerMenu(scanner, customer);
            } else {
                System.out.println("Invalid credentials for Customer.");
            }
        }
    }

    private static void signupUser(Scanner scanner, String userType, Database database) {
        if (userType.equals("A")) {
            Admin admin = new Admin();
            admin.signup(scanner, database);
            database.addUser(admin);
        } else if (userType.equals("C")) {
            Customer customer = new Customer();
            customer.signup(scanner, database);
            database.addUser(customer);
        }
    }

    private static void handleAdminMenu(Scanner scanner, Admin admin) {
        while (true) {
            if (admin == null) {
                System.out.println("Admin not found.");
                return;
            }
            admin.displayMenu();
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    admin.displayProfile();
                    break;
                case 2:
                   String field =scanner.nextLine().trim().toLowerCase();
                   String newValue = scanner.nextLine().trim();
                    admin.updateProfile(field, newValue);
                    break;
                case 3:
                    admin.displayCustomerInfo(admin);
                    break;
                case 4:
                    //Add product
                    break;
                case 5:
                    //Manage Product
                    break;
                case 6:
                //Log-out
                break;
                case 7:
                System.out.println("Exiting....");
                System.exit(7);    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    private static void handleCustomerMenu(Scanner scanner, Customer customer) {
        while (true) {
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }
            customer.displayMenu();
            
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    customer.displayProfile();
                    break;
                case 2:
                    System.out.println("Managing Cart...");
                    // Implement cart management logic
                    break;
                case 3:
                    System.out.println("Proceeding to Checkout...");
                    // Implement checkout logic
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

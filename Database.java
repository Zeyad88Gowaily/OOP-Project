import java.io.*;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users;
    private ArrayList<Products> products;

    private static final String USERS_FILE = "users.dat";
    private static final String PRODUCTS_FILE = "products.dat";

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Database() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        loadUsers();
        loadProducts();
    }

   

    // Load products from the file
    @SuppressWarnings("unchecked")
    public void loadProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTS_FILE))) {
            products = (ArrayList<Products>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing product data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public boolean removeUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                users.remove(user);
                saveUsers();
                System.out.println("User '" + username + "' has been deleted from the database.");
                return true;
            }
        }
        System.out.println("User '" + username + "' not found.");
        return false;
    }

    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
            System.out.println("Users have been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
    
    public void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (ArrayList<User>) ois.readObject();
            System.out.println("Users have been loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing user data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
    

    public void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    
    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void addProduct(Products product) {
        products.add(product);
        saveProducts();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user != null && user.getUserName() != null && user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }
    

  // Get a product by ID (int)
public Products getProductById(int id) {
    for (Products product : products) {
        if (product.getId() == id) { // Compare using '==' since id is an int
            return product;
        }
    }
    return null;
}

public boolean checkUser(String username, String password) {
    for (User user : users) {
        if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
            return true;
        }   
    }
        return false;
}

}

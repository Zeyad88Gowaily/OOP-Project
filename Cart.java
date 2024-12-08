public class Cart {
    private static int maxCartSize = 8;  // Default max size of the cart
    private Products[] cartItems;        // Array to hold products
    private int cartIndex;               // Index for adding new products
    private Customer customer;           // Reference to the associated customer

    // Default constructor initializes an empty cart with a max size
    public Cart() {
        this.cartItems = new Products[maxCartSize];
        this.cartIndex = 0;  // Start with an empty cart
    }

    // Constructor with customer and maxCartSize, allows flexibility
    public Cart(Customer customer, int maxCartSize) {
        this.customer = customer;
        this.cartItems = new Products[maxCartSize];
        this.cartIndex = 0;
    }

    // Add a product to the cart with exception handling for cart overflow
    public void addProductToCart(Products product) throws AllExceptionsMade.CartFullException {
        if (cartIndex >= cartItems.length) {
            throw new AllExceptionsMade.CartFullException("Cart is full. Can't add more products.");
        }
        cartItems[cartIndex++] = product;
    }

    // Remove a product from the cart with exception handling for product not found
    public void removeProductFromCart(Products product) throws AllExceptionsMade.ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < cartIndex; i++) {
            if (cartItems[i].equals(product)) {
                for (int j = i; j < cartIndex - 1; j++) {
                    cartItems[j] = cartItems[j + 1];  // Shift products to fill the gap
                }
                cartItems[--cartIndex] = null;  // Nullify the last item after shifting
                found = true;
                break;
            }
        }
        if (!found) {
            throw new AllExceptionsMade.ProductNotFoundException("Product not found in the cart.");
        }
    }

    // View the products in the cart
    public void viewCart() {
        System.out.println("Cart items for " + customer.getUserName() + ":");
        if (cartIndex == 0) {
            System.out.println("No items in the cart.");
        } else {
            for (int i = 0; i < cartIndex; i++) {
                System.out.println(cartItems[i]);  // Ensure Products class has a meaningful toString() method
            }
        }
    }

    // Calculate the total price of the cart
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cartIndex; i++) {
            total += cartItems[i].getPrice();  // Assuming Products has a getPrice() method
        }
        return total;
    }

    // Getter for cartItems (in case you need to access the array directly)
    public Products[] getCartItems() {
        return cartItems;
    }

    // Getter for the cart index (useful for debugging or limits checking)
    public int getCartIndex() {
        return cartIndex;
    }

    // Setter for cartIndex if needed for resetting or clearing the cart
    public void setCartIndex(int cartIndex) {
        this.cartIndex = cartIndex;
    }

    // Getter for maxCartSize (in case you want to change the size dynamically)
    public static int getMaxCartSize() {
        return maxCartSize;
    }

    // Setter for maxCartSize if you want to change the max cart size dynamically
    public static void setMaxCartSize(int maxCartSize) {
        Cart.maxCartSize = maxCartSize;
    }
}

import java.util.Date;
public class Order
{
    private static int orderCount=0;
    private int orderId;
    private Date orderDate;
    private  Products[] orderItems;
    private String paymentMethod;
    private String status;

    public Order(){}  //no arg constructor

    public Order(Products[] orderItems, String paymentMethod) throws AllExceptionsMade.EmptyOrderException  //constructor with exception handling
    {
        if (orderItems == null || orderItems.length == 0)
        {
            throw new AllExceptionsMade.EmptyOrderException("Order must contain at least one product.");
        }
        this.orderId = ++orderCount;
        this.orderDate = new Date();
        this.orderItems = orderItems;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
    }

    public void createOrder() 
    {
        System.out.println("Order " + orderId + " created on " + orderDate);
        for (int i = 0; i < orderItems.length; i++)
        {
            if (orderItems[i] != null)
            {
                System.out.println(orderItems[i]);
            } 
        }
    }

    public void processPayment() throws AllExceptionsMade.PaymentException 
    {
        if (status.equals("Paid"))
        {
            throw new AllExceptionsMade.PaymentException("Payment has already been processed for this order.");
        }
        System.out.println("Processing payment via " + paymentMethod + "...");
        this.status = "Paid";
    }

    public void updateOrderStatus(String status) 
    {
        this.status = status;
    }

    public void viewOrder()
    {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        for (int i = 0; i < orderItems.length; i++) 
        {
            if (orderItems[i] != null)
            {
                System.out.println(orderItems[i]);
            }   
        }
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Order Status: " + status);
    }

}
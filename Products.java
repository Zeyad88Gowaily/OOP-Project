import java.util.HashSet;
import java.util.Random;

public class Products
{
    private String name;
    private double price;
    private String category;
    private int id;


    public Products(){} 
  
    // To track already generated IDs
    private static HashSet<Integer> usedIds = new HashSet<>();

    public Products(String name,double price,String category,int id)  
    {
       this.category=category;
       this.price=price;
       this.name=name;
       this.id=id;

    }

    public void setId(int id){
        if(!usedIds.contains(id)){
            this.id=id;
            usedIds.add(id);
        }
    }

    public int getId(){
        return id;
    }
 
    public String getName()  
    {
        return name;
    }

    public void setName(String name)
    {
        if(name==null ||name.isEmpty())
        {
            throw new IllegalArgumentException("Product name can't be empty.");
        }
        else
        {
            this.name=name;
        }
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price)  
    {
        if(price<0)
        {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        else
        {
            this.price=price;
        }
    } 

    public String getCategory() {
        return category;
    }

    public void setCategory(String category)
    {
        if(category==null || category.isEmpty())
        {
            throw new IllegalArgumentException("Product category cannot be empty");

        }
        this.category=category;
    }

    @Override
    public String toString()
    {
        return name + " (" + category + ") - $" + price;
    }

    private static int generateUniqueId() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(10000); // Generate an ID between 0 and 9999
        } while (usedIds.contains(id)); // Ensure uniqueness
        usedIds.add(id); // Add to the set of used IDs
        return id;
    }

}
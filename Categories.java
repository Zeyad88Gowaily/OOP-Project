import java.util.ArrayList;
import java.util.List;

public class Categories {
    private String name;
    private List<Products> products;

    public Categories(String name){
        this.name = name;
        this.products = new ArrayList<>();
    }
    public void addProduct(Products product){
        products.add(product);// add a product to this category
    }
    public String getName(){
        return name;
    }
    
}

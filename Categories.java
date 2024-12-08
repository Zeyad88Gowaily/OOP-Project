

import java.util.ArrayList;


public class Categories{
 private int id;
 private String name;

    public Categories() {
    }

    public Categories(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "\n" + "id number: " + id +   " ,   Category Type is: " + name ;
    }
    private static ArrayList<Categories>categories=new ArrayList<>();
    static{
        categories.add(new Categories(1, "Electronics"));
        categories.add(new Categories(2, "Clothing"));
        categories.add(new Categories(3, "Home Appliances"));
        categories.add(new Categories(4, "Books"));
}
    public void addCategory(Categories category)
    {
        categories.add(category);
    }
    public void deleteCategory(int id,String name)
    {
       for(int i=0;i<categories.size();i++)
       {
           if(categories.get(i).getId()==id && categories.get(i).getName().equals(name))
           {
               categories.remove(i);
               break;
           }
       }
    }
    public  Categories readCategory(int id,String name)throws AllExceptionsMade.CategoryNotFound
            
    {
        
    for(int i=0;i<categories.size();i++) {
        if (categories.get(i).getId()==id && categories.get(i).getName().equals(name)) {
            return categories.get(i);  
        }
        
            
    }
    throw new AllExceptionsMade.CategoryNotFound("Category with the id "+id+"and name"+name +"Not Found");
    }
  public void updateCategory(int id, String newName) {
        for(int i=0;i<categories.size();i++) {
            if (categories.get(i).getId() == id) {
                categories.get(i).setName(newName);
                break;
            }
        }
    }
     public void printCategories() throws NullPointerException {
        for(int i=0;i<categories.size();i++) {
            System.out.println(categories.get(i));
        }
    }
    
    
    
}

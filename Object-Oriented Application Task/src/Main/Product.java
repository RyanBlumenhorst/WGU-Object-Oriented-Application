package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**This class is used to add products and their associated parts to the inventory.*/
public class Product {

    //Variables
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**Constructor
     * @param id ID for product.
     * @param name Name of product.
     * @param price Price of product.
     * @param stock Stock of product.
     * @param min Minimum stock for that product.
     * @param max Maximum Stock for that product.
     * */
    public Product(int id, String name, double price, int stock, int min, int max){
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
    }

    //Methods
    /**
     * @param id Sets product ID.
     * */
    public void setId(int id){
        this.id = id;
    }

    /**
     * @param price Sets product price.
     * */

    public void setPrice(double price){
        this.price = price;
    }

    /**
     * @param stock Sets the stock of a product.
     * */

    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * @param name Sets the name of a product.
     * */

    public void setName(String name){
        this.name = name;
    }

    /**
     * @param min Sets the minimum stock for a product.
     * */

    public void setMin(int min){
        this.min = min;
    }

    /**
     * @param max Sets the maximum stock for a product.
     **/

    public void setMax(int max){
        this.max = max;
    }

    //Getters
    /**
     * @return id
     * */

    public int getId(){
        return id;
    }

    /**
     * @return name
     * */

    public String getName(){
        return name;
    }

    /**
     * @return price
     * */

    public double getPrice(){
        return price;
    }

    /**
     * @return stock
     * */

    public int getStock(){
        return stock;
    }

    /**
     * @return min
     * */

    public int getMin(){
        return min;
    }

    /**
     * @return max
     * */

    public int getMax(){
        return max;
    }

    /**
     * Used to add associated parts to a product to create a part list.
     * @param part Part to add
     * */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     * Used to remove an associated part from a product.
     * @param selectedAssociatedPart Part to remove.
     * */
    public void deleteAssociatedPart(Part selectedAssociatedPart){
        associatedParts.remove(selectedAssociatedPart);
    }

    /**
     * @return associatedParts
     * */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }

}

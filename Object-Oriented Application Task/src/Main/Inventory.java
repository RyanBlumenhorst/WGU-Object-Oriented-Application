package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**This class is used to keep track of all of the items in the inventory. Lists all parts and all products.*/
public class Inventory {

    //Private Lists
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //Public Functions

    /**
     * Used to add parts to the inventory list.
     * @param newPart Part to add to the list.
     * */
    public static void addPart(Part newPart){
        if(newPart != null){
            allParts.add(newPart);
        }
    }

    /**
     * Used to add products to the inventory list.
     * @param newProduct Product to add to the list.
     * */
    public static void addProduct(Product newProduct){
        if(newProduct != null){
            allProducts.add(newProduct);
        }
    }

    /**
     * Used to lookup parts by their ID.
     * @param partID ID of part to search for.
     * @return ObservableList
     * */
    public static ObservableList<Part> lookupPartID(int partID){
        ObservableList<Part> partList = FXCollections.observableArrayList();
        if(!allParts.isEmpty()){
            for(int i = 0; i < allParts.size(); i++){
                if(allParts.get(i).getId() == partID){
                    partList.add(allParts.get(i));
                }
            }
            return partList;
        }
        return null;
    }

    /**
     * Used to lookup products by their ID.
     * @param productID ID of product to search for.
     * @return Product
     * */
    public static ObservableList<Product> lookupProductID(int productID){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        if(!allProducts.isEmpty()){
            for(int i = 0; i < allProducts.size(); i++){
                if(allProducts.get(i).getId() == productID){
                    productList.add(allProducts.get(i));
                }
            }
            return productList;
        }
        return null;
    }

    /**
     * Used to lookup parts by name.
     * @param partName Name of part to search for.
     * @return Part List
     * */
    public static ObservableList<Part> lookupPartName(String partName){
        ObservableList<Part> partList = FXCollections.observableArrayList();
        partName = partName.toLowerCase();

        if(!allParts.isEmpty()){
            for(int i = 0; i < allParts.size(); i++){
                String lowerPart = allParts.get(i).getName().toLowerCase();
                if(lowerPart.contains(partName)){
                    partList.add(allParts.get(i));
                }
            }
            return partList;
        }
        return null;
    }

    /**
     * Used to lookup products by name.
     * @param productName Name of product to search for.
     * @return Product List
     * */
    public static ObservableList<Product> lookupProductName(String productName){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productName = productName.toLowerCase();

        if(!allProducts.isEmpty()){
            for(int i = 0; i < allProducts.size(); i++){
                String lowerProduct = allProducts.get(i).getName().toLowerCase();
                if(lowerProduct.contains(productName)){
                    productList.add(allProducts.get(i));
                }
            }
            return productList;
        }
        return null;
    }

    /**
     * Used to update information for a part.
     * @param selectedPart Part to update.
     * @param index Index of part.
     * */
    public static void updatePart(int index, Part selectedPart){
        for(int i = 0; i < allParts.size(); i++){
            if(allParts.get(i).getId() == selectedPart.getId()){
                allParts.set(i, selectedPart);
                break;
            }
        }
    }

    /**
     * Used to update information for a product.
     * @param index Index of product.
     * @param selectedProduct Product to update.
     * */
    public static void updateProduct(int index, Product selectedProduct){
        for(int i = 0; i < allProducts.size(); i++){
            if(allProducts.get(i).getId() == selectedProduct.getId()){
                allProducts.set(i, selectedProduct);
                break;
            }
        }
    }

    /**
     * Used to delete a part from the inventory.
     * @param selectedPart Selects a part to remove.
     * */
    public static void deletePart(Part selectedPart){
        for(int i = 0; i < allParts.size(); i++){
            if(allParts.get(i).getId() == selectedPart.getId()){
                allParts.remove(i);
                break;
            }
        }
    }

    /**Used to delete a product from the inventory.
     * @param selectedProduct Selects a product to remove.
     * */
    public static void deleteProduct(Product selectedProduct){
        for(int i = 0; i < allProducts.size(); i++){
            if(allProducts.get(i).getId() == selectedProduct.getId()){
                allProducts.remove(i);
                break;
            }
        }
    }

    /**
     * Used to return all parts from the inventory list.
     * @return allParts
     * */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    /**
     * Used to return all products from the inventory list.
     * @return allProducts
     * */
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }



}

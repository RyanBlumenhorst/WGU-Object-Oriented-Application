package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//JavaDoc Files are located in the JavaDoc Folder of Object-Oriented Application Task Ryan Blumenhorst.

/**This program is for an inventory management system.*/
public class Main extends Application {

    /**Loads the main screen and sets the title.*/
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setTitle("Inventory System");
        stage.setScene(new Scene(root, 900,400));
        stage.show();
    }


    /**Main Function, this will create the new inventory list and open the GUI.
     * @param args Code to run.
     * */
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        addTestData(inv);

        launch(args);
    }

    /**This method adds test data to the inventory.
     * @param inventory The test inventory.
     * FUTURE ENHANCEMENT: Read Inventory data from a file to import into program.
     * */
    public static void addTestData(Inventory inventory){
        //In House Parts
        Part a1 = new InHouse(1,"Brakes",15.00,10,1,20,111);
        Part a2 = new InHouse(2, "Wheel", 11.00, 16, 1, 20, 120);
        Part a3 = new InHouse(3,"Seat", 15.00, 10, 1, 20, 113);

        //Outsourced parts
        Part b1 = new Outsourced(4, "Frame", 30.00, 12, 1, 15, "BMXFrames");
        Part b2 = new Outsourced(5, "Gears", 10.00, 12, 1, 15, "Gear Labs");
        Part b3 = new Outsourced(6, "Pedals", 10.00, 15, 1, 20, "Gear Labs");

        //Adding In House Parts to Inventory
        inventory.addPart(a1);
        inventory.addPart(a2);
        inventory.addPart(a3);

        //Adding Outsourced Parts to Inventory
        inventory.addPart(b1);
        inventory.addPart(b2);
        inventory.addPart(b3);

        //New Products
        Product c1 = new Product (1, "Giant Bike", 299.99, 5, 1, 10);
        Product c2 = new Product (2, "Tricycle", 99.99, 3, 1, 5);

        //Add Parts to Products
        //Giant Bike = All Parts
        c1.addAssociatedPart(a1);
        c1.addAssociatedPart(a2);
        c1.addAssociatedPart(a3);
        c1.addAssociatedPart(b1);
        c1.addAssociatedPart(b2);
        c1.addAssociatedPart(b3);

        //Tricycle = Wheels, Seat, Frame, Pedals
        c2.addAssociatedPart(a2);
        c2.addAssociatedPart(a3);
        c2.addAssociatedPart(b1);
        c2.addAssociatedPart(b3);

        //Add Products to Inventory
        inventory.addProduct(c1);
        inventory.addProduct(c2);

    }

}

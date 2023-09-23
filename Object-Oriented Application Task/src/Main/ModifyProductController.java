package Main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**This is the controller for the ModProduct.fxml file.*/
public class ModifyProductController implements Initializable {
    /**Stage*/
    public Stage stage;

    @FXML private TableView<Part> PartSearchTable_A;
    @FXML private TableColumn<Part, Integer> partID_Column_A;
    @FXML private TableColumn<Part, String> partName_Column_A;
    @FXML private TableColumn<Part, Integer> inventoryLevel_Column_A;
    @FXML private TableColumn<Part, Double> pricePerUnit_Column_A;

    @FXML private TableView<Part> PartsOfProductTable_B;
    @FXML private TableColumn<Part, Integer> partID_Column_B;
    @FXML private TableColumn<Part, String> partName_Column_B;
    @FXML private TableColumn<Part, Integer> inventoryLevel_Column_B;
    @FXML private TableColumn<Part, Double> pricePerUnit_Column_B;

    @FXML private TextField searchPartTextField;
    @FXML private Button searchPartButton;
    @FXML private Button addPartButton;
    @FXML private Button deletePartButton;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    @FXML private TextField productIDField;
    @FXML private TextField productNameField;
    @FXML private TextField productInvField;
    @FXML private TextField productPriceField;
    @FXML private TextField productMaxField;
    @FXML private TextField productMinField;
    private ObservableList<Part> partsToAdd = productToModify.getAllAssociatedParts();
    private static Product productToModify;

    /**
     * This will load the information of a product for you to modify.
     * @param product Product you want to modify.
     * */
    public static void productPass(Product product) {
        productToModify = product;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fields
        productIDField.setDisable(true);
        productIDField.setPromptText(Integer.toString(productToModify.getId()));
        productNameField.setText(productToModify.getName());
        productInvField.setText(Integer.toString(productToModify.getStock()));
        productPriceField.setText(Double.toString(productToModify.getPrice()));
        productMaxField.setText(Integer.toString(productToModify.getMax()));
        productMinField.setText(Integer.toString(productToModify.getMin()));


        //top part selection table
        partID_Column_A.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName_Column_A.setCellValueFactory(new PropertyValueFactory<>("name"));
        inventoryLevel_Column_A.setCellValueFactory(new PropertyValueFactory<>("stock"));
        pricePerUnit_Column_A.setCellValueFactory(new PropertyValueFactory<>("price"));
        PartSearchTable_A.setItems(Inventory.getAllParts());

        //bottom part table
        partID_Column_B.setCellValueFactory(new PropertyValueFactory<>("id"));
        partName_Column_B.setCellValueFactory(new PropertyValueFactory<>("name"));
        inventoryLevel_Column_B.setCellValueFactory(new PropertyValueFactory<>("stock"));
        pricePerUnit_Column_B.setCellValueFactory(new PropertyValueFactory<>("price"));
        PartsOfProductTable_B.setItems(partsToAdd);
    }

    void updatePartsToAdd(){
        PartsOfProductTable_B.setItems(partsToAdd);
    }

    /**Used to add associated parts to a product.*/
    @FXML
    void addPart(ActionEvent event) {
        Part part = PartSearchTable_A.getSelectionModel().getSelectedItem();
        boolean partInTable = false;

        if(part != null) {

            //checks if part is already in the table
            for (int i = 0; i < partsToAdd.size(); i++) {
                if (partsToAdd.get(i).getId() == part.getId()) {
                    partInTable = true;
                }
            }

            if (partInTable == false) {
                partsToAdd.add(part);
                updatePartsToAdd();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initModality(Modality.NONE);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Part already in table.");
                alert.showAndWait();
                return;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("No Part Selected.");
            alert.showAndWait();
            return;
        }
    }

    /**Cancel Button*/
    @FXML
    void cancelProduct(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Part");
        alert.setHeaderText("Confirm cancellation");
        alert.setContentText("Are you sure you want to cancel?\r");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }

    /**Used to remove a part from the associated parts list.*/
    @FXML
    void deletePart(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Part part = PartsOfProductTable_B.getSelectionModel().getSelectedItem();

        alert.initModality(Modality.NONE);
        alert.setTitle("Delete Part");
        alert.setHeaderText("Confirm delete part");
        alert.setContentText("Are you sure you want to delete " + part.getName() + "?\r");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            partsToAdd.remove(part);
            updatePartsToAdd();
        }
    }

    /**Save Button*/
    @FXML
    void saveProduct(ActionEvent event) {
        boolean parseError = false;
        int productID = productToModify.getId();
        String productName = productNameField.getText();
        int productInStock = 0;
        double productPrice = 0;
        int productMax = 0;
        int productMin = 0;
        double partsPrice = 0.0;
        boolean failConditions = false;

        //converts string inputs to proper types
        try {
            productInStock = Integer.parseInt(productInvField.getText());
            productPrice = Double.parseDouble(productPriceField.getText());
            productMax = Integer.parseInt(productMaxField.getText());
            productMin = Integer.parseInt(productMinField.getText());

        } catch (NumberFormatException e) {
            parseError = true;
            System.err.println("Unable to format. " + e);
        }

        //determines any error conditions
        if (parseError || (productMax < productMin) || (productInStock > productMax) ||
                (partsToAdd.size() < 1) || (productPrice < partsPrice)) {
            failConditions = true;
        }

        //displays any errors
        if (failConditions) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.NONE);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            if (parseError) {
                alert.setContentText("Invalid input");
            } else if (productMax < productMin) {
                alert.setContentText("Max must be greater than min.");
            } else if (partsToAdd.size() < 1){
                alert.setContentText("Product must contain at least 1 part.");
            } else if (productPrice < partsPrice) {
                alert.setContentText("Price of product can not be less than price of parts.");
            } else {
                alert.setContentText("Inventory can not be greater than max amount of items to be stored.");
            }
            alert.showAndWait();
            return;
        }

        //add product to inventory
        if (!failConditions) {
            Product product = new Product(productID, productName, productPrice, productInStock, productMin, productMax);
            for (int i = 0; i < partsToAdd.size(); i++) {
                product.addAssociatedPart(partsToAdd.get(i));
            }
            Inventory.updateProduct(productToModify.getId(),product);
        }

        //closes window
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    /**Used to search through the parts.*/
    @FXML
    void searchPart(ActionEvent event) {
        String searchText = searchPartTextField.getText().trim();
        if (!searchText.isEmpty()) {
            try{
                int partId = Integer.parseInt(searchText);
                PartSearchTable_A.setItems(Inventory.lookupPartID(partId));
            } catch(NumberFormatException nfe){
                PartSearchTable_A.setItems(Inventory.lookupPartName(searchText));
            }

        } else {
            PartSearchTable_A.setItems(Inventory.getAllParts());
        }
    }

}

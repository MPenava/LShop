package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.Products;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import ba.sum.fpmoz.informatika.lshop.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductControler implements Initializable {

    @FXML
    TextField brandTxt;

    @FXML
    TextField modelTxt;

    @FXML
    TextField ramTxt;

    @FXML
    TextField processorTxt;

    @FXML
    TextField screenTxt;

    @FXML
    TextField priceTxt;

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnBrand;

    @FXML
    TableColumn tableColumnModel;

    @FXML
    TableColumn tableColumnRam;

    @FXML
    TableColumn tableColumnProcessor;

    @FXML
    TableColumn tableColumnScreen;

    @FXML
    TableColumn tableColumnPrice;

    @FXML
    TableView tableViewProducts;

    @FXML
    Button deleteBtn;

    Products selectedProduct;

    @FXML
    protected void selectProduct (){
        this.selectedProduct = (Products) this.tableViewProducts.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.brandTxt.setText(this.selectedProduct.getBrand());
        this.modelTxt.setText(this.selectedProduct.getModel());
        this.ramTxt.setText(this.selectedProduct.getRam());
        this.processorTxt.setText(this.selectedProduct.getRam());
        this.screenTxt.setText(this.selectedProduct.getScreen());
        this.priceTxt.setText(this.selectedProduct.getPrice());
    }

    @FXML
    protected void homePage(ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Main.swapScene(stage, "home.fxml","Početna stranica!");
    }

    @FXML
    protected void productsPage(ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Main.swapScene(stage, "products.fxml","Products");
    }

    @FXML
    protected void usersPage(ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Main.swapScene(stage, "users.fxml","Users");
    }

    @FXML
    protected void saveProduct() throws Exception {
        if(this.selectedProduct == null) {
            Products newProduct = new Products();
            newProduct.setBrand(this.brandTxt.getText());
            newProduct.setModel(this.modelTxt.getText());
            newProduct.setRam(this.ramTxt.getText());
            newProduct.setProcessor(this.processorTxt.getText());
            newProduct.setScreen(this.screenTxt.getText());
            newProduct.setPrice(this.priceTxt.getText());
            newProduct.save();
        }else{
            this.selectedProduct.setBrand(this.brandTxt.getText());
            this.selectedProduct.setModel(this.modelTxt.getText());
            this.selectedProduct.setRam(this.ramTxt.getText());
            this.selectedProduct.setProcessor(this.processorTxt.getText());
            this.selectedProduct.setScreen(this.screenTxt.getText());
            this.selectedProduct.setPrice(this.priceTxt.getText());
            this.selectedProduct.update();
            this.selectedProduct = null;
        }
        this.fillProducts();

        this.brandTxt.setText("");
        this.modelTxt.setText("");
        this.ramTxt.setText("");
        this.processorTxt.setText("");
        this.screenTxt.setText("");
        this.priceTxt.setText("");

        this.deleteBtn.setDisable(true);
    }

    @FXML
    protected void deleteProduct () throws Exception {
        if(this.selectedProduct != null){
            this.selectedProduct.delete();
            this.fillProducts();
        }
    }

    @FXML
    private void fillProducts(){
        try{
            ObservableList<?> products = FXCollections.observableList(Table.list(Products.class)) ;
            this.tableViewProducts.setItems(products);
        }catch(Exception e){
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        this.tableColumnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        this.tableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        this.tableColumnScreen.setCellValueFactory(new PropertyValueFactory<>("screen"));
        this.tableColumnRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
        this.tableColumnProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));

        this.fillProducts();
    }

}

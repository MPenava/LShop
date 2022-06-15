package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.Products;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductControler implements Initializable {

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

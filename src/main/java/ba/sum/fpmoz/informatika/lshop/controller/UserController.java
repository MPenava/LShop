package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import ba.sum.fpmoz.informatika.lshop.model.User;
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

public class UserController implements Initializable {
    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnFirstname;

    @FXML
    TableColumn tableColumnSurname;

    @FXML
    TableColumn tableColumnEmail;

    @FXML
    TableColumn tableColumnPassword;

    @FXML
    TableColumn tableColumnRole;

    @FXML
    TableView tableViewUsers;


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
    private void fillUsers(){
        try{
            ObservableList<?> users = FXCollections.observableList(Table.list(User.class)) ;
            this.tableViewUsers.setItems(users);
        }catch(Exception e){
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.tableColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tableColumnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        this.tableColumnRole.setCellValueFactory(new PropertyValueFactory<>("role"));

        this.fillUsers();
    }


}

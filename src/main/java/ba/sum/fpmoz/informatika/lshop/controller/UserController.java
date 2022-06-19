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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    TextField firstnameTxt;

    @FXML
    TextField surnameTxt;

    @FXML
    TextField emailTxt;

    @FXML
    TextField passwordTxt;

    @FXML
    TextField roleTxt;

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
    Button deleteBtn;

    User selectedUser;

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
    protected void selectUser (){
        this.selectedUser = (User) this.tableViewUsers.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.firstnameTxt.setText(this.selectedUser.getFirstname());
        this.surnameTxt.setText(this.selectedUser.getSurname());
        this.emailTxt.setText(this.selectedUser.getEmail());
        this.passwordTxt.setText(this.selectedUser.getPassword());
        this.roleTxt.setText(this.selectedUser.getRole());
    }

    @FXML
    protected void saveUser() throws Exception {
        if(this.selectedUser == null) {
            User newUser = new User();
            newUser.setFirstname(this.firstnameTxt.getText());
            newUser.setSurname(this.surnameTxt.getText());
            newUser.setEmail(this.emailTxt.getText());
            newUser.setPassword(this.passwordTxt.getText());
            newUser.setRole(this.roleTxt.getText());
            newUser.save();
        }else{
            this.selectedUser.setFirstname(this.firstnameTxt.getText());
            this.selectedUser.setSurname(this.surnameTxt.getText());
            this.selectedUser.setEmail(this.emailTxt.getText());
            this.selectedUser.setPassword(this.passwordTxt.getText());
            this.selectedUser.setRole(this.roleTxt.getText());
            this.selectedUser.update();
            this.selectedUser = null;
        }
        this.fillUsers();

        this.firstnameTxt.setText("");
        this.surnameTxt.setText("");
        this.emailTxt.setText("");
        this.passwordTxt.setText("");
        this.roleTxt.setText("");

        this.deleteBtn.setDisable(true);
    }

    @FXML
    protected void deleteUser () throws Exception {
        if(this.selectedUser != null){
            this.selectedUser.delete();
            this.fillUsers();

            this.firstnameTxt.setText("");
            this.surnameTxt.setText("");
            this.emailTxt.setText("");
            this.passwordTxt.setText("");
            this.roleTxt.setText("");

            this.deleteBtn.setDisable(true);
        }
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

package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import ba.sum.fpmoz.informatika.lshop.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField email;

    @FXML
    private TextField password;


    @FXML
    protected void loginUser(ActionEvent evt) throws Exception {

        if (this.email.getText().equals("marko.penava@fpmoz.sum.ba") && this.password.getText().equals("12345678")){
            Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Main.swapScene(stage, "home.fxml","Početna stranica!");
        }else{
            loginMessageLabel.setText("Please enter email and password");
        }
    }


}
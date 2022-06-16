package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

        if(Table.getUser(this.email.getText(), this.password.getText()) == true){
            Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Main.swapScene(stage, "home.fxml","Početna stranica!");
        }else{
            loginMessageLabel.setText("Please enter email and password");
        }

        /*
        if (this.email.getText().equals("1") && this.password.getText().equals("1")){
            Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Main.swapScene(stage, "home.fxml","Početna stranica!");
        }else{
            loginMessageLabel.setText("Please enter email and password");
        }
         */

    }


}
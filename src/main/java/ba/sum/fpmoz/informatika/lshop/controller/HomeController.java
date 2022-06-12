package ba.sum.fpmoz.informatika.lshop.controller;

import ba.sum.fpmoz.informatika.lshop.Main;
import ba.sum.fpmoz.informatika.lshop.model.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HomeController {


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
}

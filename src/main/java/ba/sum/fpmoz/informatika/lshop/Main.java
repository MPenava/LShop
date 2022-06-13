package ba.sum.fpmoz.informatika.lshop;

import ba.sum.fpmoz.informatika.lshop.model.Order_details;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import ba.sum.fpmoz.informatika.lshop.model.User;
import ba.sum.fpmoz.informatika.lshop.model.WishList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    public static void swapScene(Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Nastala je pogreška!" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
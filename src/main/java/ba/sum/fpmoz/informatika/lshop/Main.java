package ba.sum.fpmoz.informatika.lshop;

import ba.sum.fpmoz.informatika.lshop.model.Order_details;
import ba.sum.fpmoz.informatika.lshop.model.Table;
import ba.sum.fpmoz.informatika.lshop.model.User;
import ba.sum.fpmoz.informatika.lshop.model.WishList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        /*
        Table.create(User.class);
        Table.create(Product.class);
        Table.create(WishList.class);
        Table.create(Order_tbl.class);
        Table.create(Order_details.class);
        */

        /*

        **Adding new User**
        User person = new User();
        person.setFirstname("Marko");
        person.setLastname("Ppenava");
        person.setAddress("Posušje, Batin II 16");
        person.setPhone("+38763/847-007");
        person.setEmail("marko.penava@fpmoz.sum.ba");
        person.setPassword("123456789");
        person.setRole("student");
        person.save();

        **Updating user**
        User t = (User) User.get(User.class, 1);
        t.setLastname("Penava");
        t.update();

         */



    }

    public static void main(String[] args) {
        launch();
    }
}
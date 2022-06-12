module ba.sum.fpmoz.informatika.lshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.sum.fpmoz.informatika.lshop to javafx.fxml;
    opens ba.sum.fpmoz.informatika.lshop.model to javafx.fxml;
    exports ba.sum.fpmoz.informatika.lshop;
    exports ba.sum.fpmoz.informatika.lshop.controller;
    exports ba.sum.fpmoz.informatika.lshop.model;
    opens ba.sum.fpmoz.informatika.lshop.controller to javafx.fxml;
}
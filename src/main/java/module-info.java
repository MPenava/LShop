module ba.sum.fpmoz.informatika.lshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ba.sum.fpmoz.informatika.lshop to javafx.fxml;
    exports ba.sum.fpmoz.informatika.lshop;
}
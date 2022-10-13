module ro.cristian.password_generator {
    requires javafx.controls;
    requires javafx.fxml;


    opens ro.cristian.password_generator to javafx.fxml;
    exports ro.cristian.password_generator;
}
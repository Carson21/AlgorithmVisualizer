module self.carson {
    requires javafx.controls;
    requires javafx.fxml;


    opens self.carson to javafx.fxml;
    exports self.carson;
}
module com.example.midproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midproject to javafx.fxml;
    exports com.example.midproject;
}
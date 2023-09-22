module com.example.gallows {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gallows to javafx.fxml;
    exports com.example.gallows;
}
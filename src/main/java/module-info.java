module com.example.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires jdk.unsupported.desktop;


    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
}
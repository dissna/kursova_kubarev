module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kursova to javafx.fxml;
    exports com.example.kursova;
    exports com.example.kursova.Table;
}
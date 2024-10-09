module com.example.minigamecorner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.minigamecorner to javafx.fxml;
    exports com.example.minigamecorner;
}
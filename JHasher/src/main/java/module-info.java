module com.jhasher.jhasher {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires java.desktop;


    opens com.jhasher.jhasher to javafx.fxml;
    exports com.jhasher.jhasher;
}
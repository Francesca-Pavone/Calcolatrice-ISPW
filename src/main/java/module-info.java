module com.example.calcolatrice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.calcolatrice to javafx.fxml;
    exports com.example.calcolatrice;
}
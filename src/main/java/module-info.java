module com.mycompany.reto0_din {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.reto0_din to javafx.fxml;
    exports com.mycompany.reto0_din;
}

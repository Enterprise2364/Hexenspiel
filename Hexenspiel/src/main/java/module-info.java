module trinat.hexenspiel.hexenspiel {
    requires javafx.controls;
    requires javafx.fxml;


    opens trinat.hexenspiel.hexenspiel to javafx.fxml;
    exports trinat.hexenspiel.hexenspiel;
}
module com.example.witchdash2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens witchdash to javafx.fxml;
    exports witchdash;
}
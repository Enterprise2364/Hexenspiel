package trinat.hexenspiel.hexenspiel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {

    @FXML
    public void clickOpenWindow(ActionEvent actionEvent) throws IOException {

        System.out.println("It works!");
        Parent root = FXMLLoader.load(getClass().getResource("cool.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Another window");
        stage.setScene(new Scene(root));
        stage.show();

    }
}

package trinat.hexenspiel.hexenspiel;

// Java program to create a popup and
// add it to the stage
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Popup;

import java.io.IOException;

public class Popup_1 extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pop_up.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println(event.getCode());
                Label label = new Label("Game Over");
                label.setText("Game Over");
                FlowPane root = new FlowPane();
                root.getChildren().add(label);

            }
        });

        stage.setScene(scene);
        stage.show();


    }
        public static void main(String[] args) {

        launch(args);
    }
}


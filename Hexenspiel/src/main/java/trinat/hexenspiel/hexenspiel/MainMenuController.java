package trinat.hexenspiel.hexenspiel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

        @FXML
        public Button new_game;
        @FXML
        public Button quit;
        @FXML
        private Label welcomeText;

        @FXML
        public void newGame(Stage stage) {
            MainTestClass.witchDashStage = stage;
            MainTestClass.witchDashMainScene();
        }

        @FXML
        public void quit() {
            System.exit(0);
        }
}

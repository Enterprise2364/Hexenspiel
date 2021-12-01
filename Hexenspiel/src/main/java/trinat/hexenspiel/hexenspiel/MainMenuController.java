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
        public void newGame() {
            WitchDashMain.launch();
        }

        @FXML
        public void quit() {
            WitchDashMain.mainMenuStage.close();
            WitchDashMain.witchDashMainStage.close();
            System.exit(0);
    }

}

package trinat.hexenspiel.hexenspiel;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static javafx.application.Application.launch;

public class GameOverController {

        @FXML
        public Button retry;
        @FXML
        public Button quit;
        @FXML
        private Label welcomeText;

        @FXML
        public void handleQuitButtonAction(ActionEvent event) {
            WitchDashMain.gameOverStage.close();
            WitchDashMain.witchDashMainStage.close();
        }

        @FXML
        public void handleRestartButtonAction(ActionEvent actionEvent) throws IOException {
            handleQuitButtonAction(actionEvent);
            WitchDashMain.witchDashMainScene();
        }
}

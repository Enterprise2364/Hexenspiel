package trinat.hexenspiel.hexenspiel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuController {

        @FXML
        public Button startGame;
        @FXML
        public Button quit;

    @FXML
    public void handleStartButtonAction(ActionEvent actionEvent) throws IOException{
        WitchDashMain.callDifficultyStage();
    }

        @FXML
        public void handleQuitButtonAction() {
            WitchDashMain.mainMenuStage.close();
    }

}

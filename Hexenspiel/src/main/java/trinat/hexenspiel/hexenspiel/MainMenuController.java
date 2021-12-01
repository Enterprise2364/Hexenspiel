package trinat.hexenspiel.hexenspiel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuController {

        @FXML
        public Button new_game;
        @FXML
        public Button quit;

    @FXML
    public void newGame(ActionEvent actionEvent) throws IOException{
        handleCloseButtonAction(actionEvent);
        WitchDashMain.witchDashMainScene();
    }

        @FXML
        public void quit() {
            System.exit(0);
    }

}

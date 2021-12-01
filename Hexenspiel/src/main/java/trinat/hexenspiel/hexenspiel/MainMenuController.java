package trinat.hexenspiel.hexenspiel;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

        @FXML
        public Button new_game;
        @FXML
        public Button quit;

    @FXML
        public void newGame() {
            WitchDashMain.launch();
        }

        @FXML
        public void quit() {
            System.exit(0);
    }

}

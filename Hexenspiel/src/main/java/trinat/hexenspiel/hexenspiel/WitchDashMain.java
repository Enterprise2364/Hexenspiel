package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.IOException;

public class WitchDashMain extends Application {
    @Override
    public void start(Stage witchDashStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.class.getResource("witchDash-view.fxml"));
        Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);
        witchDashStage.setTitle("Witch Dash");
        witchDashStage.setScene(witchDashScene);
        witchDashStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
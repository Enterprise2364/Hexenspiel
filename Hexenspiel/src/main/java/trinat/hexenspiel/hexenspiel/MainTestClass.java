package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.Node;


public class MainTestClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //définition Squares parameter
        int positionwX = 100;
        int positionwY = 100;
        int positionoX = 250;
        int positionoY = 250;
        int hit_boxWidth = 25;
        int hit_boxHeight = 25;

        FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.
                class.
                getResource("witchDash-view.fxml"));

        //Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);

        stage.setTitle("Witch Dash");

        Witch witch = new Witch();

        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1 = new Rectangle(200, 20, 20, 20);
        root.getChildren().add(rectangle1);

        //timeline diffinition
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                new KeyValue (witch.getRectangle().translateXProperty(), 25), new KeyValue (rectangle1.translateXProperty(), 25)));


        //Scene creation
        int SceneXsize = 800;
        int SceneYsize = 400;
        Scene witchDashScene = new Scene(root, SceneXsize, SceneYsize);
        stage.setScene(witchDashScene);
        stage.show();
        timeline.play();
        witchDashScene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {
                if (witch.getRectangle().getY() <= 0) {
                    witch.moveWitch(0, 1);
                } else {
                    witch.moveWitch(0, -1);
                }

            } else if (e.getCode().equals(KeyCode.S)) {
                if (witch.getRectangle().getY() >= witchDashScene.getHeight() - witch.getRectangle().getHeight()) {
                    witch.moveWitch(0, -1);
                } else {
                    witch.moveWitch(0, +1);
                }

            } else if (e.getCode().equals(KeyCode.D)) {
                if (witch.getRectangle().getX() >= witchDashScene.getWidth() - witch.getRectangle().getWidth()) {
                    witch.moveWitch(-1, 0);
                } else {
                    witch.moveWitch(1, 0);
                }

            } else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {
                if (witch.getRectangle().getX() <= 0) {

                    witch.moveWitch(+1, 0);
                } else {
                    witch.moveWitch(-1, 0);
                }


            }
        });
    }










        public static void main(String[] args) {

        launch();
    }
}
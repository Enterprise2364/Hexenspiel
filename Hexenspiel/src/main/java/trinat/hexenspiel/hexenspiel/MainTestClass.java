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
        Pumpkin pumpkin = new Pumpkin();

        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1 = new Rectangle(200, 20, 20, 20);
        root.getChildren().add(rectangle1);

        //timeline diffinition
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(true);

        KeyValue pumpkin_animation = new KeyValue (pumpkin.getRectangle().translateXProperty(),1);
        KeyFrame Start = new KeyFrame(Duration.millis(1000),pumpkin_animation);
        timeline.getKeyFrames().add(Start);

        KeyValue witch_animation_up = new KeyValue (pumpkin.getRectangle().translateYProperty(), 1);
        KeyFrame Witch_animation_up = new KeyFrame(Duration.millis(1000),witch_animation_up);
        timeline.getKeyFrames().add(Witch_animation_up);

        KeyValue witch_animation_down = new KeyValue (pumpkin.getRectangle().translateYProperty(), -1);
        KeyFrame Witch_animation_down = new KeyFrame(Duration.millis(1000),witch_animation_down);
        timeline.getKeyFrames().add(Witch_animation_down);

        KeyValue witch_animation_right = new KeyValue (pumpkin.getRectangle().translateXProperty(), 1);
        KeyFrame Witch_animation_right = new KeyFrame(Duration.millis(1000),witch_animation_right);
        timeline.getKeyFrames().add(Witch_animation_right);

        KeyValue witch_animation_left = new KeyValue (pumpkin.getRectangle().translateXProperty(), -1);
        KeyFrame Witch_animation_left = new KeyFrame(Duration.millis(1000),witch_animation_left);
        timeline.getKeyFrames().add(Witch_animation_left);



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
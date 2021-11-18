package witchdash;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {


    public Rectangle witch;
    public Rectangle pumpkin;
    public int posX = 50;
    public int posY = 200;
    public int height = 100;
    public int width = 40;
    public int sceneSizeX = 1500;
    public int sceneSizeY = 500;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Witchdash");

        Group root = new Group();
        Scene scene = new Scene(root, sceneSizeX, sceneSizeY, Color.WHITE);
        stage.setScene(scene);


        this.witch = new Witch(posX, posY, width, height);
        root.getChildren().add(witch);
        stage.show();

        // generate random numbers within 40 and 460
        int pumpkinY = (int) (Math.random() * sceneSizeY - 40) + 40;
        int pumpkinX = sceneSizeX;
        this.pumpkin = new Pumpkin(pumpkinX, pumpkinY, 40, 40, 2, 2);
        root.getChildren().add(pumpkin);
        stage.show();

        //Movement pumpkin
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Pumpkin.Rectangle_Translation(pumpkin, -100);

                    scene.setOnKeyPressed(e -> {
                        if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {

                            Witch.Rectangle_Translation(pumpkin, posX, posY, 10, 0);
                        } else {
                            Witch.Rectangle_Translation(pumpkin, posX, posY, -10, 0);
                        }
                    }
                }
            })));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            stage.show();
    }
}

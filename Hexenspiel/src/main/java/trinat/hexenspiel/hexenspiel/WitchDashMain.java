package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WitchDashMain extends Application {
    private static Timeline loop;
    //Duration per Frame in millisec
    private static final int durationPerFrameRate=10;


    @Override
    public void start(Stage witchDashStage) throws IOException {
        
        /*FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.
                                                class.
                                                getResource("witchDash-view.fxml"));

        Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);*/

        //Set Stage
        witchDashStage.setTitle("Witch Dash");



        //Set Scene
        int sceneY=0;
        int sceneWidth=800;
        int sceneHeight=400;
        int witchSpeed=10;
        int pumpkinSpeed=1;
        Witch witch= new Witch();
        Pumpkin pumpkin =new Pumpkin(sceneWidth,
                                        sceneY,
                                        sceneHeight);

        witch.setSpeed(witchSpeed);
        pumpkin.setSpeed(pumpkinSpeed);

        Group root = new Group(witch.getRectangle(),
                                pumpkin.getRectangle());

        Scene witchDashScene = new Scene(root,
                                            sceneWidth,
                                            sceneHeight);

        witchDashStage.setScene(witchDashScene);
        witchDashStage.show();

        //Looping pumpkin movement to the left
        loop= new Timeline(new KeyFrame(
                Duration.millis(durationPerFrameRate),
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent arg) {
                        // Pumpkin Movement
                        pumpkin.moveLeft();

                        //Witch Control
                        witchDashScene.setOnKeyPressed(e -> {
                            if (e.getCode() == KeyCode.ESCAPE) {

                            witchDashStage.close();

                            }

                            if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {

                                if (witch.getRectangle().getY() <=witchDashScene.getY()){

                                    witch.moveUp();
                                }
                                else{

                                    witch.moveDown();
                                }

                            }
                            else if (e.getCode().equals(KeyCode.S)) {

                                if (witch.getRectangle().getY()>= witchDashScene.getHeight()-witch.getRectangle().getHeight()){

                                    witch.moveDown();
                                }
                                else{

                                    witch.moveUp();
                                }

                            }
                            else if (e.getCode().equals(KeyCode.D)) {

                                if (witch.getRectangle().getX() >=witchDashScene.getWidth()-witch.getRectangle().getWidth()){

                                    witch.moveLeft();
                                }
                                else{

                                    witch.moveRight();
                                }

                            }
                            else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {

                                if (witch.getRectangle().getX() <=witchDashScene.getX()){

                                    witch.moveRight();
                                }
                                else{

                                    witch.moveLeft();
                                }

                            }
                        });

                        // Collision between Witch and Pumpkin
                        if (witch.testCollision(pumpkin.getRectangle())) {
                            loop.stop();
                        }





                    }

                }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        witchDashStage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}
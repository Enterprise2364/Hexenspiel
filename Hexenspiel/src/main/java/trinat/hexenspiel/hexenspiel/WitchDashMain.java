package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WitchDashMain extends Application {
    private static Timeline loop;
    protected static Stage witchDashMainStage;
    protected static Stage gameOverStage;
    //Duration per Frame in millisec
    private static final int durationPerFrameRate=10;


    @Override
    public void start(Stage stage) throws IOException {
        witchDashMainStage = stage;
        witchDashMainScene();
    }

    public static void witchDashMainScene(){

        //Set Stage
        witchDashMainStage.setTitle("Witch Dash");



        //Set Scene
        int sceneY=0;
        int sceneWidth=800;
        int sceneHeight=400;
        int witchSpeed=10;
        int pumpkinSpeed=1;
        Witch witch= new Witch(2,4,40,40, 2,2);
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

        witchDashMainStage.setScene(witchDashScene);
        witchDashMainStage.show();

        //Looping pumpkin movement to the left
        loop= new Timeline(new KeyFrame(
                Duration.millis(durationPerFrameRate),
                arg -> {
                    // Pumpkin Movement
                    pumpkin.moveLeft();

                    //Witch Control
                    witchDashScene.setOnKeyPressed(e -> {
                        if (e.getCode() == KeyCode.ESCAPE) {

                        witchDashMainStage.close();

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
                        try {
                            gameOverStage();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }





                }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        witchDashMainStage.show();

    }


    public static void main(String[] args) {
        launch();
    }

    public static void gameOverStage() throws IOException {
        gameOverStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("gameOverView.fxml"));
        Scene gameOverScene = new Scene(fxmlLoader.load(), 320, 240);
        gameOverStage.setTitle("Game over");
        gameOverStage.setScene(gameOverScene);
        gameOverStage.show();
    }
}
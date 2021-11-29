package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class WitchDashMain extends Application {
    private static Timeline loop;
    protected static Stage witchDashMainStage;
    protected static Stage gameOverStage;
    //Duration per Frame in millisec
    private static final int durationPerFrameRate=10;


    @Override
    public void start(Stage stage) throws IOException {
        WitchDashMain.witchDashMainStage = stage;
        WitchDashMain.witchDashMainScene();
    }
    public static void witchDashMainScene(){

        /*FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.
                                                class.
                                                getResource("witchDash-view.fxml"));

        Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);*/

        //Set Stage
        witchDashMainStage.setTitle("Witch Dash");



        //Set Scene
        int sceneY=0;
        int sceneWidth=800;
        int sceneHeight=400;
        int witchSpeed=10;

        Difficulty diff = new Difficulty();
        ArrayList<Pumpkin> pumpkinlist = new ArrayList<>();

        Witch witch= new Witch();

        witch.setSpeed(witchSpeed);

        Group root = new Group(witch.getRectangle());

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

                    //Create multiple Pumpkin
                    if(pumpkinlist.size() != diff.spawnFrequency) {
                        for(int i=0; i<diff.spawnFrequency; i++) {
                            pumpkinlist.add(new Pumpkin(sceneWidth, sceneY, sceneHeight));
                            pumpkinlist.get(i).setSpeed(diff.speed);
                        }
                    }
                    //Move obstacle to the left side
                    for(int i=0; i<pumpkinlist.size(); i++) {
                        pumpkinlist.get(i).moveLeft();
                    }

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
                    for(int i=0; i<diff.spawnFrequency; i++) {
                        if (witch.testCollision(pumpkinlist.get(i).getRectangle())) {
                            loop.stop();
                            try {
                                gameOverStage();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
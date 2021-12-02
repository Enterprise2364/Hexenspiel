package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class MainTestClass extends Application {
    private static Timeline loop;
    protected static Stage witchDashDifficultyStage;
    protected static Stage witchDashMainStage;
    protected static Stage gameOverStage;
    //Duration per Frame in millisec
    private static final int durationPerFrameRate = 10;


    @Override
    public void start(Stage stage) throws IOException {
        witchDashDifficultyStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("Difficulty.fxml"));
        Scene gameOverScene = new Scene(fxmlLoader.load(), 600, 400);
        witchDashDifficultyStage.setTitle("Difficulty Level");
        witchDashDifficultyStage.setScene(gameOverScene);
        witchDashDifficultyStage.show();

    }

    public static void witchDashMainScene(int obstacleNumber,int speed) {
        witchDashDifficultyStage.close();

        if (witchDashMainStage==null){
            witchDashMainStage= new Stage();
        }

        //Set Stage

        witchDashMainStage.setTitle("Witch Dash");


        //Set Scene
        int sceneY = 0;
        int sceneWidth = 800;
        int sceneHeight = 400;
        int witchSpeed = 10;
        int pumpkinSpeed = 1;
        Group root = new Group();

        Scene witchDashScene = new Scene(root,
                sceneWidth,
                sceneHeight);
        witchDashMainStage.setScene(witchDashScene);
        witchDashMainStage.show();
        witchDashMainStage.setWidth(witchDashScene.getWidth());
        witchDashMainStage.setHeight(witchDashScene.getHeight());
        witchDashMainStage.setY(sceneY);
        WitchDashEngine witchDashEngine = new WitchDashEngine(witchDashMainStage, obstacleNumber);
        root.getChildren().add(witchDashEngine.getWitch().getRectangle());

        for (int i = 0; i < witchDashEngine.getPumpkins().size(); i++) {
            root.getChildren().add(witchDashEngine.getPumpkins().get(i).getRectangle());
            witchDashEngine.getPumpkins().get(i).setSpeed(speed);
            witchDashEngine.getPumpkins().get(i).getRectangle().setVisible(true);
        }


        //Looping pumpkin movement to the left
        loop = new Timeline(new KeyFrame(
                Duration.millis(durationPerFrameRate),
                arg -> {
                    // Pumpkin Movement
                    witchDashEngine.movePumpkins(20);

                    //Witch Control
                    witchDashScene.setOnKeyPressed(e -> {
                        if (e.getCode() == KeyCode.ESCAPE) {

                            witchDashMainStage.close();

                        }

                        if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {

                            if (witchDashEngine.getWitch().getRectangle().getY() <= witchDashScene.getY()) {

                                witchDashEngine.getWitch().moveUp();
                            } else {

                                witchDashEngine.getWitch().moveDown();
                            }

                        } else if (e.getCode().equals(KeyCode.S)) {

                            if (witchDashEngine.getWitch().getRectangle().getY() >= witchDashScene.getHeight() - witchDashEngine.getWitch().getRectangle().getHeight()) {

                                witchDashEngine.getWitch().moveDown();
                            } else {

                                witchDashEngine.getWitch().moveUp();
                            }

                        } else if (e.getCode().equals(KeyCode.D)) {

                            if (witchDashEngine.getWitch().getRectangle().getX() >= witchDashScene.getWidth() - witchDashEngine.getWitch().getRectangle().getWidth()) {

                                witchDashEngine.getWitch().moveLeft();
                            } else {

                                witchDashEngine.getWitch().moveRight();
                            }

                        } else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {

                            if (witchDashEngine.getWitch().getRectangle().getX() <= witchDashScene.getX()) {

                                witchDashEngine.getWitch().moveRight();
                            } else {

                                witchDashEngine.getWitch().moveLeft();
                            }

                        }
                    });

                    // Collision between Witch and Pumpkin
                    if (witchDashEngine.testCollision()) {
                        if(witchDashEngine.getWitch().getLife().testNoLivesLeft()) {
                            loop.stop();
                            try {
                                gameOverStage();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            witchDashEngine.getWitch().getLife().addHitPoint();
                            //Searches for Collisions and if detected then set the object to a random position
                            for (Pumpkin pumpkin1 : witchDashEngine.getPumpkins().stream().filter(pumpkin -> pumpkin.testCollision(witchDashEngine.getWitch().getRectangle())).collect(Collectors.toList())) {
                                pumpkin1.getRectangle().setX(sceneWidth);
                                pumpkin1.setToRandomYPosition(sceneWidth, sceneY,sceneHeight);

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
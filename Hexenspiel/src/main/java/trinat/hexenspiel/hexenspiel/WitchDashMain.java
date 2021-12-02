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
import java.util.stream.Collectors;

public class WitchDashMain extends Application {
    private static Timeline loop;
    protected static Stage difficultyStage;
    protected static Stage mainStage;
    protected static Stage gameOverStage;
    protected static Stage mainMenuStage;
    //Duration per Frame in millisec
    private static final int durationPerFrameRate = 10;


    @Override
    public void start(Stage stage) throws IOException {
        mainMenuStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(fxmlLoader.load(), 600, 400);
        mainMenuStage.setTitle("Main menu");
        mainMenuStage.setScene(mainMenuScene);
        mainMenuStage.show();
    }

    public static void callDifficultyStage() throws IOException {
        mainMenuStage.close();
        difficultyStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("Difficulty.fxml"));
        Scene gameOverScene = new Scene(fxmlLoader.load(), 600, 400);
        difficultyStage.setTitle("Difficulty Level");
        difficultyStage.setScene(gameOverScene);
        difficultyStage.show();

    }

    public static void callWitchDashMain(int obstacleNumber, int speed) {
        difficultyStage.close();

        if (mainStage ==null){
            mainStage = new Stage();
        }

        //Set Stage

        mainStage.setTitle("Witch Dash");


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
        mainStage.setScene(witchDashScene);
        mainStage.show();
        WitchDashEngine witchDashEngine = new WitchDashEngine(mainStage, obstacleNumber);
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

                            mainStage.close();

                        }

                        if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {

                            if (witchDashEngine.getWitch().getRectangle().getY() <= 0) {

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

                            if (witchDashEngine.getWitch().getRectangle().getX() <= 0) {

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
        mainStage.show();

    }


    public static void main(String[] args) {
        launch();
    }

    public static void gameOverStage() throws IOException {
        gameOverStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("gameOverView.fxml"));
        Scene gameOverScene = new Scene(fxmlLoader.load(), 400, 400);
        gameOverStage.setTitle("Game over");
        gameOverStage.setScene(gameOverScene);
        gameOverStage.show();
    }
}
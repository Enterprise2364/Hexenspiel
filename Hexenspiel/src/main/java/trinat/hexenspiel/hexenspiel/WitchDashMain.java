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
        programmeStart();
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
        Group root = new Group();

        Scene witchDashScene = new Scene(root,
                sceneWidth,
                sceneHeight);
        witchDashMainStage.setScene(witchDashScene);
        witchDashMainStage.show();
        //witchDashMainStage.setWidth(witchDashScene.getWidth());
        //witchDashMainStage.setHeight(witchDashScene.getWidth());
        //witchDashMainStage.setY(sceneY);
        WitchDashEngine witchDashEngine = new WitchDashEngine(witchDashMainStage, 4);
        root.getChildren().add(witchDashEngine.getWitch().getRectangle());

        for (int i=0;i<witchDashEngine.getPumpkins().size();i++){
            root.getChildren().add(witchDashEngine.getPumpkins().get(i).getRectangle());
            witchDashEngine.getPumpkins().get(i).getRectangle().setVisible(true);
        }


        //Looping pumpkin movement to the left
        loop= new Timeline(new KeyFrame(
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

                            if (witchDashEngine.getWitch().getRectangle().getY() <=witchDashScene.getY()){

                                witchDashEngine.getWitch().moveUp();
                            }
                            else{

                                witchDashEngine.getWitch().moveDown();
                            }

                        }
                        else if (e.getCode().equals(KeyCode.S)) {

                            if (witchDashEngine.getWitch().getRectangle().getY()>= witchDashScene.getHeight()-witchDashEngine.getWitch().getRectangle().getHeight()){

                                witchDashEngine.getWitch().moveDown();
                            }
                            else{

                                witchDashEngine.getWitch().moveUp();
                            }

                        }
                        else if (e.getCode().equals(KeyCode.D)) {

                            if (witchDashEngine.getWitch().getRectangle().getX() >=witchDashScene.getWidth()-witchDashEngine.getWitch().getRectangle().getWidth()){

                                witchDashEngine.getWitch().moveLeft();
                            }
                            else{

                                witchDashEngine.getWitch().moveRight();
                            }

                        }
                        else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {

                            if (witchDashEngine.getWitch().getRectangle().getX() <=witchDashScene.getX()){

                                witchDashEngine.getWitch().moveRight();
                            }
                            else{

                                witchDashEngine.getWitch().moveLeft();
                            }

                        }
                    });

                    // Collision between Witch and Pumpkin
                    if (witchDashEngine.testCollision()) {
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


    public static void main(String[] args) throws IOException {
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
    public static void programmeStart() throws IOException {
        Stage mainMenuStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(fxmlLoader.load(), 600, 600);
        mainMenuStage.setTitle("Main menu");
        mainMenuStage.setScene(mainMenuScene);
        mainMenuStage.show();
    }
}
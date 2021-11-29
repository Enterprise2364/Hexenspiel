package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;


public class EngineTestClass extends Application {
    private static Timeline loop;
    protected static Stage witchDashStage;
    protected static Stage gameOverStage;
    @Override

    public void start(Stage stage) throws IOException {
        EngineTestClass.witchDashStage = stage;
        EngineTestClass.witchDashMainScene();

    }
    public static void witchDashMainScene()throws IOException {

        //définition Squares parameter
        int positionwX = 100;
        int positionwY = 100;
        int positionoX = 250;
        int positionoY = 250;
        int hit_boxWidth = 25;
        int hit_boxHeight = 25;

        FXMLLoader fxmlLoader = new FXMLLoader(EngineTestClass.
                class.
                getResource("witchDash-view.fxml"));

        //Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);

        witchDashStage.setTitle("Witch Dash");


        //Scene creation
        int sceneY = 0;
        int sceneWidth = 800;
        int sceneHeight = 400;
        Group root = new Group();
        Scene witchDashScene = new Scene(root, sceneWidth, sceneHeight);
        witchDashStage.setScene(witchDashScene);
        witchDashStage.show();
        WitchDashEngine testEngine = new WitchDashEngine(witchDashStage, 4);
        root.getChildren().add(testEngine.getWitch().getRectangle());
        Pumpkin pumpkin =new Pumpkin(sceneWidth,sceneY,sceneHeight);
        root.getChildren().add(pumpkin.getRectangle());
        for (int i=0;i<testEngine.getPumpkins().size();i++){
            root.getChildren().add(testEngine.getPumpkins().get(i).getRectangle());
            testEngine.getPumpkins().get(i).setSpeed(2);
            testEngine.getPumpkins().get(i).getRectangle().setFill(Color.BLUE);
            testEngine.getPumpkins().get(i).getRectangle().setVisible(true);
        }
        boolean test =false;
        ArrayList<Integer> gg= new ArrayList<>();
        gg.add(56);
        gg.add(5);
        gg.add(35);
        test=gg.stream().anyMatch(integer -> integer<3);
        test=gg.stream().anyMatch(integer -> integer<6);
        test = testEngine.testIfSameYPosition(testEngine.getPumpkins(),pumpkin );
        pumpkin.getRectangle().setY(testEngine.getPumpkins().get(0).getRectangle().getY());
        test = testEngine.testIfSameYPosition(testEngine.getPumpkins(),pumpkin);

        loop = new Timeline(new KeyFrame(Duration.millis(10), arg -> {

            // Pumpkin Movement
            testEngine.movePumpkins();

            //Test collision
            if (testEngine.testCollision()) {
                    loop.stop();
            }

            //Key handleing
            witchDashScene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ESCAPE) {

                    witchDashStage.close();

                }
                //Witch Movement
                if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {

                    if (testEngine.getWitch().getRectangle().getY() <=witchDashScene.getY()){

                        testEngine.getWitch().moveUp();
                    }
                    else{

                        testEngine.getWitch().moveDown();
                    }

                }
                else if (e.getCode().equals(KeyCode.S)) {

                    if (testEngine.getWitch().getRectangle().getY()>= witchDashScene.getHeight()-testEngine.getWitch().getRectangle().getHeight()){

                        testEngine.getWitch().moveDown();
                    }
                    else{

                        testEngine.getWitch().moveUp();
                    }

                }
                else if (e.getCode().equals(KeyCode.D)) {

                    if (testEngine.getWitch().getRectangle().getX() >=witchDashScene.getWidth()-testEngine.getWitch().getRectangle().getWidth()){

                        testEngine.getWitch().moveLeft();
                    }
                    else{

                        testEngine.getWitch().moveRight();
                    }

                }
                else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {

                    if (testEngine.getWitch().getRectangle().getX() <=witchDashScene.getX()){

                        testEngine.getWitch().moveRight();
                    }
                    else{

                        testEngine.getWitch().moveLeft();
                    }

                }
            });

        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        witchDashStage.show();

                    /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() { // detecte si on a appui� sur une touche
                        public void handle(KeyEvent event) {
                            if (event.getCode() == KeyCode.ESCAPE) {
                                Main.mainScene();
                            }
                            event.consume();
                        }
                    });*/

    }

        public static void main(String[] args) {

        launch();
    }
}
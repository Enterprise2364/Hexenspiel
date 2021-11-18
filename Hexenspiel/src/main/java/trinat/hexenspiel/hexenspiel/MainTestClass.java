package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;


public class MainTestClass extends Application {
    private static Timeline loop;
    protected static Stage witchDashStage;
    protected static Stage gameOverStage;
    @Override

    public void start(Stage stage) throws IOException {
        MainTestClass.witchDashStage = stage;
        MainTestClass.witchDashMainScene();

    }
    public static void witchDashMainScene()throws IOException{

        //définition Squares parameter
        int positionwX = 100;
        int positionwY = 100;
        int positionoX = 250;
        int positionoY = 250;
        int hit_boxWidth = 25;
        int hit_boxHeight = 25;

        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.
                class.
                getResource("witchDash-view.fxml"));

        //Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);

        witchDashStage.setTitle("Witch Dash");


        //Scene creation
        int sceneY=0;
        int sceneWidth=800;
        int sceneHeight=400;
        Witch witch = new Witch();
        Pumpkin pumpkin =new Pumpkin(sceneWidth,sceneY,sceneHeight);
        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1 = new Rectangle(200, 20, 20, 20);
        root.getChildren().addAll(rectangle1,pumpkin.getRectangle());
        Scene witchDashScene = new Scene(root, sceneWidth, sceneHeight);
        witchDashStage.setScene(witchDashScene);
        //timeline.play();
        /*while ((pumpkin.getRectangle().getX() >= 0)) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(
                                    pumpkin.getRectangle().translateXProperty(),
                                    pumpkin.getRectangle().getX())),
                    new KeyFrame(Duration.seconds(10),
                            new KeyValue(pumpkin.getRectangle().translateXProperty(),
                                    pumpkin.getRectangle().getX() - stage.getWidth()-pumpkin.getRectangle().getWidth()))
            );*/
        pumpkin.getRectangle().setY(witch.getRectangle().getY());
        pumpkin.getRectangle().setX(witchDashScene.getWidth()+pumpkin.getRectangle().getWidth());

        /*witch.testCollision(pumpkin.getRectangle())
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(
                                    rectangle1.translateXProperty(),
                                    pumpkin.getRectangle().getX())),
                    new KeyFrame(Duration.seconds(1),
                            new KeyValue(pumpkin.getRectangle().translateXProperty(),
                                    pumpkin.getRectangle().getX()-100))
            );
            pumpkin.getRectangle().setX(pumpkin.getRectangle().getX()-100);
            timeline.play();
            stage.show();
            timeline.stop();

        }
            //pumpkin.getRectangle().setX(pumpkin.getRectangle().getX()-10;
        //}*/

        loop= new Timeline(new KeyFrame(Duration.millis(1000),new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {

                    // Pumpkin Movement
                    pumpkin.movePumpkin(-1,0);

                    // collision bas
                    if (witch.testCollision(pumpkin.getRectangle())) {
                        loop.stop();
                        try {
                            gameOver();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }}));
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


    public static void gameOver() throws IOException {
        gameOverStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainTestClass.class.getResource("gameOverView.fxml"));
        Scene gameOverScene = new Scene(fxmlLoader.load(), 320, 240);
        gameOverStage.setTitle("Game over");
        gameOverStage.setScene(gameOverScene);
        gameOverStage.show();
    }

        public static void main(String[] args) {

        launch();
    }
}
package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        witch.setSpeed(8);
        pumpkin.setSpeed(1);
        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1 = new Rectangle(200, 20, 20, 20);

        Scene witchDashScene = new Scene(root, sceneWidth, sceneHeight);

        WitchDashEngine testEngine= new WitchDashEngine(witchDashStage,5);
        root.getChildren().addAll(rectangle1,pumpkin.getRectangle(),testEngine.getPumpkins().get(2).getRectangle());
        for (int i=0;i<testEngine.getPumpkins().size();i++){
            root.getChildren().add(testEngine.getPumpkins().get(i).getRectangle());
            testEngine.getPumpkins().get(i).setSpeed(1);
            testEngine.getPumpkins().get(i).getRectangle().setFill(Color.AZURE);
        }
        testEngine.getPumpkins().get(2).setSpeed(1);
        testEngine.getPumpkins().get(2).getRectangle().setFill(Color.AZURE);

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



        loop= new Timeline(new KeyFrame(Duration.millis(10),new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {

                    // Pumpkin Movement
                //testEngine.movePumpkins();
                testEngine.getPumpkins().get(2).moveLeft();
                pumpkin.moveLeft();


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
                    witch.moveFigure(0, 1);
                } else {
                    witch.moveFigure(0, -1);
                }

            } else if (e.getCode().equals(KeyCode.S)) {
                if (witch.getRectangle().getY() >= witchDashScene.getHeight() - witch.getRectangle().getHeight()) {
                    witch.moveFigure(0, -1);
                } else {
                    witch.moveFigure(0, +1);
                }

            } else if (e.getCode().equals(KeyCode.D)) {
                if (witch.getRectangle().getX() >= witchDashScene.getWidth() - witch.getRectangle().getWidth()) {
                    witch.moveFigure(-1, 0);
                } else {
                    witch.moveFigure(1, 0);
                }

            } else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {
                if (witch.getRectangle().getX() <= 0) {

                    witch.moveFigure(+1, 0);
                } else {
                    witch.moveFigure(-1, 0);
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
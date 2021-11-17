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
import javafx.scene.Node;


public class MainTestClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //définition Squares parameter
        int positionwX = 100;
        int positionwY = 100;
        int positionoX = 250;
        int positionoY = 250;
        int hit_boxWidth = 25;
        int hit_boxHeight = 25;

        FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.
                class.
                getResource("witchDash-view.fxml"));

        //Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);

        stage.setTitle("Witch Dash");

        Witch witch = new Witch();
        Pumpkin pumpkin =new Pumpkin();

        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1 = new Rectangle(200, 20, 20, 20);
        root.getChildren().addAll(rectangle1,pumpkin.getRectangle());


        /*timeline diffinition
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                new KeyValue (witch.getRectangle().translateXProperty(), 25), new KeyValue (rectangle1.translateXProperty(), 25)));
*/

        //Scene creation
        int SceneXsize = 800;
        int SceneYsize = 400;
        Scene witchDashScene = new Scene(root, SceneXsize, SceneYsize);
        stage.setScene(witchDashScene);
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
        Timeline loop = new Timeline(new KeyFrame(Duration.millis(5),
                new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {

                // Pumpkin Movement
                pumpkin.movePumpkin(1,0);

                // haut
                if (ball.getCenterY() <= (rball / 2)) {
                    ballSpeedY = -dy;
                }

                // bas
                if (ball.getCenterY() >= rectY) {
                    if (ball.getCenterX() >= joueur.getX() && ball.getCenterX() <= joueur.getX() + lrect) {
                        dx += 0.25;
                        dy += 0.25;
                        ballSpeedY = dy;
                        score += 1;
                    }
                }

                // gauche
                if (ball.getCenterX() <= (rball / 2)) {
                    ballSpeedX = dx;
                }

                // droit
                if (ball.getCenterX() >= (psx - (rball / 2))) {
                    ballSpeedX = -dx;
                }

                // collision bas
                if (ball.getCenterY() >= (psy - (rball / 2))) {
                    text.setVisible(true);
                    message.setVisible(true);
                    loop.stop();
                }

            }


    }));

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










        public static void main(String[] args) {

        launch();
    }
}
/*package trinat.hexenspiel.hexenspiel;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.Node;
import javafx.util.Duration;

import java.io.IOException;

public class Gegner extends Application {

    @Override
    public void start(Stage stage1) {
        final Rectangle rectangle1 = new Rectangle(100, 100, 150, 100);
        rectangle1.setFill(Color.RED);
        rectangle1.setOpacity(0.5);
        final Pane root = new Pane();
        root.getChildren().setAll(rectangle1);
        final Scene scene1 = new Scene(root, 600, 600);
        stage1.setTitle("Affichage d'un rectangle");
        stage1.setScene(scene1);
        stage1.show();
        final KeyFrame keyFrameAt0s = new KeyFrame(Duration.ZERO, new KeyValue(rectangle1.widthProperty(), 50));
        final KeyFrame keyFrameAt1s = new KeyFrame(Duration.seconds(1), new KeyValue(rectangle1.widthProperty(), 100));
        final KeyFrame keyFrameAt0s1 = new KeyFrame(Duration.ZERO, new KeyValue(rectangle1.heightProperty(), 50));
        final KeyFrame keyFrameAt1s1 = new KeyFrame(Duration.seconds(1), new KeyValue(rectangle1.heightProperty(), 200));
        final Timeline timeline = new Timeline(keyFrameAt0s, keyFrameAt1s, keyFrameAt0s1, keyFrameAt1s1);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.playFromStart();

    }

    public static void main(String[] args) {
        launch(args);
    }


} */

package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A simple JavaFX animation examples. Animates a Circle's X property by
 * translating (moving) it 200 points over 10 seconds.
 */

public class Gegner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        int x = 0;

        Rectangle rectangle = new Rectangle(100, 100, Color.BLUE);
        Circle circle = new Circle(50, 150, 50, Color.RED);

        // change circle.translateXProperty from it's current value to 200
        KeyValue keyValue = new KeyValue(rectangle.translateXProperty(), 200);
        KeyValue keyValue1 = new KeyValue(circle.translateXProperty(), 200);

        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue, keyValue1);

        Timeline timeline = new Timeline(keyFrame);

        Group root = new Group(rectangle, circle);

        Scene scene = new Scene(new Pane(rectangle, circle), 300, 250);
        primaryStage.setTitle("Gegner");
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }
}

package trinat.hexenspiel.hexenspiel;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test_button extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Rectangle rectangle = new Rectangle(100, 100, 150, 100);
        rectangle.setFill(Color.RED);
        // Le nœud devient transparent !
        rectangle.setOpacity(0.5);
        final Button button = new Button("Restart");
        button.setLayoutX(100);
        button.setLayoutY(250);
        final Button button1 = new Button("Quit");
        button1.setLayoutX(200);
        button1.setLayoutY(250);
        final Group group = new Group();
        group.getChildren().setAll(rectangle, button, button1);
        final Pane root = new Pane();
        root.getChildren().setAll(rectangle, button, button1);
        final Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Test sur l'opacité");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

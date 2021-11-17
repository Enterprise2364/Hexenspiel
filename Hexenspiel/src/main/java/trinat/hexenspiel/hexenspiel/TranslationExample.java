package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class TranslationExample extends Application {

    @Override
    public void start(Stage stage) {

        final int x = 10;
        final int y = 20;
        final int width = 100;
        final int height = 130;

        // Rectangle1
        Rectangle rectangle1 = new Rectangle(x, y, width, height);

        // Rectangle2 (Same position and size to rectangle1)
        Rectangle rectangle2 = new Rectangle(x, y, width, height);

        rectangle1.setFill(Color.BROWN);
        rectangle1.setStrokeWidth(20);

        rectangle2.setFill(Color.CADETBLUE);
        rectangle2.setStrokeWidth(20);

        // Creating the translation transformation
        Translate translate = new Translate();

        // Set arguments for translation
        translate.setX(200);
        //translate.setY(50);
        //translate.setZ(100);

        // Adding transformation to rectangle2
        rectangle2.getTransforms().addAll(translate);

        Group root = new Group(rectangle1, rectangle2);

        Scene scene = new Scene(root, 450, 250);

        stage.setTitle("JavaFX Translation Transformation (o7planning.org)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}


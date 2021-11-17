package trinat.hexenspiel.hexenspiel;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.HitInfo;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class CollisionTestMain extends Application {
    public void start(Stage witchDashStage) throws IOException {
        boolean test=false;
        Pane root = new Pane();
        Rectangle rectangle1= new Rectangle(20,20,20,20);
        Rectangle rectangle2= new Rectangle(60,60,20,20);
        root.getChildren().add(rectangle1);
        root.getChildren().add(rectangle2);
        Scene scene=new Scene(root,200,200);
        witchDashStage.setTitle("Witch Dash");
        witchDashStage.setScene(scene);
        witchDashStage.show();
        //CollisionTest testVariable = new CollisionTest(rectangle1.getX(),rectangle1.getY(),rectangle1.getWidth(),rectangle1.getHeight(),rectangle2.getX(),rectangle2.getY(),rectangle2.getWidth(),rectangle2.getHeight());
        //test=CollisionTest.testCollision(rectangle2,rectangle1);
        //test = testVariable.testCollision(rectangle1,rectangle2);
        rectangle2.setX(rectangle1.getX()+10);
        rectangle2.setY(rectangle1.getY()-10);
        //test = testVariable.testCollision(rectangle1,rectangle2);
        //test=CollisionTest.testCollision(rectangle2,rectangle1);
        //test=rectangle1.intersects(rectangle2.getX(),rectangle2.getY(),rectangle2.getWidth(),rectangle2.getHeight());


    }
    public static void main(String[] args) {
        launch();
    }

}
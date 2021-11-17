package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;
import javafx.scene.Node;


public class Main_class extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /*timeline diffinition
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                new KeyValue (node.translateXProperty(), 25)));
        timeline.play();*/

        //définition Squares parameter
        int positionwX=100;
        int positionwY=100;
        int positionoX=250;
        int positionoY=250;
        int hit_boxWidth=25;
        int hit_boxHeight=25;

        //squares definition
        Rectangle o= Pumpkin.Hit_box_pumpkin (positionoX,positionoY,hit_boxWidth,hit_boxHeight,2,2);
        Rectangle w=Witch.Hit_box_witch (positionwX,positionwY,hit_boxWidth,hit_boxHeight,2,2);

        //image definition
        //Image w = Witch.Witch_image(stage);

        //Creating a Group object
        Group root = new Group(w,o);

        //scene creation
        int SceneXsize=500;
        int SceneYsize=500;
        Scene playground = new Scene(root,SceneXsize,SceneYsize);
        stage.setScene(playground);
        stage.show();


            // Witch mouvement configuration
            int speed=8;
            playground.setOnKeyPressed(e -> {
                if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {
                    if (w.getY() <=0){
                        Witch.Rectangle_Translation(w,0,speed);
                    }
                    else{
                        Witch.Rectangle_Translation(w,0,-1*speed);
                    }

                }
                else if (e.getCode().equals(KeyCode.S)) {
                    if (w.getY()>= playground.getHeight()-hit_boxHeight){
                        Witch.Rectangle_Translation(w,0,-1*speed);
                    }
                    else {
                        Witch.Rectangle_Translation(w,0,speed);
                    }

                }
                else if (e.getCode().equals(KeyCode.D)) {
                    if (w.getX() >=playground.getWidth()-hit_boxWidth){
                        Witch.Rectangle_Translation(w,-1*speed,0);
                    }
                    else{
                        Witch.Rectangle_Translation(w,speed,0);
                    }

                }
                else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {
                    if (w.getX() <=0){
                        Witch.Rectangle_Translation(w,speed,0);
                    }
                    else{
                        Witch.Rectangle_Translation(w,-1*speed,0);
                    }
                }
                /*
                else if (e.getCode().equals(KeyCode.Z) && e.getCode().equals(KeyCode.D)) {
                    if (w.getY() <=0 || w.getX() >=playground.getWidth()-hit_boxWidth){
                        Witch.Rectangle_Translation(w,-1*speed,speed);
                    }
                    else {
                        Witch.Rectangle_Translation(w,speed,-1*speed);
                    }

                }
                else if (e.getCode().equals(KeyCode.S) && e.getCode().equals(KeyCode.D)) {
                    if (w.getY()>= playground.getHeight()-hit_boxHeight || w.getX() >=playground.getWidth()-hit_boxWidth ){
                        Witch.Rectangle_Translation(w,-1*speed,-1*speed);
                    }
                    else {
                        Witch.Rectangle_Translation(w,speed,speed);
                    }

                }
                else if (e.getCode().equals(KeyCode.S) && e.getCode().equals(KeyCode.Q)) {
                    if (w.getY()>= playground.getHeight()-hit_boxHeight || w.getX() <=0){
                        Witch.Rectangle_Translation(w,speed,-1*speed);
                    }
                    else {
                        Witch.Rectangle_Translation(w,-1*speed,speed);
                    }

                }
                else if (e.getCode().equals(KeyCode.Z) && e.getCode().equals(KeyCode.Q)) {
                    if (w.getY() <=0 || w.getX() <=0){
                        Witch.Rectangle_Translation(w,speed,speed);
                    }
                    else {
                        Witch.Rectangle_Translation(w,-1*speed,-1*speed);
                    }

                }

                 */
            });

            //obstacle mouvement configuration

            for (int i = 0; i <1; i++) {
                if (o.getX()<=-2*o.getWidth()){
                    o.setY(Usefull.Random(SceneYsize-o.getHeight(),0));
                    o.setX(-2*o.getWidth());
                }
                else{
                    Pumpkin.Rectangle_Translation(o,-1*speed);
                    Usefull.Wait(10);
                }
            }
        }






    public static void main(String[] args) {

        launch();
    }
}
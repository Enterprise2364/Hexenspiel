package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import java.io.IOException;

public class Main_class extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //définition Square parameter
        int positionX=10;
        int positionY=10;
        int hit_boxWidth=25;
        int hit_boxHeight=25;

        //square definition
        Rectangle r=Witch.Hit_box_witch (positionX,positionY,hit_boxWidth,hit_boxHeight,2,2);

        //image definition
        //Image w = Witch.Witch_image(stage);

        //Creating a Group object
        Group root = new Group(r);

        //scene creation
        int SceneXsize=500;
        int SceneYsize=500;
        Scene playground = new Scene(root,SceneXsize,SceneYsize);
        stage.setScene(playground);
        stage.show();

        // Witch mouvement configuration

        playground.setOnKeyPressed(e -> {
                if (e.equals(KeyCode.W) || e.equals(KeyCode.Z)) {
                    if (positionY>=0){
                        Witch.Rectangle_Translation(r,positionX,positionY,0,-1);
                    }
                }
                else if (e.equals(KeyCode.S)) {
                    if (positionY<=SceneYsize-hit_boxHeight){
                        Witch.Rectangle_Translation(r,positionX,positionY,0,1);
                    }
                }
                else if (e.equals(KeyCode.D)) {
                    if (positionX<=SceneXsize-hit_boxWidth){
                        Witch.Rectangle_Translation(r,positionX,positionY,1,0);
                    }
                }
                else if (e.equals(KeyCode.Q) || e.equals(KeyCode.A)) {
                    if (positionX>=0){
                        Witch.Rectangle_Translation(r,positionX,positionY,-1,0);
                    }
                }
            });


    }



    public static void main(String[] args) {

        launch();
    }
}
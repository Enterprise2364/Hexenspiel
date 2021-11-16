package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.io.IOException;

public class Main_class extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //définition Square parameter
        int startPositionX=10;
        int startPositionY=10;
        int witchBoxWidth=25;
        int witchBoxHeight=25;

        //square definition
         Witch witch= new Witch(startPositionX,startPositionY,witchBoxWidth,witchBoxHeight,2,2);

        //image definition
        //Image w = Witch.Witch_image(stage);

        //Creating a Group object
        Group root = new Group(witch.getRectangle());

        //scene creation
        int SceneXsize=500;
        int SceneYsize=500;
        Scene playground = new Scene(root,SceneXsize,SceneYsize);
        stage.setScene(playground);
        stage.show();

        // Witch mouvement configuration e.getCode().equals(KeyCode.W
        int speed=8;
        playground.setOnKeyPressed(e -> {
                if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {
                    if (witch.getRectangle().getY() >=0){
                        witch.moveWitch(0,-1);
                    }

                }
                else if (e.getCode().equals(KeyCode.S)) {
                    if (witch.getRectangle().getY()<= playground.getHeight()-witchBoxHeight){
                        witch.moveWitch(0,1);
                    }

                }
                else if (e.getCode().equals(KeyCode.D)) {
                    if (witch.getRectangle().getX() <=playground.getWidth()-witchBoxWidth){
                        witch.moveWitch(1,0);
                    }

                }
                else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {
                    if (witch.getRectangle().getX() >=0){

                        witch.moveWitch(-1,0);
                    }

                }
            });


    }



    public static void main(String[] args) {

        launch();
    }
}
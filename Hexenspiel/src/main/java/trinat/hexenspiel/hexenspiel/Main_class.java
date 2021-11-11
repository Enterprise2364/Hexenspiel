package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_class extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main_class.class.getResource("hello-view.fxml"));
        int SceneXsize=320;
        int SceneYsize=240;
        Scene scene = new Scene(fxmlLoader.load(),SceneXsize,SceneYsize);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        int positionX=10;
        int positionY=10;
        int hit_boxWidth=25;
        int hit_boxHeight=25;

        Rectangle r=Witch.hit_box (positionX,positionY,hit_boxWidth,hit_boxHeight,2,2);
        scene.setOnKeyPressed(e -> {
            if (e.equals(KeyCode.W) || e.equals(KeyCode.Z)) {
                if (positionX>=0){
                    Witch.Rectangle_Translation(r,positionX,positionY,-1,0);
                }
            }
            else if (e.equals(KeyCode.S)) {
                if (positionX<=SceneXsize-hit_boxHeight){
                    Witch.Rectangle_Translation(r,positionX,positionY,1,0);
                }
            }
            else if (e.equals(KeyCode.D)) {
                if (positionY<=SceneYsize-hit_boxWidth){
                    Witch.Rectangle_Translation(r,positionX,positionY,0,1);
                }
            }
            else if (e.equals(KeyCode.Q)) {
                if (positionY>=0){
                    Witch.Rectangle_Translation(r,positionX,positionY,0,-1);
                }
            }
        });
    }



    public static void main(String[] args) {
        launch();
    }
}
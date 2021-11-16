package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class WitchDashMain extends Application {
    @Override
    public void start(Stage witchDashStage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(WitchDashMain.
                                                class.
                                                getResource("witchDash-view.fxml"));

        //Scene witchDashScene = new Scene(fxmlLoader.load(), 800, 400);

        witchDashStage.setTitle("Witch Dash");

        Witch witch= new Witch();

        Group root = new Group(witch.getRectangle());
        Rectangle rectangle1= new Rectangle(200,20,20,20);
        root.getChildren().add(rectangle1);

        //Scene creation
        int SceneXsize=800;
        int SceneYsize=400;
        Scene witchDashScene = new Scene(root,SceneXsize,SceneYsize);
        witchDashStage.setScene(witchDashScene);
        witchDashStage.show();

        witchDashScene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {
                if (witch.getRectangle().getY() >=0){
                    witch.moveWitch(0,-1);
                }

            }
            else if (e.getCode().equals(KeyCode.S)) {
                if (witch.getRectangle().getY()<= witchDashScene.getHeight()-witch.getRectangle().getHeight()){
                    witch.moveWitch(0,1);
                }

            }
            else if (e.getCode().equals(KeyCode.D)) {
                if (witch.getRectangle().getX() <=witchDashScene.getWidth()-witch.getRectangle().getWidth()){
                    witch.moveWitch(1,0);
                }

            }
            else if (e.getCode().equals(KeyCode.Q) || e.getCode().equals(KeyCode.A)) {
                if (witch.getRectangle().getX() >=0){

                    witch.moveWitch(-1,0);
                }

            }
            else {
                if(witch.testCollision(rectangle1)){
                    witch.getRectangle().setFill(Color.RED);
                }
            }
        });




    }


    public static void main(String[] args) {
        launch();
    }
}
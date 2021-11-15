package witchdash;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {


    public Rectangle witch;
    public Rectangle pumpkin;
    public int posX = 50;
    public int posY = 200;
    public int height = 100;
    public int width = 40;
    public int sceneSizeX = 600;
    public int sceneSizeY = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Witchdash");

        Group root = new Group();
        Scene scene = new Scene(root,sceneSizeX,sceneSizeY, Color.BURLYWOOD);
        stage.setScene(scene);

        Button butt = new Button("Pause");
        this.witch = new Witch(posX,posY, width, height);
        root.getChildren().addAll(witch, butt);
        stage.show();
        //Pause Menu
        butt.setOnAction(e -> pause());

        scene.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.Z)) {
                if (posX>=0){
                    Witch.Rectangle_Translation(witch,posX,posY,-1,0);
                }
            }
            else if (e.getCode().equals(KeyCode.S)) {
                if (posX<=sceneSizeX-height){
                    Witch.Rectangle_Translation(witch,posX,posY,1,0);
                }
            }
        });


        /* //für auf und abbewegung
        .addEventHandler(KeyEvent.KEY_PRESSED,
                e -> {pause();}
                );

         */
    }


    public void pause() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("PAUSEMENU");
        alert.setHeaderText("Game is paused!");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Continue");
        ButtonType buttonTypeTwo = new ButtonType("Rules");
        ButtonType buttonTypeCancel = new ButtonType("Close Game", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // Open Rules
        } else {
            //Close the game
            Platform.exit();
        }
    }


}

package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.transform.Translate;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Witch {
    public static Rectangle Hit_box_witch (int positionX,int positionY,int Width,int Height,int ArcWidth,int ArcHeight){
        //creating a shape
        Rectangle witch = new Rectangle();
        witch.setX(positionX);
        witch.setY(positionY);
        witch.setWidth(Width);
        witch.setHeight(Height);
        witch.setArcWidth(ArcWidth);
        witch.setArcHeight(ArcHeight);
        witch.setFill(Color.BLUE);
        //returning the shape
        return witch;
    }

    /*public static Image Witch_image (Stage primaryStage){
        //calling an image
        InputStream iconStream = Witch.class.getResourceAsStream("src/main/resources/trinat/hexenspiel/hexenspiel/witch.png");
        Image witch = new Image(iconStream);
        //adding tne image to the stage
        primaryStage.getIcons().add(witch);
        //returning the image
        return witch;
    }*/

    public static Rectangle Rectangle_Translation(Rectangle rInterior,int changementX,int changementY){
        //Setting the X,Y,Z coordinates to apply the translation
        rInterior.setX(rInterior.getX()+changementX);
        rInterior.setY(rInterior.getY()+changementY);
        return rInterior;

    }
}


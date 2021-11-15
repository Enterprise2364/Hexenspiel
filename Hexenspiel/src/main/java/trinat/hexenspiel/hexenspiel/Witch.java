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
        Rectangle r = new Rectangle();
        r.setX(positionX);
        r.setY(positionY);
        r.setWidth(Width);
        r.setHeight(Height);
        r.setArcWidth(ArcWidth);
        r.setArcHeight(ArcHeight);
        r.setFill(Color.BLUE);
        //returning the shape
        return r;
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
        //Creating the translation transformation
        Translate translate = new Translate();

        //Setting the X,Y,Z coordinates to apply the translation
        translate.setX(changementX);
        translate.setY(changementY);
        translate.setZ(0);
        //Adding transformation to hit_box
        rInterior.getTransforms().addAll(translate);
        //returning the transformation
        return rInterior;

    }
}


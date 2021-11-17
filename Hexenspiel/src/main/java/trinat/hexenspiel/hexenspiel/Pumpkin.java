package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pumpkin {
    public static Rectangle Hit_box_pumpkin(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
        //creating a shape
        Rectangle pumpkin = new Rectangle();
        pumpkin.setX(positionX);
        pumpkin.setY(positionY);
        pumpkin.setWidth(Width);
        pumpkin.setHeight(Height);
        pumpkin.setArcWidth(ArcWidth);
        pumpkin.setArcHeight(ArcHeight);
        pumpkin.setFill(Color.RED);
        //returning the shape
        return pumpkin;
    }

    /*public static Image Obstacle_image (Stage primaryStage){
        //calling an image
        InputStream iconStream = Obstacle.class.getResourceAsStream("src/main/resources/trinat/hexenspiel/hexenspiel/witch.png");
        Image witch = new Image(iconStream);
        //adding tne image to the stage
        primaryStage.getIcons().add(witch);
        //returning the image
        return witch;
    }*/

    public static Rectangle Rectangle_Translation(Rectangle rInterior,int changementX){
        //Setting the X coordinates to apply the translation
        rInterior.setX(rInterior.getX()+changementX);
        return rInterior;

    }
}

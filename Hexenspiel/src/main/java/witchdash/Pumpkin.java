package witchdash;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pumpkin extends Rectangle{

    public Pumpkin (int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
        Rectangle pumpkin = new Rectangle();
        this.setX(positionX);
        this.setY(positionY);
        this.setWidth(Width);
        this.setHeight(Height);
        this.setArcWidth(ArcWidth);
        this.setArcHeight(ArcHeight);
        this.setFill(Color.ORANGE);
    }
    public static Rectangle Rectangle_Translation(Rectangle rInterior,int changementX){
        //Setting the X,Y,Z coordinates to apply the translation
        rInterior.setX(rInterior.getX()+changementX);
        return rInterior;

    }



}

/*
import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;

public class Obstacle {
    public static Rectangle Hit_box_obstacle (int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
        //creating a shape
        Rectangle r = new Rectangle();
        r.setX(positionX);
        r.setY(positionY);
        r.setWidth(Width);
        r.setHeight(Height);
        r.setArcWidth(ArcWidth);
        r.setArcHeight(ArcHeight);
        r.setFill(Color.RED);
        //returning the shape
        return r;
    }

    public static Image Obstacle_image (Stage primaryStage){
        //calling an image
        InputStream iconStream = Obstacle.class.getResourceAsStream("src/main/resources/trinat/hexenspiel/hexenspiel/witch.png");
        Image witch = new Image(iconStream);
        //adding tne image to the stage
        primaryStage.getIcons().add(witch);
        //returning the image
        return witch;
    }

    public static Rectangle Rectangle_Translation(Rectangle rInterior,int changementX){
        //Setting the X,Y,Z coordinates to apply the translation
        rInterior.setX(rInterior.getX()+changementX);
        return rInterior;

    }
    */
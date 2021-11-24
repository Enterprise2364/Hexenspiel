package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.*;
import javafx.scene.shape.*;


public class Witch extends GameFigures {
    private Rectangle rectangle = super.getRectangle();
    private int speed = 8;


    public Witch() {
        super();
        this.rectangle.setX(10);
        this.rectangle.setY(10);
        this.rectangle.setHeight(25);
        this.rectangle.setWidth(25);
        this.rectangle.setFill(Color.BLUE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
    }

    public Witch(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
        super();
        this.rectangle.setX(positionX);
        this.rectangle.setY(positionY);
        this.rectangle.setWidth(Width);
        this.rectangle.setHeight(Height);
        this.rectangle.setArcWidth(ArcWidth);
        this.rectangle.setArcHeight(ArcHeight);
        this.rectangle.setFill(Color.BLUE);
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

}


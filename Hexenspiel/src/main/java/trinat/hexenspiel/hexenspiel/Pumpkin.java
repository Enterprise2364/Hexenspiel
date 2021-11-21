package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pumpkin extends GameFigures {
    private Rectangle rectangle = super.getRectangle();
    private int speed = 8;

    public Pumpkin(int sceneWidht, int scenePositionY, int sceneHeight) {
        super();
        this.rectangle.setHeight(20);
        this.rectangle.setWidth(20);
        this.rectangle.setFill(Color.ORANGE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
        this.rectangle.setX(sceneWidht);
        this.rectangle.setY(WitchDashRandomGenerator.random(scenePositionY, scenePositionY + sceneHeight - this.rectangle.getHeight()));

    }

    public Pumpkin(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight) {
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

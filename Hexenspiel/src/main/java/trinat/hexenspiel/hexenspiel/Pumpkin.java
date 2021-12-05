package trinat.hexenspiel.hexenspiel;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pumpkin extends GameFigures {
    private Rectangle rectangle = super.getRectangle();
    private int speed = 8;

    public Pumpkin(double sceneWidth,
                   double scenePositionY,
                   double sceneHeight) {
        super();
        this.rectangle.setHeight(20);
        this.rectangle.setWidth(20);
        this.rectangle.setFill(Color.ORANGE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
        this.rectangle.setX(sceneWidth);
        this.rectangle.setY(RandomNumberGenerator.random(0,
                                                        (sceneHeight) - this.rectangle.getHeight()));

    }

    public Pumpkin(double sceneWidth, double scenePositionY, double sceneHeight,double positionX, double positionY, double Width, double Height, double ArcWidth, double ArcHeight) {
        super();
        this.rectangle.setX(positionX);
        this.rectangle.setY(RandomNumberGenerator.random(scenePositionY, scenePositionY + sceneHeight - this.rectangle.getHeight()));
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

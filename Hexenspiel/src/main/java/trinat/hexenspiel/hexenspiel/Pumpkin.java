package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pumpkin {
    private Rectangle rectangle = new Rectangle();
    private int speed =8;

    public Pumpkin(int sceneWidht,int scenePositionY,int sceneHeight) {
        this.rectangle.setHeight(20);
        this.rectangle.setWidth(20);
        this.rectangle.setFill(Color.ORANGE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
        this.rectangle.setX(sceneWidht);
        this.rectangle.setY(WitchDashRandomGenerator.random(scenePositionY,scenePositionY+sceneHeight-this.rectangle.getHeight()));

    }

    public Pumpkin(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
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

    public void movePumpkin(int translateX,int translateY){
        this.rectangle.setX(this.rectangle.getX()+translateX*this.speed);
        this.rectangle.setY(this.rectangle.getY()+translateY*this.speed);
    }

    public void moveDown() {
        this.rectangle.setY(this.rectangle.getY() - this.speed);
    }

    public void moveUp() {
        this.rectangle.setY(this.rectangle.getY() + this.speed);
    }

    public void moveRight() {
        this.rectangle.setX(this.rectangle.getX() + this.speed);
    }

    public void moveLeft() {
        this.rectangle.setX(this.rectangle.getX() - this.speed);
    }

    public boolean testCollision(Rectangle rectangle){
        CollisionTest collision = new CollisionTest(this.rectangle);
        return collision.testCollision(rectangle);
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

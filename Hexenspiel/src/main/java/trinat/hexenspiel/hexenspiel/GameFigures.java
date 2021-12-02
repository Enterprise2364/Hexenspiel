package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class GameFigures {
    private Rectangle rectangle = new Rectangle();
    private int speed =8;



    /*public static Image Witch_image (Stage primaryStage){
        //calling an image
        InputStream iconStream = Witch.class.getResourceAsStream("src/main/resources/trinat/hexenspiel/hexenspiel/witch.png");
        Image witch = new Image(iconStream);
        //adding tne image to the stage
        primaryStage.getIcons().add(witch);
        //returning the image
        return witch;
    }*/

    public void moveFigure(int translationX,int translationY){
        this.rectangle.setX(this.rectangle.getX()+translationX*this.speed);
        this.rectangle.setY(this.rectangle.getY()+translationY*this.speed);
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

    public void setToRandomYPosition(double sceneWidth,
                                     double scenePositionY,
                                     double sceneHeight){
        this.rectangle.setY(RandomNumberGenerator.random(0.0,
                sceneHeight - this.rectangle.getHeight()));
    }
}




package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.*;
import javafx.scene.shape.*;


public class Witch {
    private Rectangle rectangle = new Rectangle();
    private int witchSpeed=8;

    public Witch() {
        this.rectangle.setX(10);
        this.rectangle.setY(10);
        this.rectangle.setHeight(25);
        this.rectangle.setWidth(25);
        this.rectangle.setFill(Color.BLUE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
    }

    public Witch(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
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

    public void moveWitch(int changementX,int changementY){
        this.rectangle.setX(this.rectangle.getX()+changementX*this.witchSpeed);
        this.rectangle.setY(this.rectangle.getY()+changementY*this.witchSpeed);
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

    public int getWitchSpeed() {
        return witchSpeed;
    }

    public void setWitchSpeed(int witchSpeed) {
        this.witchSpeed = witchSpeed;
    }
}


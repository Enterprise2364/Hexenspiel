package trinat.hexenspiel.hexenspiel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Boss {

    //initial boss parameter
    private Rectangle rectangle = new Rectangle();
    private int witchSpeed=8;
    private Life bosslife=new Life(6,0);

    //boss hit_box initialisation
    public Boss() {
        this.rectangle.setX(10);
        this.rectangle.setY(10);
        this.rectangle.setHeight(25);
        this.rectangle.setWidth(25);
        this.rectangle.setFill(Color.BLUE);
        this.rectangle.setArcWidth(2);
        this.rectangle.setArcHeight(2);
    }

    //boss hit_box modification
    public Boss(int positionX, int positionY, int Width, int Height, int ArcWidth, int ArcHeight){
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

    //Boss mouvement
    public void moveBoss(int changementX,int changementY){
        this.rectangle.setX(this.rectangle.getX()+changementX*this.witchSpeed);
        this.rectangle.setY(this.rectangle.getY()+changementY*this.witchSpeed);
    }

    //Boss life modification
    public Life TemporaryBosslife(Rectangle projectil,Life bosslife){
        CollisionTest collision = new CollisionTest(this.rectangle);
        if (collision.testCollision(projectil)){
            this.bosslife.addHitPoint();
        }
        return bosslife;
    }

    // get hit_box parameter
    public Rectangle getRectangle() {
        return rectangle;
    }

    // set hit_box parameter
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    // get Boss speed
    public int getWitchSpeed() {
        return witchSpeed;
    }

    // set Boss speed
    public void setWitchSpeed(int witchSpeed) {
        this.witchSpeed = witchSpeed;
    }
}

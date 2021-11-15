package trinat.hexenspiel.hexenspiel;

import javafx.scene.shape.Rectangle;

public class CollisionTest {
    private Rectangle myRectangle= new Rectangle();
    private double X;
    private double Y;
    private double Width;
    private double Height;


    public CollisionTest(double myX, double myY, double myWidth, double myHeight, double x, double y, double width, double height) {
        myRectangle.setX(myX);
        myRectangle.setY(myY);
        myRectangle.setWidth(myWidth);
        myRectangle.setHeight(myHeight);
        X = x;
        Y = y;
        Width = width;
        Height = height;
    }
    public CollisionTest(Rectangle myRectangle,Rectangle rectangle) {
        this.myRectangle.setX(myRectangle.getX());
        this.myRectangle.setY(myRectangle.getY());
        this.myRectangle.setWidth(myRectangle.getWidth());
        this.myRectangle.setHeight(myRectangle.getHeight());
        X = rectangle.getX();
        Y = rectangle.getY();
        Width = rectangle.getWidth();
        Height = rectangle.getHeight();
    }

    public static boolean testCollision(Rectangle myRectangle,Rectangle rectangle){
        return myRectangle.intersects(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }


}

package trinat.hexenspiel.hexenspiel;


import javafx.scene.shape.Rectangle;

public class CollisonTest {
    private Rectangle myRectangle= new Rectangle();
    private Rectangle rectangle= new Rectangle();

    public CollisonTest(double myX, double myY, double myWidth, double myHeight, double x, double y, double width, double height) {
        myRectangle.setX(myX);
        myRectangle.setY(myY);
        myRectangle.setWidth(myWidth);
        myRectangle.setHeight(myHeight);
        myRectangle.setX(x);
        myRectangle.setY(y);
        myRectangle.setWidth(width);
        myRectangle.setHeight(height);
    }
    public CollisonTest(Rectangle myRectangle, Rectangle rectangle) {
        this.myRectangle=myRectangle;
        this.rectangle=rectangle;
    }

    public CollisonTest(Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

    public static boolean testCollision(Rectangle myRectangle, Rectangle rectangle){
        return myRectangle.intersects(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }
    public boolean testCollision(Rectangle rectangle){
        return this.myRectangle.intersects(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }
    public boolean testCollison(double x, double y, double width, double height){
        return this.myRectangle.intersects(x,y,width,height);
    }
    public boolean testCollision(){
        return this.myRectangle.intersects(this.rectangle.getX(),this.rectangle.getY(),this.rectangle.getWidth(),this.rectangle.getHeight());
    }


}
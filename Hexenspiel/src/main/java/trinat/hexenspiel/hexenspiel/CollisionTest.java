package trinat.hexenspiel.hexenspiel;
import javafx.scene.shape.Rectangle;

public class CollisionTest {
    private Rectangle myRectangle= new Rectangle();
    private Rectangle rectangle= new Rectangle();

    //Constructor for the case when the collison of two rectangles need to be checked multiple times
    public CollisionTest(Rectangle myRectangle,Rectangle rectangle) {
        this.myRectangle=myRectangle;
        this.rectangle=rectangle;
    }

    //Constructor for the case that one Rectangle need to check collisons with multiple objects
    public CollisionTest(Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

    //Static methode for checking of the position without creating a new instance
    public static boolean testCollision(Rectangle myRectangle, Rectangle rectangle){
        return myRectangle.intersects(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }

    //Method to check if the rectangle linked to the TestCollison object is colliding with the rectancle give with the argument
    public boolean testCollision(Rectangle rectangle){
        return this.myRectangle.intersects(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
    }

    //Method to check if the rectangle linked to the TestCollison object is colliding with a rectangular surface
    public boolean testCollison(double x, double y, double width, double height){
        return this.myRectangle.intersects(x,y,width,height);
    }

    //Method to check if the two linked Rectangles are colliding
    public boolean testCollision(){
        //ToDo Chatch the case when there is no Rectangle;
        return this.myRectangle.intersects(this.rectangle.getX(),this.rectangle.getY(),this.rectangle.getWidth(),this.rectangle.getHeight());
    }

}

package witchdash;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class Witch extends Rectangle {


    public Witch(double posX, double posY, double width, double height) {
        super(width,height,Color.CORNFLOWERBLUE);
        this.setX(posX);
        this.setY(posY);
        this.setArcWidth(2);
        this.setArcHeight(2);
    }

    public static void Rectangle_Translation(Rectangle rInterior,int positioninitialX, int positioninitialY,int changementX,int changementY){
        //Creating the translation transformation
        Translate translate = new Translate();

        //Setting the X,Y,Z coordinates to apply the translation
        translate.setX(positioninitialX+changementX);
        translate.setY(positioninitialY+changementY);
        translate.setZ(0);
        //Adding transformation to hit_box
        rInterior.getTransforms().addAll(translate);

    }
}

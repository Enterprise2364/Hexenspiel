package trinat.hexenspiel.hexenspiel;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.*;
import javafx.scene.transform.Translate;
import java.util.Scanner;

public class Witch {
    public static Rectangle hit_box (int positionX,int positionY,int Width,int Height,int ArcWidth,int ArcHeight){
        //creating a shape
        Rectangle r = new Rectangle();
        r.setX(positionX);
        r.setY(positionY);
        r.setWidth(Width);
        r.setHeight(Height);
        r.setArcWidth(ArcWidth);
        r.setArcHeight(ArcHeight);
        r.setFill(Color.BLUE);
        return r;
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


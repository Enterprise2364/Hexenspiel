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

/*
accéder à une image avec javafx.scene.image.Image

méthode 1
final URL imageURL = getClass().getResource("image.png");
final Image image = new Image(imageURL.toExternalForm());

méthode2
final String imageURI = new File("C://image.png").toURI().toString();
final Image image = new Image(imageURI);

méthode 3
final String imageURI = new File("C://image.png").toURI().toString();
final Image image = new Image(imageURI);

méthode 4
final HostServices services = application.getHostServices();
final String imageURI = services.resolveURI(services.getDocumentBase(), "image.jpg");
final Image image = new Image(imageURI);
 */

/*
afficher une iamge
public class NodeImage extends Application {

    @Override
    public void start(Stage primaryStage) {
        final URL imageURL = getClass().getResource("image.png");
        final Image image = new Image(imageURL.toExternalForm());
        final ImageView imageView = new ImageView(image);
        final Pane root = new Pane();
        root.getChildren().setAll(imageView);
        final Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Test d'affichage d'image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

 */

/*
changer la taille d'une image

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final URL imageURL = getClass().getResource("image.png");
        final Image image = new Image(imageURL.toExternalForm());
        final ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(100);
        final Pane root = new Pane();
        root.getChildren().setAll(imageView);
        final Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Test d'affichage d'image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 */

/*
afficher une partie d'une image *
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final URL imageURL = getClass().getResource("image.png");
        final Image image = new Image(imageURL.toExternalForm());
        final ImageView imageView = new ImageView(image);
        final Rectangle2D viewport = new Rectangle2D(75, 4, 90, 80);
        imageView.setViewport(viewport);
        final Pane root = new Pane();
        root.getChildren().setAll(imageView);
        final Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Test d'affichage d'image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 */

/*
récupérer la valeur d'un pixel d'une image

final URL imageURL = getClass().getResource("image.png");
final Image image = new Image(imageURL.toExternalForm());
final PixelReader pixelReader = image.getPixelReader();
final Color color = pixelReader.getColor(20, 20);
 */

/*
modifier la valeur d' un pixel

final WritableImage image = new WritableImage(350, 300);
final PixelWriter pixelWriter = image.getPixelWriter();
pixelWriter.setColor(20, 20, Color.RED);
 */

/*
translation d'un objet

import javafx.scene.transform.Translate;

      //Creating the translation transformation
      Translate translate = new Translate();

      //Setting the X,Y,Z coordinates to apply the translation
      translate.setX(300);
      translate.setY(50);
      translate.setZ(100);

      //Adding transformation to circle
      circle.getTransforms().addAll(translate);
 */

public class RectangleTranslation extends Application {
    @Override
    public void start(Stage stage)throws FileNotFoundException{

        Group root =new Group();
        int largeur=500;
        int longueur=500;
        Scene scene = new Scene(root,largeur,longueur,Color.BLACK);

        int positionX =25;
        int positionY =25;
        Rectangle rInterior= shape(positionX,positionY,25 ,25,2,2);

        //showing the stage
        stage.setTitle("Javafx Scene Graph Demo");
        stage.setScene(scene);
        /*for (int i = 0; i <100; i++) {
            Scanner Clavier = new Scanner(System.in);
            String entrée_clavier = Clavier.next();
            if (entrée_clavier=="z"){
                Translation(rInterior,positionX,positionY,1,0);
            }
        }*/
        stage.show();

    }

    public static void Translation(Rectangle rInterior,int positioninitialX, int positioninitialY,int changementX,int changementY){

        //Creating the translation transformation
        Translate translate = new Translate();

        //Setting the X,Y,Z coordinates to apply the translation
        translate.setX(positioninitialX+changementX);
        translate.setY(positioninitialY+changementY);
        translate.setZ(0);
        //Adding transformation to circle
        rInterior.getTransforms().addAll(translate);
    }

    public static Rectangle shape(int positionX,int positionY,int Width,int Height,int ArcWidth,int ArcHeight){
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
        //root.getChildren().add(r);
    }

    public static void main(String[] args) {
        launch(args);

    }
}
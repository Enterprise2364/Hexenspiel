package trinat.hexenspiel.hexenspiel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WitchDashEngineTest {
    WitchDashEngine testEngine;
    ArrayList <Pumpkin> testPumpkins;
    Pumpkin testPumpkin;
    Stage testStage;
    Group testGroup;
    Scene testScene;
    int sceneWidth ;
    int sceneHeight;
    @BeforeEach
    public void setUp(){
        sceneWidth = 800;
        sceneHeight = 400;
        testPumpkin= new Pumpkin(800,
                0,
                400,390,190,20,20,2,2);
        testEngine=new WitchDashEngine(sceneWidth,0,sceneHeight,0);
        testEngine.getPumpkins().add(new Pumpkin(800,
                0,
                400,0,0,20,20,2,2));
        testEngine.getPumpkins().add(new Pumpkin(800,
                0,
                400,0,380,20,20,2,2));
        testEngine.getPumpkins().add(new Pumpkin(800,
                0,
                400,780,0,20,20,2,2));
        testEngine.getPumpkins().add(new Pumpkin(800,
                0,
                400,780,380,20,20,2,2));


    }

    @Test
    public void testTestCollisionWithPumpkins(){
        //Test Engine Pumpkin 2 is at the position (0;380)
        //Test Pumkin  is at the position (0;365)
        testPumpkin.getRectangle().setY(365);
        testPumpkin.getRectangle().setX(0);
        //Collision must be true

        assertEquals(true, testEngine.testCollisionWithPumpkins(testPumpkin,testEngine.getPumpkins()));

    }

    @Test
    public void testTestCollisionWitchPumpkin(){
        //Pumpkin 0 in array of test Engine is on coordinates (0,0)
        //Witch of test Engine is at (10,10)
        //They collide because the Pumpkin is 20x20
        assertEquals(true,testEngine.testCollisionWitchPumpkins());
    }



}

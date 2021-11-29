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
        testEngine=new WitchDashEngine(sceneWidth,0,sceneHeight,0);
        testPumpkin = new Pumpkin(800,
                0,
                400);
    }

    @Test
    public void testTestIfSameYPosition(){
        testPumpkin.getRectangle().setY(60);
        testEngine.getPumpkins().add(testPumpkin);
        Pumpkin testPumpkin1=new Pumpkin(800,
                0,
                400);
        testPumpkin1.getRectangle().setY(50);
        assertEquals(true, testEngine.testIfSameYPosition(testEngine.getPumpkins(),testPumpkin1));

    }


}

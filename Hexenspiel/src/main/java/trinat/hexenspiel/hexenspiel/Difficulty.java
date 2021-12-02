package trinat.hexenspiel.hexenspiel;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Difficulty {

    public Button buttonEasy;
    public Button buttonMedium;
    public Button buttonHard;
    //different speed
    public int speed;
    public int niveau;
    //Multiple Obstacle
    public int obstacleNumber;

    //Setting parameter for different niveaus
    public void buttonEasyPressed(ActionEvent actionEvent) {
        niveau = 1;
        speed = 1;
        obstacleNumber = 10;
        MainTestClass.witchDashMainScene(obstacleNumber,speed);
    }

    public void buttonMediumPressed(ActionEvent actionEvent) {
        niveau = 2;
        speed = 2;
        obstacleNumber = 15;
        MainTestClass.witchDashMainScene(obstacleNumber,speed);
    }

    public void buttonHardPressed(ActionEvent actionEvent) {
        niveau = 3;
        speed = 3;
        obstacleNumber = 20;
        MainTestClass.witchDashMainScene(obstacleNumber,speed);
    }
}

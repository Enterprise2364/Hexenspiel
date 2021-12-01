package trinat.hexenspiel.hexenspiel;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Difficulty {

    public Button buttonEasy;
    public Button buttonMedium;
    public Button buttonHard;
    //different speed
    public int speed;
    public int moreSpeed;
    public int niveau;
    //Multiple Obstacle
    public int spawnFrequency;

    //Setting parameter for different niveaus
    public void buttonEasyPressed(ActionEvent actionEvent) {
        niveau = 1;
        speed = 1;
        spawnFrequency = 3;
        moreSpeed = 0;
    }

    public void buttonMediumPressed(ActionEvent actionEvent) {
        niveau = 2;
        speed = 2;
        spawnFrequency = 5;
        moreSpeed = 0;
    }

    public void buttonHardPressed(ActionEvent actionEvent) {
        niveau = 3;
        speed = 3;
        spawnFrequency = 7;
        moreSpeed = 0;
    }
}

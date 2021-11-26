package trinat.hexenspiel.hexenspiel;

import javafx.stage.Stage;

import java.util.ArrayList;

public class WitchDashEngine {
    private Stage witchDashMainStage;
    private ArrayList<Pumpkin>pumpkins=new ArrayList<>();

    public WitchDashEngine(Stage stage,int obstacleNumber){
        this.witchDashMainStage=stage;
        for(int i=0;i<obstacleNumber;i++){
            pumpkins.add(new Pumpkin(this.witchDashMainStage.getWidth(),this.witchDashMainStage.getY(),this.witchDashMainStage.getHeight()));

        }
    }

    public void movePumpkins(){
        for(Pumpkin pumpkin: pumpkins) {
            pumpkin.moveLeft();
        }
    }

    public void moveFigures(){

    }

    public Stage getWitchDashMainStage() {
        return witchDashMainStage;
    }

    public void setWitchDashMainStage(Stage witchDashMainStage) {
        this.witchDashMainStage = witchDashMainStage;
    }

    public ArrayList<Pumpkin> getPumpkins() {
        return pumpkins;
    }

    public void setPumpkins(ArrayList<Pumpkin> pumpkins) {
        this.pumpkins = pumpkins;
    }
}

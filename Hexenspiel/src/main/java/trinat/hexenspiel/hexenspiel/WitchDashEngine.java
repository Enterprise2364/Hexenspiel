package trinat.hexenspiel.hexenspiel;

import javafx.stage.Stage;

import java.util.ArrayList;

public class WitchDashEngine {
    private Stage witchDashMainEngineStage;
    private ArrayList<Pumpkin>pumpkins=new ArrayList<>();

    public WitchDashEngine(Stage stage,int obstacleNumber){
        this.witchDashMainEngineStage = stage;
        for(int i=0;i<obstacleNumber;i++){
            pumpkins.add(new Pumpkin(this.witchDashMainEngineStage.getWidth(),
                                        this.witchDashMainEngineStage.getY(),
                                        this.witchDashMainEngineStage.getHeight()));
            //pumpkins.get(i).getRectangle().getX()-pumpkins.get(i).getRectangle().getWidth();

        }
    }

    public void movePumpkins(){
        for(Pumpkin pumpkin: pumpkins) {
            pumpkin.moveLeft();
        }
    }

    public void moveFigures(){

    }

    public Stage getWitchDashMainEngineStage() {
        return witchDashMainEngineStage;
    }

    public void setWitchDashMainEngineStage(Stage witchDashMainEngineStage) {
        this.witchDashMainEngineStage = witchDashMainEngineStage;
    }

    public ArrayList<Pumpkin> getPumpkins() {
        return pumpkins;
    }

    public void setPumpkins(ArrayList<Pumpkin> pumpkins) {
        this.pumpkins = pumpkins;
    }
}

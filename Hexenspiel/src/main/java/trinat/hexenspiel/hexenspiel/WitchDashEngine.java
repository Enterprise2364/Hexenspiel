package trinat.hexenspiel.hexenspiel;
import javafx.scene.Group;
import javafx.stage.Stage;
import java.util.ArrayList;

public class WitchDashEngine {
    private Stage witchDashMainEngineStage;
    private ArrayList <Pumpkin> pumpkins=new ArrayList<>();
    private Witch witch=new Witch();

    public WitchDashEngine(double sceneWidth, double scenePositionY, double sceneHeight,int obstacleNumber,int witchSpeed,int pumpkinSpeed) {
        for (int i = 0; i < obstacleNumber; i++) {
            pumpkins.add(new Pumpkin(sceneWidth,
                                scenePositionY,
                                sceneHeight));
        }
    }

    public WitchDashEngine(Stage stage,int obstacleNumber,int witchSpeed,int pumpkinSpeed){
        this.witchDashMainEngineStage = stage;
        for(int i=0;i<obstacleNumber;i++){
            pumpkins.add(new Pumpkin(this.witchDashMainEngineStage.getWidth(),
                    this.witchDashMainEngineStage.getY(),
                    this.witchDashMainEngineStage.getHeight()));
            Pumpkin tempPumpkin= new Pumpkin(this.witchDashMainEngineStage.getWidth(),
                    this.witchDashMainEngineStage.getY(),
                    this.witchDashMainEngineStage.getHeight());
            /*if (pumpkins.stream().anyMatch(pumpkin -> pumpkin.getRectangle().getY()>tempPumkin.getRectangle().getY())&& pumpkins.stream().anyMatch(pumpkin -> pumpkin.getRectangle().getY()<(tempPumkin.getRectangle().getY()+tempPumkin.getRectangle().getHeight())){
                tempPumkin.setToRandomYPosition(this.witchDashMainEngineStage.getWidth(),
                                                this.witchDashMainEngineStage.getY(),
                                                this.witchDashMainEngineStage.getHeight());
                pumpkins.add(tempPumkin);
            }
            else{
                pumpkins.add(tempPumkin);
            }*/


        }
    }

    public void movePumpkins(){
        pumpkins.forEach(Pumpkin::moveLeft);
    }



    public void moveFigures(){

    }

    public boolean testIfSameYPosition(ArrayList<Pumpkin> pumpkinsPositionTest,Pumpkin pumpkinPositionTest){
        if(pumpkinsPositionTest.stream().anyMatch(pumpkin -> pumpkin.getRectangle().getY()>pumpkinPositionTest.getRectangle().getY())){//&& (pumpkinsPositionTest.stream().anyMatch(pumpkin -> pumpkinPositionTest.getRectangle().getY()<(pumpkinPositionTest.getRectangle().getY()+pumpkinPositionTest.getRectangle().getHeight())))){
            return true;
        }
        return false;
    }




    public boolean testCollision(){
        for(int i=0;i<this.pumpkins.size();i++){
            if (this.witch.testCollision(this.pumpkins.get(i).getRectangle())) {
                return true;
            }
        }
        return false;
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

    public Witch getWitch() {
        return witch;
    }

    public void setWitch(Witch witch) {
        this.witch = witch;
    }
}

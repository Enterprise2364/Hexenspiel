package trinat.hexenspiel.hexenspiel;
import javafx.scene.Group;
import javafx.stage.Stage;
import java.util.ArrayList;

public class WitchDashEngine {
    private Stage witchDashMainEngineStage;
    private ArrayList <Pumpkin> pumpkins=new ArrayList<>();
    private Witch witch=new Witch();
    private int witchSpeed=10;
    private int pumpkinSpeed=1;

    public WitchDashEngine(double sceneWidth, double scenePositionY, double sceneHeight,int obstacleNumber) {
        witch.setSpeed(witchSpeed);
        for (int i = 0; i < obstacleNumber; i++) {
            Pumpkin tempPumpkin= new Pumpkin(sceneWidth,
                                scenePositionY,
                                sceneHeight);
            while (testIfSameYPosition(pumpkins,tempPumpkin)&&(pumpkins.size()<=5)){

                tempPumpkin.setToRandomYPosition(sceneWidth,
                        scenePositionY,
                        sceneHeight);

            }
            pumpkins.add(tempPumpkin);
            pumpkins.get(i).setSpeed(pumpkinSpeed);
        }
    }

    public WitchDashEngine(Stage stage,int obstacleNumber){
        this.witchDashMainEngineStage = stage;
        witch.setSpeed(witchSpeed);
        for(int i=0;i<obstacleNumber;i++){
            Pumpkin tempPumpkin= new Pumpkin(this.witchDashMainEngineStage.getScene().getWidth(),
                    this.witchDashMainEngineStage.getScene().getY()-this.witchDashMainEngineStage.getScene().getY(),
                    this.witchDashMainEngineStage.getScene().getHeight());
            while (testIfSameYPosition(pumpkins,tempPumpkin)&&(pumpkins.size()<=10)){

                tempPumpkin.setToRandomYPosition(this.witchDashMainEngineStage.getScene().getWidth(),
                                                this.witchDashMainEngineStage.getScene().getY()-this.witchDashMainEngineStage.getScene().getY(),
                                                this.witchDashMainEngineStage.getScene().getHeight());

            }
            pumpkins.add(tempPumpkin);
            pumpkins.get(i).setSpeed(pumpkinSpeed);
        }
    }

    public void movePumpkins(int interval){
        pumpkins.get(0).moveLeft();
        for(int i=1;i<pumpkins.size();i++){
            if (pumpkins.get((i-1)).getRectangle().getX() <= (this.witchDashMainEngineStage.getWidth()-pumpkins.get(i-1).getRectangle().getWidth())- interval){
                pumpkins.get(i).moveLeft();
            }
        }
reappearance();
       /* pumpkins.forEach(Pumpkin::moveLeft);*/
    }

    public void reappearance() {
        for (int i = 0; i < pumpkins.size(); i++) {
            if (pumpkins.get(i).getRectangle().getX() < (this.witchDashMainEngineStage.getMinWidth() - 100 )){
                pumpkins.get(i).getRectangle().setX(witchDashMainEngineStage.getWidth());
                pumpkins.get(i).setToRandomYPosition(this.witchDashMainEngineStage.getScene().getWidth(),
                        this.witchDashMainEngineStage.getScene().getY()-this.witchDashMainEngineStage.getScene().getY(),
                        this.witchDashMainEngineStage.getScene().getHeight());
            }

        }
    }


    public void moveFigures(){

    }

    public boolean testIfSameYPosition(ArrayList<Pumpkin> pumpkinsPositionTest,Pumpkin pumpkinPositionTest){
        if(pumpkinsPositionTest.stream().anyMatch(pumpkin -> pumpkin.getRectangle().getY()>=pumpkinPositionTest.getRectangle().getY()) && (pumpkinsPositionTest.stream().anyMatch(pumpkin -> pumpkin.getRectangle().getY()<(pumpkinPositionTest.getRectangle().getY()+pumpkinPositionTest.getRectangle().getHeight())))) {
            return true;
        }
        else{
                return false;
            }
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

    public int getWitchSpeed() {
        return witchSpeed;
    }

    public void setWitchSpeed(int witchSpeed) {
        this.witchSpeed = witchSpeed;
    }

    public int getPumpkinSpeed() {
        return pumpkinSpeed;
    }

    public void setPumpkinSpeed(int pumpkinSpeed) {
        this.pumpkinSpeed = pumpkinSpeed;
    }
}

package trinat.hexenspiel.hexenspiel;

public class Life {

    // life parameter
    private double hitPoints;
    private double initialLives;


    //life Default Constructor
    public Life(){
        initialLives =6;
        hitPoints =0;

    }

    // life Parameter Constructor
    public Life(double initialLives, double hitPoints){
        this.initialLives = initialLives;
        this.hitPoints = hitPoints;
    }

    //ActualLife modification
    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }


    public double getInitialLives() {
        return initialLives;
    }

    //InitialLives modification
    public void setInitialLives(double initialLives) {
        this.initialLives = initialLives;
    }

    //get temporary life
    public double getCurrentLives() {
        return this.initialLives - this.hitPoints;
    }

    public boolean testNoLivesLeft(){
        if(getCurrentLives()==0){
            return true;
        }
        else{
            return false;
        }
    }

    public void addHitPoint(){
        this.hitPoints++;
    }

    public void deleteHitPoint(){
        this.hitPoints--;
    }


}

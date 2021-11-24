package trinat.hexenspiel.hexenspiel;

public class Life {

    // life parameter
    public double inthit_point;
    public double intlife;
    public double inttemporary_life;

    //life declaration
    public Life(){
        intlife =6;
        inthit_point=0;
        inttemporary_life=intlife-inthit_point;
    }

    // life modification
    public Life(double life,double hit_point){
        intlife=life;
        inthit_point=hit_point;
    }

    //Hit_point modification
    public double setHit_point(double hit_point){
        inthit_point=hit_point;
        return inthit_point;
    }
    //life modification
    public double setLife(double life){
        intlife=life;
        return intlife;
    }

    //get Hit_point
    public double getHit_point() {return this.inthit_point;}

    //get Life
    public double getLife() {return this.intlife;}

    //get temporary life
    public double getTemporary_life() {return this.inttemporary_life;}


}

package trinat.hexenspiel.hexenspiel;

public class WitchDashRandomGenerator {

    public static double random(double Min,double Max){
        return Min+=Math.random()*(Max-Min);
    }
}

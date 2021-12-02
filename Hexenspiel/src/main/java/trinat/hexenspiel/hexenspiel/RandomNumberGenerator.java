package trinat.hexenspiel.hexenspiel;

public class RandomNumberGenerator {

    public static double random(double Min,double Max){
        return Min+(Math.random()*(Max-Min));
    }
}
